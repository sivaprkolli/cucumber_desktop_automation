package DataProviders;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public static String readUserData(String rowCell, String columnCell) {
        File file = new File(System.getProperty("user.dir") + "/testData/userData.xlsx");
        XSSFWorkbook xssfWorkbook = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("users");

        int rowNumber = 0, colNumber = 0;

        /**
         * Iteration of all rows in the sheet
         */

        for(Row row: xssfSheet){
            Cell cell = row.getCell(0); // first cell in the row
            if(cell != null
                    && cell.getCellType() == CellType.STRING
                    && cell.getStringCellValue().equals(rowCell)){
                rowNumber = row.getRowNum();
                System.out.println(rowNumber);
            }
        }

        /**
         * Iteration of cells on header row
         */
        Row headerRow = xssfSheet.getRow(0); // first cell in the header row
        for(Cell cell: headerRow){
            if(cell != null
                    && cell.getCellType() == CellType.STRING
                    && cell.getStringCellValue().equals(columnCell)){
                colNumber = cell.getColumnIndex();
                System.out.println(colNumber);
            }

        }

        Cell cellValue = xssfSheet.getRow(rowNumber).getCell(colNumber);
        System.out.println(cellValue);
        String actualCellValue = cellValue.toString();
        return actualCellValue;
    }
    public static String readUserData(String sheetName, String rowCell, String columnCell) {
        File file = new File(System.getProperty("user.dir") + "/testData/userData.xlsx");
        XSSFWorkbook xssfWorkbook = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);

        int rowNumber = 0, colNumber = 0;

        /**
         * Iteration of all rows in the sheet
         */

        for(Row row: xssfSheet){
            Cell cell = row.getCell(0); // first cell in the row
            if(cell != null
                    && cell.getCellType() == CellType.STRING
                    && cell.getStringCellValue().equals(rowCell)){
                rowNumber = row.getRowNum();
                System.out.println(rowNumber);
            }
        }

        /**
         * Iteration of cells on header row
         */
        Row headerRow = xssfSheet.getRow(0); // first cell in the header row
        for(Cell cell: headerRow){
            if(cell != null
                    && cell.getCellType() == CellType.STRING
                    && cell.getStringCellValue().equals(columnCell)){
                colNumber = cell.getColumnIndex();
                System.out.println(colNumber);
            }

        }

        Cell cellValue = xssfSheet.getRow(rowNumber).getCell(colNumber);
        System.out.println(cellValue);
        String actualCellValue = cellValue.toString();
        return actualCellValue;
    }
}
