package de.kai_morich.usb_terminal.utils;

import android.database.Cursor;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;

import de.kai_morich.usb_terminal.App;

public class DatabaseManager {

    public static List<Integer> getDistinctTrialDataIdFromSignals(App app, long trialId) {
        List<Integer> trialDataIds = new ArrayList<>();
        Database database = app.getDaoSession().getDatabase();
        Cursor cursor = database.rawQuery("SELECT DISTINCT trial_data_id FROM signals WHERE EXISTS (SELECT * FROM trial_data WHERE trial_data.id = signals.trial_data_id AND trial_data.trial_id = ?)", new String[] {String.valueOf(trialId)});
        while (cursor.moveToNext()) {
            trialDataIds.add(cursor.getInt(0));
        }
        cursor.close();
        return trialDataIds;
    }

    public static Cursor getSignalsQuery(App app, long trialId) {
        Database database = app.getDaoSession().getDatabase();
        return database.rawQuery("SELECT * FROM signals INNER JOIN trial_data ON trial_data.id = signals.trial_data_id where trial_data.trial_id = ?", new String[] {String.valueOf(trialId)});
    }
}
