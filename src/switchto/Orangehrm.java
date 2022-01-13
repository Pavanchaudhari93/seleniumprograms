package switchto;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Openbrowser;

public class Orangehrm {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Openbrowser.setup("Chrome", "https://www.facebook.com/");
		WebElement name = driver.switchTo().activeElement();
		name.clear();
		Thread.sleep(2000);
		name.sendKeys("7709059929" , Keys.TAB , "PAvan@123" , Keys.ENTER);
	}
	
}
