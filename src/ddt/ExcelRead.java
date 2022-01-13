package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

public class ExcelRead {
	@Test
	void excelread() throws IOException {

		
		String excelfilepath = "/Users/pavanchaudhari/eclipse-workspace/A-SeleniumDemo/DDTexcel/job hunters.xlsx";
		FileInputStream fis = new FileInputStream(excelfilepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		System.out.println(workbook.getNumberOfSheets());
		XSSFSheet sheet = workbook.getSheet("Sheet1");
//		XSSFSheet sheet = workbook.getSheetAt(0);
		
//		Using for loop
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		System.out.println("Toatal no of rows: "+rows +"  "+"Toatal no of Column: "+cols);
		
		for(int r=0;r<=rows;r++) {
			
			XSSFRow row = sheet.getRow(r);
			
			for(int c=0;c<cols;c++) {
				XSSFCell cell = row.getCell(c);
				switch(cell.getCellType())
				{
					case STRING:System.out.print(cell.getStringCellValue());
					break;
					case NUMERIC:System.out.print(cell.getNumericCellValue());
					break;
					case BOOLEAN:System.out.print(cell.getBooleanCellValue());
					break;
				default:
					break;
				}
				System.out.print(" ");
			}
			System.out.println(" ");
		}

		workbook.close();
		

	}

}
