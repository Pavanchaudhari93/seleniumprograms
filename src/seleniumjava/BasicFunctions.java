package seleniumjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicFunctions {
	public static void main(String[] args) {
//		Step1: set path for driver executables
		System.setProperty("webdriver.chrome.driver", "D:\\pavan\\workspace\\Selenium project1\\executables\\chromedriver.exe");
		
//		Step2: Create an instance of ChromeDriver class and upcast it to WebDriver Interface
		WebDriver Cdriver=new ChromeDriver();
		
//		enter required URL in the browser
		Cdriver.get("http://www.facebook.com");
		Cdriver.navigate().to("http://www.facebook.com");
		
//		page title
		String pageTitle=Cdriver.getTitle();
		System.out.println("Page title is : "+pageTitle);
		System.out.println(Cdriver.getTitle());
		
//		current page url
		System.out.println("Current page URL: "+Cdriver.getCurrentUrl());
		
//		page source
		System.out.println("Current page source code: "+Cdriver.getPageSource());
		
//		close current instance of browser opened by selenium
		Cdriver.close();
	}

}
