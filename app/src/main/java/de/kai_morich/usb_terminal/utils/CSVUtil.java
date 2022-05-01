package de.kai_morich.usb_terminal.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import org.greenrobot.greendao.database.Database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import de.kai_morich.usb_terminal.App;
import de.kai_morich.usb_terminal.entities.DaoSession;
import de.kai_morich.usb_terminal.entities.Signal;
import de.kai_morich.usb_terminal.entities.SignalDao;
import de.kai_morich.usb_terminal.entities.TrialData;
import de.kai_morich.usb_terminal.entities.TrialDataDao;

public class CSVUtil {

    private static String getCsvFilename() {
        return "usb_terminal_signals.csv";
    }

    public static File getDownloadsDirectory() throws Exception {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            File exportDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if (!exportDir.exists()) {
                exportDir.mkdir();
            }
            return exportDir;
        } else {
            throw new Exception("External storage is not mounted.");
        }
    }

    private static void showSavedLocation(Context context, File file) {
        ((Activity) context).runOnUiThread(() -> {
            Toast.makeText(context, "File saved at: " + file.getAbsolutePath(), Toast.LENGTH_LONG).show();
        });
    }

    @SuppressLint({"SimpleDateFormat", "Range"})
    public static void exportSignalsToCSV(Context context, Handler mainHandler) {
        final ProgressDialog[] progressDialog = new ProgressDialog[1];

        try {
            mainHandler.post(() -> {
                progressDialog[0] = new ProgressDialog(context);
                progressDialog[0].setTitle("Exporting as CSV");
                progressDialog[0].setMessage("Please wait...");
                progressDialog[0].setCancelable(false);
                progressDialog[0].setCanceledOnTouchOutside(false);
                progressDialog[0].setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            });

            File exportDir = getDownloadsDirectory();
            String fileName = getCsvFilename();
            File file = new File(exportDir, fileName);
            file.createNewFile();
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));

            DaoSession daoSession = ((App) ((Activity) context).getApplication()).getDaoSession();
            Database database = daoSession.getDatabase();
            Cursor cursor = database.rawQuery("SELECT * FROM signals INNER JOIN trial_data ON trial_data.id = signals.trial_data_id", null);

            mainHandler.post(() -> {
                progressDialog[0].setMax(cursor.getCount());
                progressDialog[0].show();
            });

            csvWriter.writeNext(new String[]{"date", "cadence", "position", "torque", "power", "error", "motor_error", "encoder_error", "axis_state", "app_is_running", "heartbeat_host", "loop_time (us)", "vbus", "iq_setpoint", "iq_measured", "iq_filt", "pedal_torque", "pedal_vel", "pedal_pos", "pedal_power", "encoder_pos", "encoder_vel", "vel_cmd", "acc_cmd", "roadfeel", "damping", "inertia", "torque_cmd", "torque_signal", "test"});
            while (cursor.moveToNext()) {
                csvWriter.writeNext(new String[]{
                        cursor.getString(cursor.getColumnIndex("date")),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("cadence"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("position"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("torque"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("power"))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex("error"))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex("motor_error"))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex("encoder_error"))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex("axis_state"))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex("app_is_running"))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex("heartbeat_host"))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex("loop_time"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("vbus"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("iq_setpoint"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("iq_measured"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("iq_filt"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("pedal_torque"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("pedal_vel"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("pedal_pos"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("pedal_power"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("encoder_pos"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("encoder_vel"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("vel_cmd"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("acc_cmd"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("roadfeel"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("damping"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("inertia"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("torque_cmd"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("torque_signal"))),
                        String.valueOf(cursor.getDouble(cursor.getColumnIndex("test"))),
                });

                mainHandler.post(() -> {
                    progressDialog[0].incrementProgressBy(1);
                    progressDialog[0].incrementSecondaryProgressBy(1);
                });
            }

            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            progressDialog[0].dismiss();
        }
    }

    @SuppressLint("SimpleDateFormat")
    public static void exportTrialDataToCSV(Context context) throws Exception
    {
        File exportDir = getDownloadsDirectory();
        String fileName = "usb_terminal_trial_data.csv";
        File file = new File(exportDir, fileName);
        file.createNewFile();
        CSVWriter csvWriter = new CSVWriter(new FileWriter(file));

        DaoSession daoSession = ((App) ((Activity) context).getApplication()).getDaoSession();
        TrialDataDao trialDataDao = daoSession.getTrialDataDao();
        List<TrialData> trialData = trialDataDao.loadAll();

        csvWriter.writeNext(new String[]{"cadence", "position", "torque", "power", "date"});
        for (TrialData d : trialData) {
            csvWriter.writeNext(new String[]{
                    d.getCadence() != null ? String.valueOf(d.getCadence()) : "",
                    d.getPosition() != null ? String.valueOf(d.getPosition()) : "",
                    d.getTorque() != null ? String.valueOf(d.getTorque()) : "",
                    d.getPower() != null ? String.valueOf(d.getPower()) : "",
                    d.getDate() != null ? new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(d.getDate()) : ""
            });
        }

        csvWriter.close();
        showSavedLocation(context, file);
    }
}
