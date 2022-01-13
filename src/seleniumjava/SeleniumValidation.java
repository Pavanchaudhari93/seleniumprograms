package seleniumjava;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumValidation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		//creating an object of chromedriver class and upcasting it to WebDriver interface
		WebDriver driver=new ChromeDriver();
		//enter required application url
		driver.get("https://demo.actitime.com/login.do");
		//implicit wait
//		Thread.sleep(30000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		/* driver can wait for the element from 0-30 sec*/
		System.out.println("Page title before login: "+driver.getTitle());
		//identify username field
		WebElement userNameInputField=driver.findElement(By.id("username"));
		/*
		 * Validation on username field:	
		 * 				1. Visible or not  ---> isDisplayed()---> boolean --> true: visible, false: not visible
		 * 				2. editable or not ---> isEnabled()---> boolean --> true: editable/clickable, false: not editable/clickable
		 *				3. get attribute value based on attribute name ---> getAttribute(String arg)
		 */
//		boolean visibilityOfUserNameField=userNameInputField.isDisplayed();
//		System.out.println(visibilityOfUserNameField);
						//or
		System.out.println("UserName field visibility is: "+userNameInputField.isDisplayed());
		System.out.println("UserName field is editable or not: "+userNameInputField.isEnabled());
		System.out.println("placeholder value of user namefield: "+userNameInputField.getAttribute("placeholder"));
	
		WebElement loginButton=driver.findElement(By.id("loginButton"));
		System.out.println("Button display status: "+loginButton.isDisplayed());
		System.out.println("Button clickable status: "+loginButton.isEnabled());
		System.out.println("Button name: "+loginButton.getText());
		
		//identify checkbox
		WebElement checkBox=driver.findElement(By.id("keepLoggedInCheckBox"));
		/*
		 * Validation on checkBox/radio field:	
		 * 				1. Visible or not  ---> isDisplayed()---> boolean --> true: visible, false: not visible
		 * 				2. editable or not ---> isEnabled()---> boolean --> true: editable/clickable, false: not editable/clickable
		 *				3. checked or not ----> isSelected()---> boolean --> true: selected, false: not selected
		 */
		System.out.println("checkBox field visibility is: "+checkBox.isDisplayed());
		System.out.println("checkBox field is editable or not: "+checkBox.isEnabled());
		System.out.println("checkBox field is selected or not: "+checkBox.isSelected());
		checkBox.click();
		System.out.println("checkBox field is selected or not: "+checkBox.isSelected());
		//close current browser
		//driver.close();		
	}
}