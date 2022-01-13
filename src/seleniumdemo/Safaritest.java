package seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Safaritest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.safari.driver", "/Users/pavanchaudhari/eclipse-workspace/A-SeleniumDemo/SafariDriver.safariextz");
		
		WebDriver driver=new SafariDriver();
		
		driver.get("https://www.google.co.in/");
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}

}
