package de.kai_morich.usb_terminal.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "config")
public class Config {
    @Id(autoincrement = true)
    @Property(nameInDb = "id")
    private Long id;

    @Property(nameInDb = "key")
    private String key;

    @Property(nameInDb = "value")
    private String value;

    @Property(nameInDb = "description")
    private String description;

    @Generated(hash = 1412199968)
    public Config(Long id, String key, String value, String description) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.description = description;
    }

    @Generated(hash = 589037648)
    public Config() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
