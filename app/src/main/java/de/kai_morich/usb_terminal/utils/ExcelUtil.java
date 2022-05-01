package de.kai_morich.usb_terminal.utils;

import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.kai_morich.usb_terminal.App;
import de.kai_morich.usb_terminal.MainActivity;

public class ExcelUtil {

    private static int dateIndex;
    private static int cadenceIndex;
    private static int positionIndex;
    private static int torqueIndex;
    private static int powerIndex;
    private static int errorIndex;
    private static int motorErrorIndex;
    private static int encoderErrorIndex;
    private static int axisStateIndex;
    private static int appIsRunningIndex;
    private static int heartbeatHostIndex;
    private static int loopTimeIndex;
    private static int vbusIndex;
    private static int iqSetpointIndex;
    private static int iqMeasuredIndex;
    private static int iqFiltIndex;
    private static int pedalTorqueIndex;
    private static int pedalVelIndex;
    private static int pedalPosIndex;
    private static int pedalPowerIndex;
    private static int encoderPosIndex;
    private static int encoderVelIndex;
    private static int velCmdIndex;
    private static int accCmdIndex;
    private static int roadfeelIndex;
    private static int dampingIndex;
    private static int inertiaIndex;
    private static int torqueCmdIndex;
    private static int torqueSignalIndex;
    private static int testIndex;

    private static int rowNumber;

