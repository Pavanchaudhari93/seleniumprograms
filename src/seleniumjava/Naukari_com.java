package seleniumjava;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Naukari_com {
	
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "/Users/pavanchaudhari/Downloads/chromedriver");
		
//		Step2: Create an instance of ChromeDriver class
		
//		WebDriverManager.chromedriver().setup();
		
//		WebDriver driver=new ChromeDriver();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.navigate().to("https://www.naukri.com/nlogin/login");
		
		driver.findElement(By.id("usernameField")).sendKeys("chaudharipavanh@gmail.com");
		
		driver.findElement(By.id("passwordField")).sendKeys("PAvan@123");
		
		driver.findElement(By.xpath("//button")).click();
		
		Thread.sleep(2000);
		
		String ExpactedTitle=driver.getTitle();
		
		System.out.println(ExpactedTitle);
		
		String ActualTitle="Home | Mynaukri";
		
		Assert.assertEquals(driver.getTitle(), "Home | Mynaukri");
		
		Thread.sleep(3000);
		
		WebElement mynaukari=driver.findElement(By.xpath("//ul[2]/li[2]/a/div[2]"));
		
		Actions action =new Actions(driver);
		
		action.moveToElement(mynaukari).perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@title='Edit Profile']")).click();
		
		
		
//		driver.findElement(By.xpath("//a[@title='Logout']")).click();
//		
//		driver.close();
		
	}

}