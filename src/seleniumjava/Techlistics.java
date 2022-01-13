package seleniumjava;

import java.awt.Dimension;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Techlistics {

	public static void main(String[] args) throws InterruptedException {
		String path=System.getProperty("user.dir")+"./executables/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		ChromeDriver cd=new ChromeDriver();   
		cd.get("https://www.techlistic.com/");
		org.openqa.selenium.Dimension d= new org.openqa.selenium.Dimension(900,900);
		cd.manage().window().setSize(d);
//		or
//		cd.manage().window().maximize();    
		cd.findElement(By.cssSelector("a[href='https://www.techlistic.com/p/java.html']")).click();
//		Thread.sleep(4000);
		String actualtitle=cd.getTitle();
		System.out.println(actualtitle);
//		String expactedtitle="https://www.techlistic.com/p/java.html";
//		if(actualtitle.equals(expactedtitle)) {
//			System.out.println("page title is same");
//		}else {
//			System.out.println("page title is different");
//		}
////			or
//			if(cd.getTitle().contains("https://www.techlistic.com/p/java.html"))
//				System.out.println("java page title is same");
//			else 
//				System.out.println("java page title is different");
//			
//			cd.navigate().back();
//			
//			cd.findElement(By.cssSelector("a[href='https://www.techlistic.com/p/selenium-tutorials.html']")).click();
//			
//			Thread.sleep(4000);
//			if(cd.getTitle().contains("https://www.techlistic.com/p/selenium-tutorials.html"))
//				System.out.println("selenium page title is same");
//			else 
//				System.out.println("selenium page title is different");
//			
//			cd.navigate().back();
//			
			
	}
	}

