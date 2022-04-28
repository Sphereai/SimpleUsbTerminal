package de.kai_morich.usb_terminal;

public class Constants {

    // values have to be globally unique
    static final String INTENT_ACTION_GRANT_USB = BuildConfig.APPLICATION_ID + ".GRANT_USB";
    static final String INTENT_ACTION_DISCONNECT = BuildConfig.APPLICATION_ID + ".Disconnect";
    static final String NOTIFICATION_CHANNEL = BuildConfig.APPLICATION_ID + ".Channel";
    static final String INTENT_CLASS_MAIN_ACTIVITY = BuildConfig.APPLICATION_ID + ".MainActivity";

    // values have to be unique within each app
    static final int NOTIFY_MANAGER_START_FOREGROUND_SERVICE = 1001;

    static final int PAGE_SIZE = 15;

    private Constants() {}

    public static class AppKeys {
        public static final String KEY_TRIAL_ID = "trial_id";
        public static final String KEY_TRIAL_NUMBER = "trial_number";
    }

    public static class Notification {
        public static final int NOTIFICATION_ID = 1;
        public static final String CHANNEL_ID = BuildConfig.APPLICATION_ID + ".channel";
        public static final String CHANNEL_NAME = "Background Task Notifications";
        public static final String CHANNEL_DESCRIPTION = "Show notifications whenever long running task starts";
    }

    public static class SignalType {
        static final String UINT = "uint";
        static final String INT = "int";
        static final String DOUBLE = "double";
    }

    public static class Resistance {
        static final Double DAMPING = 0.5;
        static final Double INERTIA = 10.0;
        static final Double TORQUE = 0.0;
    }
}
