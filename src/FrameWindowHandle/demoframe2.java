package FrameWindowHandle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Openbrowser;

public class demoframe2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Openbrowser.setup("chrome", "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/button")).click();
		Alert popup = driver.switchTo().alert();
		System.out.println(popup);
		popup.sendKeys("Pavan Chaudhari");
		popup.accept();
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
	}
}
