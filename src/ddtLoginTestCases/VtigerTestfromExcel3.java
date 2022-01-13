package ddtLoginTestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ddt.ExcelUtility;
import utility.Openbrowser;

public class VtigerTestfromExcel3 extends Openbrowser {
		
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
		appurl=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","ALLDDTtest",3,0);
		username=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","ALLDDTtest",3,2);
		password=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","ALLDDTtest",3,3);
		loginpageTitle=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","ALLDDTtest",3,1);
		homepageTitle=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","ALLDDTtest",3,4);
			
	}

	@BeforeClass
	public void setup() {
		driver=Openbrowser.setup("chrome", appurl);
	}
		
	@Test
	public void login() throws InterruptedException, IOException
	{
		
		Assert.assertEquals(driver.getTitle(), loginpageTitle);
		
		WebElement txtmail=driver.findElement(By.id("username"));
		txtmail.clear();
		txtmail.sendKeys(username,Keys.TAB);
		
		WebElement txtpwd=driver.switchTo().activeElement();
		txtpwd.clear();
		txtpwd.sendKeys(password,Keys.ENTER);
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.getTitle(), homepageTitle);
		
		driver.findElement(By.xpath("//ul/li[5]/div/a/span")).click();
		driver.findElement(By.xpath("//div/span[2]/a")).click();
		
		Assert.assertEquals(driver.getTitle(), loginpageTitle);
		ExcelUtility utility = new ExcelUtility(".\\ddtexcel\\Actitime.xlsx");
		utility.setCellData("ALLDDTtest", 3, 5, "Passed");
	
	}
		
	@AfterMethod
	void chormeclose() {
		driver.close();
		System.out.println("done");
		
	}
}

