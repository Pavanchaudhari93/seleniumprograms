package FrameWindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Openbrowser;

public class demoframe {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Openbrowser.setup("chrome", "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/button")).click();
		Thread.sleep(2000);
		String gettext = driver.switchTo().alert().getText();
		System.out.println(gettext);
		driver.switchTo().alert().accept();
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		
	}

}