    public static void exportAllSignals(MainActivity activity, long trialId, int trialNumber) {

        System.setProperty("org.apache.poi.javax.xml.stream.XMLInputFactory", "com.fasterxml.aalto.stax.InputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLOutputFactory", "com.fasterxml.aalto.stax.OutputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLEventFactory", "com.fasterxml.aalto.stax.EventFactoryImpl");

        App app = (App) activity.getApplicationContext();
        Cursor cursor = DatabaseManager.getSignalsQuery(app, trialId);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        int count = cursor.getCount();
        activity.showProgressBar(true);
        activity.setMaxValue(count);

        executor.execute(() -> {
            try {
                String dirPath = CSVUtil.getDownloadsDirectory() + File.separator;
                String fileName = String.format(Locale.getDefault(), "%d_trial_data_signals.xlsx", trialNumber);

                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("trials_signals");
                XSSFRow headerRow = (XSSFRow) sheet.createRow(0);

                List<String> headers = new ArrayList<>(Arrays.asList("date", "cadence", "position", "torque", "power", "error", "motor_error", "encoder_error", "axis_state", "app_is_running", "heartbeat_host", "loop_time (us)", "vbus", "iq_setpoint", "iq_measured", "iq_filt", "pedal_torque", "pedal_vel", "pedal_pos", "pedal_power", "encoder_pos", "encoder_vel", "vel_cmd", "acc_cmd", "roadfeel", "damping", "inertia", "torque_cmd", "torque_signal", "test"));

                for (int index = 0; index < headers.size(); index++) {
                    XSSFCell cell = headerRow.createCell(index);
                    cell.setCellValue(headers.get(index));
                }

                setCursorIndexes(cursor);

                Row row;
                rowNumber = 1;

                while (cursor.moveToNext()) {
                    row = sheet.createRow(rowNumber);
                    row.createCell(0).setCellValue(cursor.isNull(dateIndex) ? "" : cursor.getString(dateIndex));

                    if (cursor.isNull(cadenceIndex))
                        row.createCell(1);
                    else
                        row.createCell(1).setCellValue(cursor.getDouble(cadenceIndex));

                    if (cursor.isNull(positionIndex))
                        row.createCell(2);
                    else
                        row.createCell(2).setCellValue(cursor.getDouble(positionIndex));

                    if (cursor.isNull(torqueIndex))
                        row.createCell(3);
                    else
                        row.createCell(3).setCellValue(cursor.getDouble(torqueIndex));

                    if (cursor.isNull(powerIndex))
                        row.createCell(4);
                    else
                        row.createCell(4).setCellValue(cursor.getDouble(powerIndex));

                    if (cursor.isNull(errorIndex))
                        row.createCell(5);
                    else
                        row.createCell(5).setCellValue((double) cursor.getInt(errorIndex));

                    if (cursor.isNull(motorErrorIndex))
                        row.createCell(6);
                    else
                        row.createCell(6).setCellValue((double) cursor.getInt(motorErrorIndex));

                    if (cursor.isNull(encoderErrorIndex))
                        row.createCell(7);
                    else
                        row.createCell(7).setCellValue((double) cursor.getInt(encoderErrorIndex));

                    if (cursor.isNull(axisStateIndex))
                        row.createCell(8);
                    else
                        row.createCell(8).setCellValue((double) cursor.getInt(axisStateIndex));

                    if (cursor.isNull(appIsRunningIndex))
                        row.createCell(9);
                    else
                        row.createCell(9).setCellValue((double) cursor.getInt(appIsRunningIndex));

                    if (cursor.isNull(heartbeatHostIndex))
                        row.createCell(10);
                    else
                        row.createCell(10).setCellValue((double) cursor.getInt(heartbeatHostIndex));

                    if (cursor.isNull(loopTimeIndex))
                        row.createCell(11);
                    else
                        row.createCell(11).setCellValue((double) cursor.getInt(loopTimeIndex));

                    if (cursor.isNull(vbusIndex))
                        row.createCell(12);
                    else
                        row.createCell(12).setCellValue(cursor.getDouble(vbusIndex));

                    if (cursor.isNull(iqSetpointIndex))
                        row.createCell(13);
                    else
                        row.createCell(13).setCellValue(cursor.getDouble(iqSetpointIndex));

                    if (cursor.isNull(iqMeasuredIndex))
                        row.createCell(14);
                    else
                        row.createCell(14).setCellValue(cursor.getDouble(iqMeasuredIndex));

                    if (cursor.isNull(iqFiltIndex))
                        row.createCell(15);
                    else
                        row.createCell(15).setCellValue(cursor.getDouble(iqFiltIndex));

                    if (cursor.isNull(pedalTorqueIndex))
                        row.createCell(16);
                    else
                        row.createCell(16).setCellValue(cursor.getDouble(pedalTorqueIndex));

                    if (cursor.isNull(pedalVelIndex))
                        row.createCell(17);
                    else
                        row.createCell(17).setCellValue(cursor.getDouble(pedalVelIndex));

                    if (cursor.isNull(pedalPosIndex))
                        row.createCell(18);
                    else
                        row.createCell(18).setCellValue(cursor.getDouble(pedalPosIndex));

                    if (cursor.isNull(pedalPowerIndex))
                        row.createCell(19);
                    else
                        row.createCell(19).setCellValue(cursor.getDouble(pedalPowerIndex));

                    if (cursor.isNull(encoderPosIndex))
                        row.createCell(20);
                    else
                        row.createCell(20).setCellValue(cursor.getDouble(encoderPosIndex));

                    if (cursor.isNull(encoderVelIndex))
                        row.createCell(21);
                    else
                        row.createCell(21).setCellValue(cursor.getDouble(encoderVelIndex));

                    if (cursor.isNull(velCmdIndex))
                        row.createCell(22);
                    else
                        row.createCell(22).setCellValue(cursor.getDouble(velCmdIndex));

                    if (cursor.isNull(accCmdIndex))
                        row.createCell(23);
                    else
                        row.createCell(23).setCellValue(cursor.getDouble(accCmdIndex));

                    if (cursor.isNull(roadfeelIndex))
                        row.createCell(24);
                    else
                        row.createCell(24).setCellValue(cursor.getDouble(roadfeelIndex));

                    if (cursor.isNull(dampingIndex))
                        row.createCell(25);
                    else
                        row.createCell(25).setCellValue(cursor.getDouble(dampingIndex));

                    if (cursor.isNull(inertiaIndex))
                        row.createCell(26);
                    else
                        row.createCell(26).setCellValue(cursor.getDouble(inertiaIndex));

                    if (cursor.isNull(torqueCmdIndex))
                        row.createCell(27);
                    else
                        row.createCell(27).setCellValue(cursor.getDouble(torqueCmdIndex));

                    if (cursor.isNull(torqueSignalIndex))
                        row.createCell(28);
                    else
                        row.createCell(28).setCellValue(cursor.getDouble(torqueSignalIndex));

                    if (cursor.isNull(testIndex))
                        row.createCell(29);
                    else
                        row.createCell(29).setCellValue(cursor.getDouble(testIndex));

                    handler.post(() -> activity.setProgressValue(rowNumber));
                    rowNumber++;
                }

                File file = new File(dirPath, fileName);
                FileOutputStream fos = new FileOutputStream(file);
                workbook.write(fos);
                fos.flush();
                fos.close();
                workbook.close();

            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e);
            } finally {
                cursor.close();
                handler.post(() -> activity.showProgressBar(false));
            }
        });
    }

    private static void setCursorIndexes(Cursor cursor) {
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
