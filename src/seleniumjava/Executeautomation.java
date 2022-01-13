package seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Executeautomation {

	public static void main(String[] args) throws InterruptedException {
		String chromeDriverPath=System.getProperty("user.dir")+"/exe/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver ffd=new ChromeDriver();
		ffd.manage().window().maximize();
		ffd.get("https://demosite.executeautomation.com/Login.html");
		ffd.navigate().back();
		Thread.sleep(5000);
		ffd.navigate().forward();
		String pagetitle=ffd.getTitle();
		System.out.println("page title is : "+pagetitle);
		int pagetitlelength=ffd.getTitle().length();
		System.out.println("page title length is : "+pagetitlelength);
		String expactedpageurl=ffd.getCurrentUrl();
		System.out.println("current page url is : "+expactedpageurl);
		String actualpageurl="https://demosite.executeautomation.com/Login.html";
		if(expactedpageurl.equals(actualpageurl)){
			System.out.println("URL opened is correct");
		}else {
			System.out.println("URL opened is incorrect");
		}
		ffd.findElement(By.cssSelector("input[name='UserName']")).sendKeys("ecxecution");
		ffd.findElement(By.name("Password")).sendKeys("admin");
		ffd.findElement(By.cssSelector("input[value='Login']")).click();
//		ffd.findElement(By.xpath("input[@value='Login'])")).click();
		Thread.sleep(2000);
		String hometitle=ffd.getTitle();
		System.out.println("home page title is : "+hometitle);
		String homeurl=ffd.getCurrentUrl();
		System.out.println("home page url is :"+homeurl);
		ffd.findElement(By.cssSelector("a[href='Login.html']")).click();
		}
	}

