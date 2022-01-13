package utility;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Openbrowser {
	
		public static WebDriver setup(String BrowserName, String URL) {
			WebDriver driver = null;
			String chromeDriverPath="/Users/pavanchaudhari/Downloads/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			if(BrowserName.equalsIgnoreCase("chrome")) {
//				WebDriverManager.chromedriver().setup();
//				driver=new ChromeDriver();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.manage().window().maximize();
//			driver.get(URL);
//			return driver;
//			
//			
//		}
			
			driver=new ChromeDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			driver.manage().window().maximize();
			driver.get(URL);
			return driver;
		}
}
