package seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utility.Openbrowser;

public class vtigerDragandDropOp {
		
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Openbrowser.setup("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
		Actions act = new Actions(driver);
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	
		WebElement history = driver.findElement(By.xpath("//*[@id=\"56\"]/div[1]/div[1]/div"));
		act.clickAndHold(history).perform();
		act.dragAndDropBy(history, 900, 0).release().perform();
		System.out.println("done");
	}
}