package de.kai_morich.usb_terminal.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
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

    @SuppressLint("SimpleDateFormat")
    public static void exportSignalsToCSV(Context context) throws Exception {
        File exportDir = getDownloadsDirectory();
        String fileName = getCsvFilename();
        File file = new File(exportDir, fileName);
        file.createNewFile();
        CSVWriter csvWriter = new CSVWriter(new FileWriter(file));

        DaoSession daoSession = ((App) ((Activity) context).getApplication()).getDaoSession();
        SignalDao signalDao = daoSession.getSignalDao();
        List<Signal> signals = signalDao.loadAll();

        csvWriter.writeNext(new String[]{"type", "key", "value", "unit"});
        for (Signal signal : signals) {
            csvWriter.writeNext(new String[]{
                    signal.getType(),
                    signal.getKey(),
                    signal.getValue(),
                    signal.getUnits()
            });
        }

        csvWriter.close();
        showSavedLocation(context, file);
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
