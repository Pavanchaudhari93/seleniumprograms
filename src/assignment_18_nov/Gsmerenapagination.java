package assignment_18_nov;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

public class Gsmerenapagination {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver cd=new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("https://www.gsmarena.com/");
//		validating home page
		System.out.println(cd.getCurrentUrl());
		if(cd.getCurrentUrl().equalsIgnoreCase("https://www.gsmarena.com/")) {
			System.out.println("Correct page opened");
		}else {
			System.out.println("Page opened is incorrect");
		}
//		clicking on realme phones 
		cd.findElement(By.cssSelector(".brandmenu-v2>ul>li:nth-of-type(1)>a")).click();
		System.out.println("Openning RealMe Phones");
		Thread.sleep(10000);
//		checking the page has pagination or not 
		List <WebElement> pagination=cd.findElements(By.cssSelector(".nav-pages>a"));
		int pagecount=pagination.size();
		System.out.println("checking wheather the page has pagination or not");
		if(pagecount>0) {
			System.out.println("page has pagination");
		System.out.println("and no of page is: "+pagecount);
		}else {
			System.out.println("No pagination");
		}
//		printing the pagination name
		System.out.println("pagination link names are : ");
		for(int i=0;i<pagecount;i++) {
			System.out.println(pagination.get(i).getText());
		}
		Thread.sleep(4000);
//		navigating each page and getting URL of each page
		System.out.println("navigating each page and getting URL of each page:");
		for(int i = 1 ; i <=pagecount ; i++) {
			String nextpage= ".nav-pages>a:nth-of-type("+i+")";
			cd.findElement(By.cssSelector(nextpage)).click();
			System.out.println("page "+i+"URL is : "+cd.getCurrentUrl());
		}
//		cd.close();
	}
}