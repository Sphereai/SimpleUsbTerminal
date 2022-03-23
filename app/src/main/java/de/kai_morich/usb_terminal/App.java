package de.kai_morich.usb_terminal;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import de.kai_morich.usb_terminal.entities.DaoMaster;
import de.kai_morich.usb_terminal.entities.DaoSession;

public class App extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "signals-db");
        Database db = helper.getWritableDb();

        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
