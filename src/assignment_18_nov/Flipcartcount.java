package assignment_18_nov;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipcartcount {
	static boolean result;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		WebDriver cd=new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("https://www.flipkart.com/");
		System.out.println(cd.getCurrentUrl());
		if(cd.getCurrentUrl().equalsIgnoreCase("https://www.flipkart.com/")) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		List<WebElement> listofelement = cd.findElements(By.cssSelector("._37M3Pb>div>a>div"));
		int count=listofelement.size();
		System.out.println("count of element is: "+count);
		for(int i=0;i<count;i++) {
			System.out.println(listofelement.get(i).getText());
		}
	}
}
