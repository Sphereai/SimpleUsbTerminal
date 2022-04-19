package de.kai_morich.usb_terminal.libs.excel;

public interface ExportListener {
    void onStart();
    void onCompleted(String filePath);
    void onError(Exception e);
}
