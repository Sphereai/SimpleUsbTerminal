package de.kai_morich.usb_terminal.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "signals")
public class Signal {

    @Id(autoincrement = true)
    @Property(nameInDb = "id")
    private Long id;

    @NotNull
    @Property(nameInDb = "device_id")
    private int deviceId;

    @NotNull
    @Property(nameInDb = "type")
    private String type;

    @NotNull
    @Property(nameInDb = "key")
    private String key;

    @NotNull
    @Property(nameInDb = "value")
    private String value;

    @NotNull
    @Property(nameInDb = "units")
    private String units;

    @Property(nameInDb = "date")
    private Date date;

    @Generated(hash = 292048286)
    public Signal(Long id, int deviceId, @NotNull String type, @NotNull String key,
            @NotNull String value, @NotNull String units, Date date) {
        this.id = id;
        this.deviceId = deviceId;
        this.type = type;
        this.key = key;
        this.value = value;
        this.units = units;
        this.date = date;
    }

    @Generated(hash = 783005292)
    public Signal() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnits() {
        return this.units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }
}
