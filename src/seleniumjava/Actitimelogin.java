package seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actitimelogin {

	public static void main(String[] args) {
//		Step1: set path for driver executables
//		System.setProperty("webdriver.chrome.driver", "D:\\pavan\\workspace\\Selenium project1\\executables\\chromedriver.exe");
		
		 String chromeDriverPath=System.getProperty("user.dir")+"/executables/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
//		Step2: Create an instance of ChromeDriver class and upcast it to WebDriver Interface
		WebDriver Cdriver=new ChromeDriver();
		
// 		enter application url
		Cdriver.get("https://demo.actitime.com/login.do");
				
				/**
				 * findElement(By): is used to identify element from the Web page it takes 'By'class as an argument
				 * and return WebElement
				 * By: 'By' class is a predefined selenium class which has several static method in it, those static methods
				 * are known as locators in selenium
				 * locators support by Selenium:
				 * 	1.id(String) 2.name(String) 3.className(String) 4.tagName(String) 5.linkText(String) 6.partialLinkText(String)
				 *  7.cssSelector(String) 8.xpath(String)
				 *  
				 * driver.findElement(By)
				 * 
				 * Action:
				 * 		1. typing: sendKeys("")
				 * 		2. click:  click();
				 * 		3. deleting existing text: clear()
				 * 
				 * Note: if the given locator is not unique dn selenium will not throw any error message but it will always performs
				 *  operation on the first element
				 */

//		Print PageTitle after loading page
		String PageTitle=Cdriver.getTitle();
		System.out.println("Page Title is : "+PageTitle);
//		or
//		System.out.println("Page Title is : "+Cdriver.getTitle());
		
//		print Title length
		int titlelength=Cdriver.getTitle().length();
		System.out.println("Title length is : "+titlelength);
		
//		Compare actual title and expacted title
		String ExpactedTitle="actiTIME - Login";
		String ActualTitle=Cdriver.getTitle();
		
//		check Expacted and Actual Title
		if(ExpactedTitle.equals(ActualTitle)) {
			System.out.println("ExpactedTitle and ActualTitle both are same");
		}else{
			System.out.println("ExpactedTitle and ActualTitle both are not same");
		}
		
//		Print current url
		System.out.println("Page Url is : "+Cdriver.getCurrentUrl());
		System.out.println("Lengh of page Url is : "+Cdriver.getCurrentUrl().length());
//		getTitle and getCurrentUrl returns String Value
		
//		check page url
		String Actualurl="https://demo.actitime.com/login.do";
		String Expactedurl=Cdriver.getCurrentUrl();
		
//		verify that correct url is opened
		if(Actualurl.equals(Expactedurl)) {
			System.out.println("Actual Url and Expacted Url both are same");
		}else {
			Cdriver.close();
			}
			
		String pagesourcecode=Cdriver.getPageSource();
//		System.out.println(pagesourcecode);
		System.out.println("pagesourcecode length is : "+pagesourcecode.length());
		
//		enter username: 1st Identify username field and dn perform required action(typing)
		WebElement enterusername=Cdriver.findElement(By.name("username"));
		enterusername.sendKeys("admin");

//		enter password: 1st Identify password field and dn perform required action(typing)
		WebElement enterpassword=Cdriver.findElement(By.name("pwd"));
		enterpassword.sendKeys("manager");
		
//		click on loginbutton
		WebElement loginbutton=Cdriver.findElement(By.id("loginButton"));
		loginbutton.click();
		
//		close the browser
//		Cdriver.close();
		
	}
}
