package de.kai_morich.usb_terminal.libs.excel;

import android.util.Log;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExcelExporter {

    private final XSSFWorkbook workbook;
    private final XSSFSheet sheet;
    private final String exportPath;
    private final String fileName;

    public ExcelExporter(String exportPath, String fileName, String sheetName) {
        this.exportPath = exportPath;
        this.fileName = fileName;

        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(sheetName);
    }

    public void addHeadersRow(List<String> columns) {
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < columns.size(); i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(new XSSFRichTextString(columns.get(i)));
        }
    }

    /**
     * Add a row to sheet.
     * Row number will be handled by the client,
     * and row number should start from 1 to onwards
     * if header row added otherwise start from 0;
     *
     * @param columns
     */
    public void addRow(int rowNumber, List<RowData> columns) {
        XSSFRow row = sheet.createRow(rowNumber);
        for (int i = 0; i < columns.size(); i++) {
            XSSFCell cell = row.createCell(i);
            RowData col = columns.get(i);
            switch (col.getCellType()) {
                case String:
                    cell.setCellValue(new XSSFRichTextString((String) col.getData()));
                    break;
                case Boolean:
                    cell.setCellValue((boolean) col.getData());
                    break;
                case Double:
                    cell.setCellValue((double) col.getData());
                    break;
                case Date:
                    cell.setCellValue((Date) col.getData());
                    break;
                case Calendar:
                    cell.setCellValue((Calendar) col.getData());
            }
        }
    }

    public void export() throws IOException {
        File file = new File(this.exportPath, this.fileName);
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.flush();
        fos.close();
        workbook.close();
    }
}
