package screenshot;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Openbrowser;

public class Google {

	public static void main(String[] args) {
		WebDriver driver=Openbrowser.setup("chrome", "https://www.google.com");
		driver=new ChromeDriver();
		Utilities.getscreenshot(driver,"./screenshot/google.jpg");

	}

}
