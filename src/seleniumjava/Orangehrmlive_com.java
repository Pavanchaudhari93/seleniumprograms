package seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Orangehrmlive_com {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.gecko.driver", "D:\\pavan\\workspace\\Selenium project1\\executables\\geckodriver.exe");
		FirefoxDriver fdriver=new FirefoxDriver();
		fdriver.get("https://opensource-demo.orangehrmlive.com");
		System.out.println("Page Title is: "+fdriver.getTitle());
		System.out.println("Current Page URL is: "+fdriver.getCurrentUrl());
		WebElement username=fdriver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");
		WebElement password=fdriver.findElement(By.name("txtPassword"));
		password.sendKeys("admin123");
		WebElement login=fdriver.findElement(By.id("btnLogin"));
		login.click();
		fdriver.close();
	}
}
