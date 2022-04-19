package de.kai_morich.usb_terminal.libs.excel;

import androidx.annotation.NonNull;

public class RowData {
    private CellType cellType;
    private Object data;

    public RowData() {
    }

    public RowData(CellType cellType, Object data) {
        this.cellType = cellType;
        this.data = data;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @NonNull
    @Override
    public String toString() {
        return "RowData{" + "cellType=" + cellType + ", data=" + data + '}';
    }
}
