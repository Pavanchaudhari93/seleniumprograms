package day10_mousekeyboardoper;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Openbrowser;

public class DragandDrop {

	public static void main(String[] args) {
		WebDriver driver = Openbrowser.setup("chrome", "https://jqueryui.com/droppable/");
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		
		 WebElement Draggable = driver.findElement(By.id("draggable"));
		 WebElement Droppable = driver.findElement(By.id("droppable"));
		 
		 Actions action = new Actions(driver);
		 action.dragAndDrop(Draggable, Droppable).perform();
		driver.close();
		driver.quit();

	}

}
