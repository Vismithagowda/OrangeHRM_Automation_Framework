package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtils {
    private static Workbook workbook;
    private static Sheet sheet;
    public static void setExcelFile(String filePath, String sheetName) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCellData(int rowNumber, int columnNumber) {
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(columnNumber);
        return cell.toString();
    }

    public static int getRowCount() {
        return sheet.getLastRowNum();
    }
    public static int getColumnCount() {
        return sheet.getRow(0).getLastCellNum();
    }

}