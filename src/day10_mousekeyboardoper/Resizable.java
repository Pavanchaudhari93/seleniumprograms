package day10_mousekeyboardoper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Openbrowser;

public class Resizable {

	public static void main(String[] args) {
		WebDriver driver = Openbrowser.setup("chrome", "https://jqueryui.com/resizable/");
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		
		WebElement resize = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(resize, 250, 90).perform();
		
		
	}
}
