package de.kai_morich.usb_terminal;

public class SignalModel {
    private String key;
    private String unit;
    private String value;

    public SignalModel(String key, String unit, String value) {
        this.key = key;
        this.unit = unit;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
