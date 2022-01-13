package seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChrome {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/pavanchaudhari/Downloads/chromedriver");
		
//		Step2: Create an instance of ChromeDriver class
		
//		WebDriverManager.chromedriver().setup();
		
//		WebDriver driver=new ChromeDriver();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.navigate().to("https://www.naukri.com/nlogin/login");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("usernameField")).sendKeys("pavanjalgaon@gmail.com");
		
		driver.findElement(By.id("passwordField")).sendKeys("PAvan@123");
		
//		driver.close();
	}
}
