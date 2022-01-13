package ddtTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.Openbrowser;

public class ActitimeTestfromExcel extends Openbrowser {
	
	String appurl,username,password,exptitle;
	WebDriver driver;

	public String readdatafromexcel(String fileName,String sheetName, int rownum,int cellnum) throws IOException {
		
		FileInputStream fo=new FileInputStream(fileName);	// file location
		XSSFWorkbook workbook=new XSSFWorkbook(fo);			//create an instance of required workbook
		XSSFSheet sheet=workbook.getSheet(sheetName);		//get sheet
		XSSFRow row=sheet.getRow(rownum);					//get row
		return row.getCell(cellnum).getStringCellValue();	//get cell in return to use string data in cell
	}
	
	@BeforeTest
	public void appdata() throws IOException {
		appurl=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","testdata",1,0);
		username=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","testdata",1,1);
		password=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","testdata",1,2);
		exptitle=readdatafromexcel(".\\ddtexcel\\Actitime.xlsx","testdata",1,3);
		
	}
	
	@BeforeMethod
	public void setup() {
		driver=Openbrowser.setup("chrome", appurl);
	}
	
	@Test
	public void testing() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(username,Keys.TAB);
		driver.switchTo().activeElement().sendKeys(password,Keys.ENTER);
		Thread.sleep(2000);
		System.out.println("Actual Tiltle is :"+driver.getTitle());
		Assert.assertEquals("home page not loaded properly", exptitle, driver.getTitle());	
	}
	
	@AfterMethod
	void chormeclose() {
		driver.close();
		System.out.println("done");
	
	}
}