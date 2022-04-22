package de.kai_morich.usb_terminal;

class Constants {

    // values have to be globally unique
    static final String INTENT_ACTION_GRANT_USB = BuildConfig.APPLICATION_ID + ".GRANT_USB";
    static final String INTENT_ACTION_DISCONNECT = BuildConfig.APPLICATION_ID + ".Disconnect";
    static final String NOTIFICATION_CHANNEL = BuildConfig.APPLICATION_ID + ".Channel";
    static final String INTENT_CLASS_MAIN_ACTIVITY = BuildConfig.APPLICATION_ID + ".MainActivity";

    // values have to be unique within each app
    static final int NOTIFY_MANAGER_START_FOREGROUND_SERVICE = 1001;

    static final int PAGE_SIZE = 15;

    private Constants() {}

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
