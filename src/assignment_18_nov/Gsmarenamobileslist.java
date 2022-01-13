package assignment_18_nov;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gsmarenamobileslist {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./executables/chromedriver.exe");
		WebDriver cd=new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("https://www.gsmarena.com/");
		System.out.println(cd.getCurrentUrl());
		if(cd.getCurrentUrl().equalsIgnoreCase("https://www.gsmarena.com/")) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		List <WebElement> mobcount=cd.findElements(By.cssSelector(".brandmenu-v2>ul>li"));
		int count=mobcount.size();
		System.out.println("Total mobile count is: "+count);
		for(int i=0;i<count;i++) {
				System.out.println(mobcount.get(i).getText());
		}
	}
}