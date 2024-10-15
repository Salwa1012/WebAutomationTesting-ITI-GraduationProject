package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    public static Object[][] getExcelData(String filePath, String sheetName) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] excelData = new Object[totalRows - 1][totalCols];

        for (int i = 1; i < totalRows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < totalCols; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {

                    excelData[i - 1][j] = cell.toString();
                } else {

                    excelData[i - 1][j] = "";
                }
            }
        }
        workbook.close();
        return excelData;
    }
}
