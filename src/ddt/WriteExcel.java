package ddt;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

public class WriteExcel {
	
	@Test
	public void Excel_Write() throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("writedata");
		
//		we need to add data into sheet, to create data we can use object array (object hold all data types, heterogeneous data and homogeneous data)
		Object data [][]= {
				
				{"empid","name","degi","salary"},
				{100,"pavan","Engineer",40000},
				{101,"dimple","tester",50000},
				{102,"vaibhavee","developer",60000},
		};
		
//		Add this data into sheet using normal for loop
//		count rows and column
		int rows=data.length;
		int cols=data[0].length;
		System.out.println("no of row is: "+rows+" no of columns is: "+cols);
		
		for(int r=0; r<rows; r++) {
			XSSFRow row=sheet.createRow(r);
			for(int c=0;c<cols;c++) {
				XSSFCell cell=row.createCell(c);
				Object value=data[r][c];
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);	
			}
		}
		FileOutputStream output=new FileOutputStream("/Users/pavanchaudhari/eclipse-workspace/A-SeleniumDemo/DDTexcel/hunters.xlsx");
		workbook.write(output);
		workbook.close();
		output.close();
	}
	
}
