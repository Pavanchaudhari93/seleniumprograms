package seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Amezon_in {

	public static void main(String[] args) throws InterruptedException {
		String chromeDriverPath=System.getProperty("user.dir")+"/executables/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver cd=new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("https://www.amazon.in");
		String T1=cd.getTitle();
		System.out.println("page Title: "+T1);
		cd.findElement(By.cssSelector(".nav-fill/div>div>*:nth-child(2)")).click();
		Thread.sleep(4000);
		System.out.println("new page Title: "+cd.getTitle());
		cd.navigate().back();
		String T2=cd.getTitle();
		if(T2.equals(T1)) {
			System.out.println("system is going Well");
		}else {
			cd.close();
		}
		    cd.close();
	}
}
