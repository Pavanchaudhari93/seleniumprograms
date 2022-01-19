package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Tss {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
	System.setProperty("webdriver.chrome.driver", "/Users/pavanchaudhari/Downloads/chromedriver");
		
	driver=new ChromeDriver();
	
	driver.navigate().to("https://www.instagram.com/");
	
	TakesScreenshot ss=(TakesScreenshot)driver;
	
	File format=ss.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(format, new File("/Users/pavanchaudhari/eclipse-workspace/A-SeleniumDemo/ss/instagram.jpg"));
	
	driver.close();
	
	}

}
