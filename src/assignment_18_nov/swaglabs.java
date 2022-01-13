package assignment_18_nov;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class swaglabs {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver cd=new ChromeDriver();
//		cd.manage().window().maximize();
//		Dimension dm=new Dimension(450,500);
//		cd.manage().window().setSize(dm);
		cd.get("https://www.saucedemo.com/");
		if(cd.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/")) {
			System.out.println("Correct page opened");
		}else {
			System.out.println("Page opened is incorrect");
		}
		List <WebElement> username1=cd.findElements(By.xpath("//div[@id='login_credentials']"));
		int count1=username1.size();
		for(int a=0;a<count1;a++) {
			System.out.println(username1.get(a).getText());
		}
		List <WebElement> username=cd.findElements(By.xpath("//div/br"));
		int count=username.size();
		System.out.println(count+"count");
		for(int i=0;i<count;i++) {
			System.out.println(username.get(i).getText());
		}System.out.println("end");
		
		cd.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		cd.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		cd.findElement(By.xpath("//input[@name='login-button']")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//button[text()=('Open Menu')]")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//a[@id=('logout_sidebar_link')]")).click();
		Thread.sleep(2000);
		cd.close();	
	}
}