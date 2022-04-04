package de.kai_morich.usb_terminal.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class CSVUtil {

    private static String getCsvFilename() {
        return "usb_terminal_signals.csv";
    }

    private static File getExternalFile() throws Exception {
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
        File exportDir = getExternalFile();
        String fileName = getCsvFilename();
        File file = new File(exportDir, fileName);
        file.createNewFile();
        CSVWriter csvWriter = new CSVWriter(new FileWriter(file));

        DaoSession daoSession = ((App) ((Activity) context).getApplication()).getDaoSession();
        SignalDao signalDao = daoSession.getSignalDao();
        List<Signal> signals = signalDao.loadAll();

        csvWriter.writeNext(new String[]{"type", "key", "value", "unit", "date"});
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
}
