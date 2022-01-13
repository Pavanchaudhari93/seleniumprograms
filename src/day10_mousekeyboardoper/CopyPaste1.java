package day10_mousekeyboardoper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Openbrowser;

public class CopyPaste1 {
public static void main(String[] args) throws Exception {
	WebDriver driver = Openbrowser.setup("chrome", "https://extendsclass.com/text-compare.html");
	WebElement copy = driver.findElement(By.xpath("//*[@id=\"dropZone\"]//div[5]/div[3]/pre/span"));
	Actions action = new Actions(driver);
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_UP);
	action.keyDown(copy, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
	Thread.sleep(2000);
	
	WebElement paste = driver.findElement(By.xpath("//*[@id=\"dropZone2\"]//div[4]/pre/span"));
	action.keyDown(paste, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
	
}
}
