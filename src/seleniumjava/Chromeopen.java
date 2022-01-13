package seleniumjava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Chromeopen {

	public static void main(String[] args) {
//		Step1: set path for driver executables
//		System.setProperty("webdriver.chrome.driver", "D:\\pavan\\workspace\\Selenium project1\\executables\\chromedriver.exe");
//		or
//		System.setProperty("webdriver.chrome.driver", "D:/pavan/workspace/Selenium project1/executables/chromedriver.exe");
//		or
//		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
//		or
		String chromeDriverPath=System.getProperty("user.dir")+"/exe/chromedriver.exe";
//		String chromepth="/Users/pavanchaudhari/eclipse-workspace/SeleniumDemo/exe/chromedriver";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//		Step2: Create an instance of ChromeDriver class
		ChromeDriver ie=new ChromeDriver();
	}
}
