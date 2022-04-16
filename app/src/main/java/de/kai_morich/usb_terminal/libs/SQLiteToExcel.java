package de.kai_morich.usb_terminal.libs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SQLiteToExcel {

    private static Handler handler = new Handler(Looper.getMainLooper());

    private SQLiteDatabase database;
    private String mExportPath;
    private XSSFWorkbook workbook;

    private List<String> mExcludeColumns = null;
    private HashMap<String, String> mPrettyNameMapping = null;
    private ExportCustomFormatter mCustomFormatter = null;

    public SQLiteToExcel(Context context, String dbName) {
        this(context, dbName, Environment.getExternalStorageDirectory().toString() + File.separator);
    }

    public SQLiteToExcel(Context context, String dbName, String exportPath) {
        mExportPath = exportPath;
        try {
            database = SQLiteDatabase.openOrCreateDatabase(context.getDatabasePath(dbName).getAbsolutePath(), null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setExcludeColumns(List<String> excludeColumns) {
        mExcludeColumns = excludeColumns;
    }

    public void setPrettyNameMapping(HashMap<String, String> prettyNameMapping) {
        mPrettyNameMapping = prettyNameMapping;
    }

    public void setCustomFormatter(ExportCustomFormatter customFormatter) {
        mCustomFormatter = customFormatter;
    }

    private ArrayList<String> getAllTables() {
        ArrayList<String> tables = new ArrayList<>();
        Cursor cursor = database.rawQuery("select name from sqlite_master where type='table' order by name", null);
        while(cursor.moveToNext()) {
            tables.add(cursor.getString(0));
        }
        cursor.close();
        return tables;
    }

    private ArrayList<String> getColumns(String table) {
        ArrayList<String> columns = new ArrayList<>();
        try (Cursor cursor = database.rawQuery("PRAGMA table_info(" + table + ")", null)) {
            while (cursor.moveToNext()) {
                columns.add(cursor.getString(1));
            }
        }
        return columns;
    }

    private void exportTables(List<String> tables, final String fileName) throws Exception {
        workbook = new XSSFWorkbook();
        for (int i = 0; i < tables.size(); i++) {
            if (!tables.get(i).equals("android_metadata")) {
                XSSFSheet sheet = workbook.createSheet(prettyNameMapping(tables.get(i)));
                createSheet(tables.get(i), sheet);
            }
        }
        File file = new File(mExportPath, fileName);
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.flush();
        fos.close();
        workbook.close();
        database.close();
    }

    public void exportSingleTable(final String table, final String fileName, ExportListener listener) {
        List<String> tables = new ArrayList<>();
        tables.add(table);
        startExportTables(tables, fileName, listener);
    }

    public void exportSpecificTables(final List<String> tables, String fileName, ExportListener listener) {
        startExportTables(tables, fileName, listener);
    }

    public void exportAllTables(final String fileName, ExportListener listener) {
        ArrayList<String> tables = getAllTables();
        startExportTables(tables, fileName, listener);
    }

    private void startExportTables(final List<String> tables, final String fileName, final ExportListener listener) {
        if (listener != null) {
            listener.onStart();
        }
        new Thread(() -> {
            try {
               exportTables(tables, fileName);
               if (listener != null) {
                   handler.post(() -> listener.onCompleted(mExportPath + fileName));
               }
            } catch (final Exception ex) {
                if (database != null && database.isOpen()) {
                    database.close();
                }
                if (listener != null) {
                    handler.post(() -> listener.onError(ex));
                }
            }
        }).start();
    }

    private void createSheet(String table, XSSFSheet sheet) {
        XSSFRow row = sheet.createRow(0);
        ArrayList<String> columns = getColumns(table);
        int cellIndex = 0;
        for (int i = 0; i < columns.size(); i++) {
            String columnName = prettyNameMapping("" + columns.get(i));
            if (!excludeColumn(columnName)) {
                XSSFCell cell = row.createCell(cellIndex);
                cell.setCellValue(new XSSFRichTextString(columnName));
                cellIndex++;
            }
        }
        insertItemToSheet(table, sheet, columns);
    }

    private void insertItemToSheet(String table, XSSFSheet sheet, ArrayList<String> columns) {
        XSSFDrawing patriarch = sheet.createDrawingPatriarch();
        Cursor cursor = database.rawQuery("select * from " + table, null);
        cursor.moveToFirst();
        int n = 1;
        while (!cursor.isAfterLast()) {
            XSSFRow row = sheet.createRow(n);
            int cellIndex = 0;
            for (int j = 0; j < columns.size(); j++) {
                String columnName = "" + columns.get(j);
                if (!excludeColumn(columnName)) {
                    XSSFCell cell = row.createCell(cellIndex);
                    if (cursor.getType(j) == Cursor.FIELD_TYPE_BLOB) {
                        XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, cellIndex, n, cellIndex + 1, n + 1);
                        anchor.setAnchorType(ClientAnchor.AnchorType.DONT_MOVE_AND_RESIZE);
                        patriarch.createPicture(anchor, workbook.addPicture(cursor.getBlob(j), XSSFWorkbook.PICTURE_TYPE_JPEG));
                    } else {
                        switch (cursor.getType(j)) {
                            case Cursor.FIELD_TYPE_INTEGER:
                                cell.setCellValue(cursor.getInt(j));
                                break;
                            case Cursor.FIELD_TYPE_FLOAT:
                                cell.setCellValue(cursor.getDouble(j));
                                break;
                            default:
                                cell.setCellValue(cursor.getString(j));
                                break;
                        }
                    }
                    cellIndex++;
                }
            }
            n++;
            cursor.moveToNext();
        }
        cursor.close();
    }

    private boolean excludeColumn(String column) {
        if (null != mExcludeColumns) {
            return mExcludeColumns.contains(column);
        }

        return false;
    }

    private String prettyNameMapping(String name) {
        if (null != mPrettyNameMapping) {
            if (mPrettyNameMapping.containsKey(name)) {
                name = mPrettyNameMapping.get(name);
            }
        }
        return name;
    }

    public interface ExportListener {
        void onStart();

        void onCompleted(String filePath);

        void onError(Exception e);
    }

    /**
     * Interface class for the custom formatter
     */
    public interface ExportCustomFormatter {
        String process(String columnName, String value);
    }
}
