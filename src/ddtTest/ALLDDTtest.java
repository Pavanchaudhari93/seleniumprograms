package ddtTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import ddt.ExcelUtility;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class ALLDDTtest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		String chromeDriverPath="/Users/pavanchaudhari/Downloads/chromedriver";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "LoginData")
	public void login(String appurl, String loginpageTitle, String username, String password, String homepageTitle)
			throws InterruptedException, IOException {
		driver.get(appurl);

		Assert.assertEquals(driver.getTitle(), loginpageTitle);

		WebElement txtmail = driver.findElement(By.cssSelector("input#username"));
		txtmail.sendKeys(username, Keys.TAB);

		driver.switchTo().activeElement().sendKeys(password, Keys.ENTER);

		Thread.sleep(2000);

		Assert.assertEquals(driver.getTitle(), homepageTitle);

	}

	@DataProvider(name = "LoginData")
	public String[][] getdata() throws IOException {

		String path = "/Users/pavanchaudhari/eclipse-workspace/A-SeleniumDemo/DDTexcel/Actitime (1).xlsx";
		ExcelUtility utility = new ExcelUtility(path);
		int row = utility.getRowCount("ALLDDTtest");
		int cell = utility.getCellCount("ALLDDTtest", 1);
		System.out.println(row + " " + cell);

		String logindata[][] = new String[1][cell];
		for (int j = 0; j < cell; j++) {
			logindata[0][j] = utility.getCellData("ALLDDTtest", 1, j);
			System.out.println(logindata[0][j]);
		}
		return logindata;
	}

	@AfterClass
	void chormeclose() throws IOException {
		driver.findElement(By.id("logoutLink")).click();
		driver.close();
		System.out.println("done");
	}
	}