package ddtLoginTestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ddt.ExcelUtility;
import utility.Openbrowser;

public class ActitimeTestfromExcel1 extends Openbrowser {
		
	String appurl,username,password,exptitle,loginpageTitle,homepageTitle;
	WebDriver driver;

	public String readdatafromexcel(String fileName,String sheetName, int rownum,int cellnum) throws IOException {
			
		FileInputStream fo=new FileInputStream(fileName);	// file location
		XSSFWorkbook workbook=new XSSFWorkbook(fo);			//create an instance of required workbook
		XSSFSheet sheet=workbook.getSheet(sheetName);		//get sheet
		XSSFRow row=sheet.getRow(rownum);					//get row
		fo.close();
		workbook.close();
		return row.getCell(cellnum).getStringCellValue();	//get cell in return to use string data in cell
	}
		
	@BeforeTest
	public void appdata() throws IOException {
		appurl=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","ALLDDTtest",1,0);
		username=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","ALLDDTtest",1,2);
		password=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","ALLDDTtest",1,3);
		loginpageTitle=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","ALLDDTtest",1,1);
		homepageTitle=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","ALLDDTtest",1,4);
			
	}
	
	@BeforeClass
	public void setup() {
		driver=Openbrowser.setup("chrome", appurl);
	}
		
	@Test(priority=0)
	public void login() throws InterruptedException 
	{
		Assert.assertEquals(driver.getTitle(), loginpageTitle);
		
		WebElement txtmail=driver.findElement(By.id("username"));
		txtmail.sendKeys(username,Keys.TAB);
		
		driver.switchTo().activeElement().sendKeys(password,Keys.ENTER);
		
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.getTitle(), homepageTitle);
		
		driver.findElement(By.id("logoutLink")).click();

	}
	
	@Test(priority=1)
	public void setstatus() throws IOException {
		Assert.assertEquals(driver.getTitle(), loginpageTitle);
		FileInputStream fi=new FileInputStream(".\\ddtexcel\\Actitime.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet("ALLDDTtest");
		XSSFRow row=sheet.getRow(1);
		row.createCell(5).setCellValue("Passed");
		
		FileOutputStream fo=new FileOutputStream(".\\ddtexcel\\Actitime.xlsx");
		workbook.write(fo);
		fo.flush();
		fo.close();
		workbook.close();
		fi.close();

	}
		
	@AfterClass
	void chormeclose() {
		driver.close();
		System.out.println("done");
		
	}
}

