package de.kai_morich.usb_terminal.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
    public static String toLocalDateTime(Date date) {
        final DateFormat formatter =  DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.LONG, Locale.getDefault());
        return formatter.format(date);
    }
}
