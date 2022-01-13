package day10_mousekeyboardoper;


import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Openbrowser;


public class FlipkartHover {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=Openbrowser.setup("chrome","https://www.flipkart.com/");
		try {
			driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		} catch (NoSuchElementException e) {

		}
		
		List<WebElement> mainMenu = driver.findElements(By.xpath("//div[@class='_37M3Pb']/div/a/div[2]"));
		Actions action = new Actions(driver);
		for (int i = 0; i < mainMenu.size(); i++) {
			System.out.println("******"+mainMenu.get(i).getText()+"************");
			action.moveToElement(mainMenu.get(i)).perform();
			System.out.println(mainMenu.get(i).getText());
			Thread.sleep(2000);
			//div[@class='_37M3Pb']/div/a/div[2]/div[2]/div[2]//a
			List<WebElement> subMenu = driver.findElements(By.xpath("//div[@class='_37M3Pb']/div/a/div[2]/div[2]/div[2]/div/div/div[contains(@class,'_7qr1OC')]/a"));
			System.out.println(subMenu.size());
			if(subMenu.size()>0) {
				for (int j = 0; j < subMenu.size(); j++) {
					action.moveToElement(subMenu.get(j)).perform();
					System.out.println(subMenu.get(j).getText());
					//driver.findElement(By.xpath("/a[text()='Men's Jeans']")).click();
					
					Thread.sleep(1000);
					//break;
			}
		}
	}
	}

}
