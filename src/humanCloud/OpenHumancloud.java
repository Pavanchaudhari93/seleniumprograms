package humanCloud;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenHumancloud {
	
	@Test
	public void main() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/pavanchaudhari/Downloads/chromedriver");
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.google.co.in/");
		
		WebElement google=driver.findElement(By.name("q"));
		
		google.sendKeys("Pavan Chaudhari");
		
		WebElement search=driver.findElement(By.name("btnK"));
		
		search.click();
		

	}

}
