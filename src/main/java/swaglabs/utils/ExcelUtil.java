package swaglabs.utils;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static Object[][] getLoginData(String sheetName) {

	    Object[][] data = null;

	    try {

	        String path = System.getProperty("user.dir")
	                + "/Testdata/Logintestcases.xlsx";

	        FileInputStream file = new FileInputStream(path);

	        XSSFWorkbook workbook = new XSSFWorkbook(file);

	        XSSFSheet sheet = workbook.getSheet(sheetName);

	        int rows = sheet.getPhysicalNumberOfRows();
	        int cols = sheet.getRow(0).getLastCellNum();

	        data = new Object[rows - 1][cols];

	        for (int i = 1; i < rows; i++) {

	            for (int j = 0; j < cols; j++) {

	                data[i - 1][j] =
	                        sheet.getRow(i).getCell(j).toString();
	            }
	        }

	        workbook.close();
	        file.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return data;
	}
	
	public static Object[][] getKeywordData(String sheetName) {

	    Object[][] data = null;

	    try {

	        String path = System.getProperty("user.dir")
	                + "/Testdata/Keywords.xlsx";

	        FileInputStream file = new FileInputStream(path);

	        XSSFWorkbook workbook = new XSSFWorkbook(file);

	        XSSFSheet sheet = workbook.getSheet(sheetName);

	        int rows = sheet.getPhysicalNumberOfRows();
	        int cols = sheet.getRow(0).getLastCellNum();

	        data = new Object[rows - 1][cols];

	        for (int i = 1; i < rows; i++) {

	            for (int j = 0; j < cols; j++) {

	                data[i - 1][j] =
	                        sheet.getRow(i).getCell(j).toString();
	            }
	        }

	        workbook.close();
	        file.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return data;
	} 
}
