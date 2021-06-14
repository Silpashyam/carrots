package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

	private static final String POIWRITE_XLSX = "D:\\Silpa\\Automation\\Excelinput.xlsx";

	public String readExcelFun(int row, int cell, String sheetname) throws IOException {
		FileInputStream file = new FileInputStream(new File(POIWRITE_XLSX));

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheet(sheetname);

		Row obj1 = sheet.getRow(row);
		System.out.println(sheet.getRow(row));
		Cell objcell = obj1.getCell(cell);

		String returnValue = "";

		// Check the cell type and format accordingly
		switch (objcell.getCellType()) {
		case NUMERIC:
			returnValue = Integer.toString((int) objcell.getNumericCellValue());
			break;

		case STRING:
			returnValue = objcell.getStringCellValue();
			break;

		}
		return returnValue;

	}

}