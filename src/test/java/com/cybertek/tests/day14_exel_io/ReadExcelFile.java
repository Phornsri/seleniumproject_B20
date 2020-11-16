package com.cybertek.tests.day14_exel_io;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelFile {
    public static void main(String[] args) throws IOException{
        String path = "vytrack_testusers.xlsx";
        File file = new File(path);
        System.out.println("file.exists() = " + file.exists());

       // Workbook workbook = WorkbookFactory.create(file);
        Workbook workbook = WorkbookFactory.create(file);
        // FileInputStream fileInputStream = new FileInputStream(path);
        int numOfSheets = workbook.getNumberOfSheets();
        System.out.println("Number of sheets: "+ numOfSheets);
        //Step 2: create object of spreadsheet
        Sheet sheet = workbook.getSheet("QA3-short");
        //step 3: read a row
        Row row1 = sheet.getRow(0);
        //step4: read a cell
        Cell cell1 = row1.getCell(0);
        //step 5: Extract value
        String value1 = cell1.getStringCellValue();
        //step 6 : use value
        System.out.println("Value of 1st row 1st column: "+ value1);
        workbook.forEach(w -> System.out.println(sheet.getSheetName()) );
        //how do we get a data from entire row?
        Iterator<Cell> cellIterator = row1.cellIterator();
        while (cellIterator.hasNext()) {
            String value = cellIterator.next().getStringCellValue();
            System.out.print(value + " ");
        }

        System.out.println("\n####################");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Iterator<Cell> tempCellIterator = rowIterator.next().cellIterator();
            while (tempCellIterator.hasNext()) {
                String value = tempCellIterator.next().getStringCellValue();
                System.out.print(value + " ");
            }
            System.out.println();
        }


    }
}
