package de.kai_morich.usb_terminal.entities;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

public class SignalRecord {
    @Id(autoincrement = true)
    @Property(nameInDb = "id")
    private Long id;

    private long trialDataId;
}
