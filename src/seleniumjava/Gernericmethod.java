package seleniumjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Gernericmethod {

	public static void main(String[] args) {
//		Step1: set path for driver executables
		System.setProperty("webdriver.chrome.driver", "D:\\pavan\\workspace\\Selenium project1\\executables\\chromedriver.exe");
//		Step2: Create an instance of ChromeDriver class and upcast it to WebDriver Interface
		WebDriver Cdriver=new ChromeDriver();
		
//		Step1: set path for driver executables
		System.setProperty("webdriver.gecko.driver", "D:\\pavan\\workspace\\Selenium project1\\executables\\geckodriver.exe");
//		Step2: Create an instance of FirefoxDriver class and upcast it to WebDriver Interface
		WebDriver Cdriver1=new FirefoxDriver();
		
//		Step1: set path for driver executables
		System.setProperty("webdriver.ie.driver", "D:\\pavan\\workspace\\Selenium project1\\executables\\IEDriverServer.exe");
//		Step2: Create an instance of InternetExplorerDriver class and upcast it to WebDriver Interface
		WebDriver Cdriver2=new InternetExplorerDriver();
	
	}

}
