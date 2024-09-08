package org.automation.utils;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public void setFilePathAndName(String filePath, String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
    }

    public List<Object[]> getData() {
        List<Object[]> data = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();

        // Skip header row
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            int numberOfColumns = row.getLastCellNum();
            Object[] rowData = new Object[numberOfColumns];

            for (int i = 0; i < numberOfColumns; i++) {
                if(row.getCell(i) == null || row.getCell(i).getCellType() == CellType.BLANK){
                    rowData[i] = null;
                } else {
                    rowData[i] = row.getCell(i).toString();
                }
            }
            data.add(rowData);
        }
        return data;
    }

    public void close() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }
}
