package com.saucedemo.utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    private static Sheet sheet;

    public static void loadExcel(String path, String sheetName) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetName);
    }

    public static String getCellData(int row, int col) {
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }
}
