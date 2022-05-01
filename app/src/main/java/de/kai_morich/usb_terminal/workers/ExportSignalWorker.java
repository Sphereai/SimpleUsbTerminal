package de.kai_morich.usb_terminal.workers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

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

    private int dateIndex;
    private int cadenceIndex;
    private int positionIndex;
    private int torqueIndex;
    private int powerIndex;
    private int errorIndex;
    private int motorErrorIndex;
    private int encoderErrorIndex;
    private int axisStateIndex;
    private int appIsRunningIndex;
    private int heartbeatHostIndex;
    private int loopTimeIndex;
    private int vbusIndex;
    private int iqSetpointIndex;
    private int iqMeasuredIndex;
    private int iqFiltIndex;
    private int pedalTorqueIndex;
    private int pedalVelIndex;
    private int pedalPosIndex;
    private int pedalPowerIndex;
    private int encoderPosIndex;
    private int encoderVelIndex;
    private int velCmdIndex;
    private int accCmdIndex;
    private int roadfeelIndex;
    private int dampingIndex;
    private int inertiaIndex;
    private int torqueCmdIndex;
    private int torqueSignalIndex;
    private int testIndex;

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

        boolean status = false;
        long trialId = getInputData().getLong(Constants.AppKeys.KEY_TRIAL_ID, 0);
        int trialNumber = getInputData().getInt(Constants.AppKeys.KEY_TRIAL_NUMBER, 0);

        App app = (App) context.getApplicationContext();
        Cursor cursor = DatabaseManager.getSignalsQuery(app, trialId);

        try {
            String dirPath = CSVUtil.getDownloadsDirectory() + File.separator;
            ExcelExporter exporter = new ExcelExporter(dirPath, String.format(Locale.getDefault(), "%d_trial_data_signals.xlsx", trialNumber), "trials_signals");
            exporter.addHeadersRow(new ArrayList<>(Arrays.asList("date", "cadence", "position", "torque", "power", "error", "motor_error", "encoder_error", "axis_state", "app_is_running", "heartbeat_host", "loop_time (us)", "vbus", "iq_setpoint", "iq_measured", "iq_filt", "pedal_torque", "pedal_vel", "pedal_pos", "pedal_power", "encoder_pos", "encoder_vel", "vel_cmd", "acc_cmd", "roadfeel", "damping", "inertia", "torque_cmd", "torque_signal", "test")));
            setCursorIndex(cursor);

            int rowNumber = 1;
            int count = cursor.getCount();

            while (cursor.moveToNext()) {
                List<RowData> cols = new ArrayList<>();
                cols.add(new RowData(CellType.String, cursor.isNull(dateIndex) ? null : cursor.getString(dateIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(cadenceIndex) ? null : cursor.getDouble(cadenceIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(positionIndex) ? null : cursor.getDouble(positionIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(torqueIndex) ? null : cursor.getDouble(torqueIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(powerIndex) ? null : cursor.getDouble(powerIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(errorIndex) ? null : (double) cursor.getInt(errorIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(motorErrorIndex) ? null : (double) cursor.getInt(motorErrorIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(encoderErrorIndex) ? null : (double) cursor.getInt(encoderErrorIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(axisStateIndex) ? null : (double) cursor.getInt(axisStateIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(appIsRunningIndex) ? null : (double) cursor.getInt(appIsRunningIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(heartbeatHostIndex) ? null : (double) cursor.getInt(heartbeatHostIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(loopTimeIndex) ? null : (double) cursor.getInt(loopTimeIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(vbusIndex) ? null : cursor.getDouble(vbusIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(iqSetpointIndex) ? null : cursor.getDouble(iqSetpointIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(iqMeasuredIndex) ? null : cursor.getDouble(iqMeasuredIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(iqFiltIndex) ? null : cursor.getDouble(iqFiltIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(pedalTorqueIndex) ? null : cursor.getDouble(pedalTorqueIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(pedalVelIndex) ? null : cursor.getDouble(pedalVelIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(pedalPosIndex) ? null : cursor.getDouble(pedalPosIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(pedalPowerIndex) ? null : cursor.getDouble(pedalPowerIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(encoderPosIndex) ? null : cursor.getDouble(encoderPosIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(encoderVelIndex) ? null : cursor.getDouble(encoderVelIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(velCmdIndex) ? null : cursor.getDouble(velCmdIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(accCmdIndex) ? null : cursor.getDouble(accCmdIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(roadfeelIndex) ? null : cursor.getDouble(roadfeelIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(dampingIndex) ? null : cursor.getDouble(dampingIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(inertiaIndex) ? null : cursor.getDouble(inertiaIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(torqueCmdIndex) ? null : cursor.getDouble(torqueCmdIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(torqueSignalIndex) ? null : cursor.getDouble(torqueSignalIndex)));
                cols.add(new RowData(CellType.Double, cursor.isNull(testIndex) ? null : cursor.getDouble(testIndex)));

                exporter.addRow(rowNumber, cols);

                showProgress(count, rowNumber);
                rowNumber++;
            }

            exporter.export();
            status = true;

        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        } finally {
            cursor.close();
        }

        return status;
    }

    private void showProgress(int total, int progress) {
        if (progress == total) {
            notificationUtil.setCompletion(NOTIFICATION_CONTENT_COMPLETION);
        } else {
            notificationUtil.updateProgress(total, progress);
        }
    }

    private void setCursorIndex(Cursor cursor) {
        dateIndex = cursor.getColumnIndex("date");
        cadenceIndex = cursor.getColumnIndex("cadence");
        positionIndex = cursor.getColumnIndex("position");
        torqueIndex = cursor.getColumnIndex("torque");
        powerIndex = cursor.getColumnIndex("power");
        errorIndex = cursor.getColumnIndex("error");
        motorErrorIndex = cursor.getColumnIndex("motor_error");
        encoderErrorIndex = cursor.getColumnIndex("encoder_error");
        axisStateIndex = cursor.getColumnIndex("axis_state");
        appIsRunningIndex = cursor.getColumnIndex("app_is_running");
        heartbeatHostIndex = cursor.getColumnIndex("heartbeat_host");
        loopTimeIndex = cursor.getColumnIndex("loop_time");
        vbusIndex = cursor.getColumnIndex("vbus");
        iqSetpointIndex = cursor.getColumnIndex("iq_setpoint");
        iqMeasuredIndex = cursor.getColumnIndex("iq_measured");
        iqFiltIndex = cursor.getColumnIndex("iq_filt");
        pedalTorqueIndex = cursor.getColumnIndex("pedal_torque");
        pedalVelIndex = cursor.getColumnIndex("pedal_vel");
        pedalPosIndex = cursor.getColumnIndex("pedal_pos");
        pedalPowerIndex = cursor.getColumnIndex("pedal_power");
        encoderPosIndex = cursor.getColumnIndex("encoder_pos");
        encoderVelIndex = cursor.getColumnIndex("encoder_vel");
        velCmdIndex = cursor.getColumnIndex("vel_cmd");
        accCmdIndex = cursor.getColumnIndex("acc_cmd");
        roadfeelIndex = cursor.getColumnIndex("roadfeel");
        dampingIndex = cursor.getColumnIndex("damping");
        inertiaIndex = cursor.getColumnIndex("inertia");
        torqueCmdIndex = cursor.getColumnIndex("torque_cmd");
        torqueSignalIndex = cursor.getColumnIndex("torque_signal");
        testIndex = cursor.getColumnIndex("test");
    }
}
