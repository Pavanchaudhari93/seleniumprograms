package day10_mousekeyboardoper;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Openbrowser;

public class Mousehover {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=Openbrowser.setup("chrome","https://www.ebay.com/");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		Thread.sleep(1000);
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[5]/a"));
		action.moveToElement(element1).perform();
		
	}

}