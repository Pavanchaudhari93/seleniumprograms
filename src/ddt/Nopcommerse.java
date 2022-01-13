package ddt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class Nopcommerse {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		String chromeDriverPath="/Users/pavanchaudhari/Downloads/chromedriver";
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="LoginData123")
	public void login(String user,String pwd, String exp) throws InterruptedException
	{
		driver.get("https://admin-demo.nopcommerce.com/login");
		WebElement txtmail=driver.findElement(By.id("Email"));
		txtmail.clear();
		txtmail.sendKeys(user);
		
		WebElement txtpassword=driver.findElement(By.id("Password"));
		txtpassword.clear();
		txtpassword.sendKeys(pwd);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[3]/button")).click();
		
		String expTitle= "Dashboard / nopCommerce administration";
		String actTitle=driver.getTitle();
		
		if(exp.equals("Valid")) {
			
			if(expTitle.equals(actTitle)) {
				
				driver.findElement(By.linkText("Logout")).click();
				
				Assert.assertTrue(true);
				
			} else {
			Assert.assertTrue(false);
			}
			
		}else if(exp.equals("Invalid")) {
			
			if(expTitle.equals(actTitle)) {
				
				driver.findElement(By.linkText("Logout")).click();
				
				Assert.assertTrue(false);
				
			}else {
				
				Assert.assertTrue(true);

			}
		}
	}
	
	@DataProvider(name="LoginData123")
	public String [][] getdata() throws Exception 
	{
//		String logindata[][]= {
//				
//								{"admin@yourstore.com","admin","Valid"},
//								{"adin@yourstore.com","admi","Invalid"},
//								{"amin@yourstore.com","ain","Invalid"},
//								{"admin@yorstore.com","adhjin","Invalid"},
//		
//							};	
		String path="/Users/pavanchaudhari/eclipse-workspace/A-SeleniumDemo/DDTexcel/nopcommerse.xlsx";
		
		ExcelUtility utility=new ExcelUtility(path);
		
		int row=utility.getRowCount("Sheet1");
		
		int cell=utility.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[1][cell];
		
//		for(int i=1;i<row;i++) {
			
			for(int j=0;j<cell;j++) {
				
				logindata[0][j]=utility.getCellData("Sheet1" ,1,j);
				
//			}
		}

	return logindata;
	}
	
	@AfterClass
	void chormeclose() {
		driver.close();
		System.out.println("done");
	}
}