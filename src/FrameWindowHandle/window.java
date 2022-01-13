package FrameWindowHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Openbrowser;

public class window {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Openbrowser.setup("chrome", "https://www.salesforce.com/in/?ir=1");
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]//div[1]/div[1]/div[3]/div/div[1]/div/a")).click();
		Set<String> windowhandle = driver.getWindowHandles();
		Iterator<String> iterator = windowhandle.iterator();
		String Parentwindow = iterator.next();
		System.out.println(Parentwindow);
		String Childwindow = iterator.next();
		System.out.println(Childwindow);
		driver.switchTo().window(Childwindow);
		System.out.println(driver.getTitle());
		driver.findElement(By.name("UserFirstName")).sendKeys("Pavan");
		driver.findElement(By.name("UserLastName")).sendKeys("Chaudhari");
		driver.switchTo().window(Parentwindow);
		System.out.println(driver.getTitle());
		
	}
}
