package screenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;



public class ScreenshotEg 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.safari.driver", "/Users/pavanchaudhari/eclipse-workspace/A-SeleniumDemo/SafariDriver.safariextz");
		
		WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		TakesScreenshot ss=((TakesScreenshot)driver);
		File cpFile=ss.getScreenshotAs(OutputType.FILE);
		
		//take current date and time
		SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		Date date=new Date();
		String abc=f.format(date).toString().replace("/", " ");
		String exactpathfilename=abc.replace(" ", " ").replace(":", " ");
		System.out.println("exactpathfilename: "+exactpathfilename);
		
		String capturepath="/Users/pavanchaudhari/eclipse-workspace/A-SeleniumDemo/ss/DateAndTime.png";
		
		try 
		{
			//save the ss in destination path
			FileUtils.copyFile(cpFile, new File(capturepath));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		driver.close();		
		
	}
}
