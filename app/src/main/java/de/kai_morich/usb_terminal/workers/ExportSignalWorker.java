package de.kai_morich.usb_terminal.workers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import org.greenrobot.greendao.database.Database;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import de.kai_morich.usb_terminal.App;
import de.kai_morich.usb_terminal.Constants;
import de.kai_morich.usb_terminal.SignalModel;
import de.kai_morich.usb_terminal.libs.excel.CellType;
import de.kai_morich.usb_terminal.libs.excel.ExcelExporter;
import de.kai_morich.usb_terminal.libs.excel.RowData;
import de.kai_morich.usb_terminal.utils.CSVUtil;
import de.kai_morich.usb_terminal.utils.DatabaseManager;
import de.kai_morich.usb_terminal.utils.NotificationUtil;

public class ExportSignalWorker extends Worker {
    private final Context context;
    private NotificationUtil notificationUtil;

    private static final String NOTIFICATION_TITLE = "Exporting Signals Data";
    private static final String NOTIFICATION_CONTENT = "Please wait...";
    private static final String NOTIFICATION_CONTENT_COMPLETION = "Exporting Complete";

    public ExportSignalWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        notificationUtil = new NotificationUtil(context);
        notificationUtil.setTitleAndContent(NOTIFICATION_TITLE, NOTIFICATION_CONTENT);
        boolean status = exportAllSignalsToExcel();
        if (status) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }

    @SuppressLint("Range")
    private boolean exportAllSignalsToExcel() {

        long trialId = getInputData().getLong(Constants.AppKeys.KEY_TRIAL_ID, 0);
        int trialNumber = getInputData().getInt(Constants.AppKeys.KEY_TRIAL_NUMBER, 0);

        App app = (App) context.getApplicationContext();
        List<Integer> distinctTrialIds = DatabaseManager.getDistinctTrialDataIdFromSignals(app, trialId);


        try {
            String dirPath = CSVUtil.getDownloadsDirectory() + File.separator;
            ExcelExporter exporter = new ExcelExporter(dirPath, String.format(Locale.getDefault(), "%d_trial_data_signals.xlsx", trialNumber), "trials_signals");
            exporter.addHeadersRow(new ArrayList<>(Arrays.asList("date", "cadence", "position", "torque", "power", "error", "motor_error", "encoder_error", "axis_state", "app_is_running", "heartbeat_host", "loop_time (us)", "vbus", "iq_setpoint", "iq_measured", "iq_filt", "pedal_torque", "pedal_vel", "pedal_pos", "pedal_power", "encoder_pos", "encoder_vel", "vel_cmd", "acc_cmd", "roadfeel", "damping", "inertia", "torque_cmd", "torque_signal", "test")));

            String commaSeparatedIds = de.kai_morich.usb_terminal.utils.TextUtil.toCommaSeparatedString(distinctTrialIds);

            Database database = app.getDaoSession().getDatabase();
            String query = String.format("SELECT TRIAL_DATA_ID, TD.cadence, TD.position, TD.torque, TD.power, TD.date, group_concat(concat) AS concatenated FROM (SELECT TRIAL_DATA_ID, key || '|' || value || '|' || units as concat FROM signals) AS S INNER JOIN trial_data AS TD ON S.TRIAL_DATA_ID = TD.id WHERE TRIAL_DATA_ID IN (%s) GROUP BY TRIAL_DATA_ID", commaSeparatedIds);
            Cursor cursor = database.rawQuery(query, null);

            int rowNumber = 1;
            int count = cursor.getCount();

            while (cursor.moveToNext()) {
                String concatenatedString = cursor.getString(cursor.getColumnIndex("concatenated"));
                HashMap<String, SignalModel> signals = tokenizeConcatenatedString(concatenatedString);

                Double error = 0.0;
                if (signals.get("error") != null) {
                    String strError = signals.get("error").getValue();
                    error = (strError == null || strError.isEmpty()) ? null : Double.valueOf(strError);
                }

                Double motorError = 0.0;
                if (signals.get("motor_error") != null) {
                    String strMotorError = signals.get("motor_error").getValue();
                    motorError = (strMotorError == null || strMotorError.isEmpty()) ? null : Double.valueOf(strMotorError);
                }

                Double encoderError = 0.0;
                if (signals.get("encoder_error") != null) {
                    String strEncoderError = signals.get("encoder_error").getValue();
                    encoderError = (strEncoderError == null || strEncoderError.isEmpty()) ? null : Double.valueOf(strEncoderError);
                }

                Double axisState = 0.0;
                if (signals.get("axis_state") != null) {
                    String strAxisState = signals.get("axis_state").getValue();
                    axisState = (strAxisState == null || strAxisState.isEmpty()) ? null : Double.valueOf(strAxisState);
                }

                Double appIsRunning = 0.0;
                if (signals.get("app_is_running") != null) {
                    String strAppIsRunning = signals.get("app_is_running").getValue();
                    appIsRunning = (strAppIsRunning == null || strAppIsRunning.isEmpty()) ? null : Double.valueOf(strAppIsRunning);
                }

                Double heartBeatHost = 0.0;
                if (signals.get("heartbeat_host") != null) {
                    String strHeartBeatHost = signals.get("heartbeat_host").getValue();
                    heartBeatHost = (strHeartBeatHost == null || strHeartBeatHost.isEmpty()) ? null : Double.valueOf(strHeartBeatHost);
                }

                Double loopTime = 0.0;
                if (signals.get("loop_time") != null) {
                    String strLoopTime = signals.get("loop_time").getValue();
                    loopTime = (strLoopTime == null || strLoopTime.isEmpty()) ? null : Double.valueOf(strLoopTime);
                }

                Double vBus = 0.0;
                if (signals.get("vbus") != null) {
                    String strVBus = signals.get("vbus").getValue();
                    vBus = (strVBus == null || strVBus.isEmpty()) ? null : Double.valueOf(strVBus);
                }

                Double iqSetPoint = 0.0;
                if (signals.get("iq_setpoint") != null) {
                    String strIqSetPoint = signals.get("iq_setpoint").getValue();
                    iqSetPoint = (strIqSetPoint == null || strIqSetPoint.isEmpty()) ? null : Double.valueOf(strIqSetPoint);
                }

                Double iqMeasured = 0.0;
                if (signals.get("iq_measured") != null) {
                    String strIqMeasured = signals.get("iq_measured").getValue();
                    iqMeasured = (strIqMeasured == null || strIqMeasured.isEmpty()) ? null : Double.valueOf(strIqMeasured);
                }

                Double iqFilt = 0.0;
                if (signals.get("iq_filt") != null) {
                    String strIqFilt = signals.get("iq_filt").getValue();
                    iqFilt = (strIqFilt == null || strIqFilt.isEmpty()) ? null : Double.valueOf(strIqFilt);
                }

                Double pedalTorque = 0.0;
                if (signals.get("pedal_torque") != null) {
                    String strPedalTorque = signals.get("pedal_torque").getValue();
                    pedalTorque = (strPedalTorque == null || strPedalTorque.isEmpty()) ? null : Double.valueOf(strPedalTorque);
                }

                Double pedalVel = 0.0;
                if (signals.get("pedal_vel") != null) {
                    String strPedalVel = signals.get("pedal_vel").getValue();
                    pedalVel = (strPedalVel == null || strPedalVel.isEmpty()) ? null : Double.valueOf(strPedalVel);
                }

                Double pedalPos = 0.0;
                if (signals.get("pedal_pos") != null) {
                    String strPedalPos = signals.get("pedal_pos").getValue();
                    pedalPos = (strPedalPos == null || strPedalPos.isEmpty()) ? null : Double.valueOf(strPedalPos);
                }

                Double pedalPower = 0.0;
                if (signals.get("pedal_power") != null) {
                    String strPedalPower = signals.get("pedal_power").getValue();
                    pedalPower = (strPedalPower == null || strPedalPower.isEmpty()) ? null : Double.valueOf(strPedalPower);
                }

                Double encoderPos = 0.0;
                if (signals.get("encoder_pos") != null) {
                    String strEncoderPos = signals.get("encoder_pos").getValue();
                    encoderPos = (strEncoderPos == null || strEncoderPos.isEmpty()) ? null : Double.valueOf(strEncoderPos);
                }

                Double encoderVel = 0.0;
                if (signals.get("encoder_vel") != null) {
                    String strEncoderVel = signals.get("encoder_vel").getValue();
                    encoderVel = (strEncoderVel == null || strEncoderVel.isEmpty()) ? null : Double.valueOf(strEncoderVel);
                }

                Double velCmd = 0.0;
                if (signals.get("vel_cmd") != null) {
                    String strVelCmd = signals.get("vel_cmd").getValue();
                    velCmd = (strVelCmd == null || strVelCmd.isEmpty()) ? null : Double.valueOf(strVelCmd);
                }

                Double accCmd = 0.0;
                if (signals.get("acc_cmd") != null) {
                    String strAccCmd = signals.get("acc_cmd").getValue();
                    accCmd = (strAccCmd == null || strAccCmd.isEmpty()) ? null : Double.valueOf(strAccCmd);
                }

                Double roadFeel = 0.0;
                if (signals.get("roadfeel") != null) {
                    String strRoadFeed = signals.get("roadfeel").getValue();
                    roadFeel = (strRoadFeed == null || strRoadFeed.isEmpty()) ? null : Double.valueOf(strRoadFeed);
                }

                Double damping = 0.0;
                if (signals.get("damping") != null) {
                    String strDamping = signals.get("damping").getValue();
                    damping = (strDamping == null || strDamping.isEmpty()) ? null : Double.valueOf(strDamping);
                }

                Double inertia = 0.0;
                if (signals.get("inertia") != null) {
                    String strInertia = signals.get("inertia").getValue();
                    inertia = (strInertia == null || strInertia.isEmpty()) ? null : Double.valueOf(strInertia);
                }

                Double torqueCmd = 0.0;
                if (signals.get("torque_cmd") != null) {
                    String strTorqueCmd = signals.get("torque_cmd").getValue();
                    torqueCmd = (strTorqueCmd == null || strTorqueCmd.isEmpty()) ? null : Double.valueOf(strTorqueCmd);
                }

                Double torqueSignal = 0.0;
                if (signals.get("torque_signal") != null) {
                    String strTorqueSignal = signals.get("torque_signal").getValue();
                    torqueSignal = (strTorqueSignal == null || strTorqueSignal.isEmpty()) ? null : Double.valueOf(strTorqueSignal);
                }

                Double test = 0.0;
                if (signals.get("test") != null) {
                    String strTest = signals.get("test").getValue();
                    test = (strTest == null || strTest.isEmpty()) ? null : Double.valueOf(strTest);
                }

                List<RowData> cols = new ArrayList<>();
                cols.add(new RowData(CellType.String, cursor.getString(cursor.getColumnIndex("date"))));
                cols.add(new RowData(CellType.Double, cursor.getDouble(cursor.getColumnIndex("cadence"))));
                cols.add(new RowData(CellType.Double, cursor.getDouble(cursor.getColumnIndex("position"))));
                cols.add(new RowData(CellType.Double, cursor.getDouble(cursor.getColumnIndex("torque"))));
                cols.add(new RowData(CellType.Double, cursor.getDouble(cursor.getColumnIndex("power"))));
                cols.add(new RowData(CellType.Double, error));
                cols.add(new RowData(CellType.Double, motorError));
                cols.add(new RowData(CellType.Double, encoderError));
                cols.add(new RowData(CellType.Double, axisState));
                cols.add(new RowData(CellType.Double, appIsRunning));
                cols.add(new RowData(CellType.Double, heartBeatHost));
                cols.add(new RowData(CellType.Double, loopTime));
                cols.add(new RowData(CellType.Double, vBus));
                cols.add(new RowData(CellType.Double, iqSetPoint));
                cols.add(new RowData(CellType.Double, iqMeasured));
                cols.add(new RowData(CellType.Double, iqFilt));
                cols.add(new RowData(CellType.Double, pedalTorque));
                cols.add(new RowData(CellType.Double, pedalVel));
                cols.add(new RowData(CellType.Double, pedalPos));
                cols.add(new RowData(CellType.Double, pedalPower));
                cols.add(new RowData(CellType.Double, encoderPos));
                cols.add(new RowData(CellType.Double, encoderVel));
                cols.add(new RowData(CellType.Double, velCmd));
                cols.add(new RowData(CellType.Double, accCmd));
                cols.add(new RowData(CellType.Double, roadFeel));
                cols.add(new RowData(CellType.Double, damping));
                cols.add(new RowData(CellType.Double, inertia));
                cols.add(new RowData(CellType.Double, torqueCmd));
                cols.add(new RowData(CellType.Double, torqueSignal));
                cols.add(new RowData(CellType.Double, test));

                exporter.addRow(rowNumber, cols);

                showProgress(count, rowNumber);
                rowNumber++;
            }
            cursor.close();

            exporter.export();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
            return false;
        }
    }

    private void showProgress(int total, int value) {
        int percent = (value * 100) / total;
        if (percent == 100) {
            notificationUtil.setCompletion(NOTIFICATION_CONTENT_COMPLETION);
        } else {
            notificationUtil.updateProgress(percent);
        }
    }

    private HashMap<String, SignalModel> tokenizeConcatenatedString(String str) {
        HashMap<String, SignalModel> signals = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(str, ",");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            String[] signalTokens = token.split("\\|");

            // See query, we concat signal as key|value|unit
            String key = signalTokens[0];
            String value = signalTokens[1];
            String unit = signalTokens.length == 3 ? signalTokens[2] : "";
            signals.put(key, new SignalModel(key, unit, value));
        }

        return signals;
    }
}
