package day10_mousekeyboardoper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Openbrowser;

public class MouseOperation {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=Openbrowser.setup("chrome","https://www.globalsqa.com/demo-site/draganddrop/");
		Thread.sleep(15000);
		WebElement frame=driver.findElement(By.cssSelector(".demo-frame.lazyloaded"));
		driver.switchTo().frame(frame);
		WebElement source=driver.findElement(By.xpath("//h5[text()='High Tatras']"));
		WebElement destination=driver.findElement(By.id("trash"));
		Actions action= new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
	}
}