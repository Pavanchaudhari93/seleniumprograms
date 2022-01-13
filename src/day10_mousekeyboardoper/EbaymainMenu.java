package day10_mousekeyboardoper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Openbrowser;

public class EbaymainMenu {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=Openbrowser.setup("chrome","https://www.ebay.com/");
		Thread.sleep(5000);
//		List <WebElement> element = driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li"));
		Actions action = new Actions(driver);
//		System.out.println("Element size is : "+element.size());
//		for(int i=0 ; i < element.size() ; i++) {
//			action.moveToElement(element.get(i)).perform();
//			System.out.println(element.get(i).getText());
//		}
//			Thread.sleep(2000);
			

			WebElement more=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[5]/a"));
			action.moveToElement(more).build().perform();
			List<WebElement> element1 = driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[5]/div[2]/div[1]/nav[1]/ul/li/a"));
																	 
			System.out.println("Element1 size is : "+element1.size());
			try {
//			if(element1.size()>0) {
				for (int j = 0; j < element1.size(); j++) {
					action.moveToElement(element1.get(j)).perform();
					System.out.println(element1.get(j).getText());
					Thread.sleep(2000);
				}
//			}
			}catch(Exception e) {
				e.printStackTrace();
					System.out.println("Exception Handled");
				}
	}
}