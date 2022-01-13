package assignment_18_nov;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vtiger {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver cd=new ChromeDriver();
//		cd.manage().window().maximize();
//		Dimension dm=new Dimension(450,500);
//		cd.manage().window().setSize(dm);
		cd.get("https://demo.vtiger.com/vtigercrm/index.php");
		cd.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//span[@class=('fa fa-user')]")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//a[text()=('Sign Out')]")).click();
	}
}
