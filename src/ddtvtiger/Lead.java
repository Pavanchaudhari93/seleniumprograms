package ddtvtiger;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.Openbrowser; 

public class Lead {
	WebDriver driver;
		
	@BeforeClass
	public void setup() {
		driver= Openbrowser.setup("chrome","http://vtiger-demo.it-solutions4you.com/index.php");
	}
		
	@Test(priority=8)
	public void login() {
		driver.findElement(By.xpath("//*[@id=\"loginFormDiv\"]/form/div[3]/button")).click();
		
		}
	@Test(priority=9)
	public void createlead() {
		driver.findElement(By.id("appnavigator")).click();
		Actions action=new Actions(driver);
		WebElement marketing=driver.findElement(By.xpath("//*[@id=\"app-menu\"]/div/div[2]/div[2]"));
		action.moveToElement(marketing).perform();;
		
		List<WebElement> submenu=driver.findElements(By.xpath("//*[@id=\"mCSB_1_container\"]/li"));
		submenu.get(1).click();
		
		driver.findElement(By.id("Leads_listView_basicAction_LBL_ADD_RECORD")).click();
		driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]/a")).click();
		driver.switchTo().activeElement().sendKeys("Mr.",Keys.ENTER);
		driver.findElement(By.id("Leads_editView_fieldName_firstname")).sendKeys("Pavan");
		driver.findElement(By.id("Leads_editView_fieldName_lastname")).sendKeys("chaudhari");
		
		driver.findElement(By.tagName("body")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
		
		driver.findElement(By.xpath("//*[@id=\"s2id_autogen11\"]/a")).click();
		driver.switchTo().activeElement().sendKeys("Marketing",Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"EditView\"]/div[3]/div/div/button")).click();
		
		driver.navigate().back();
		driver.navigate().back();
		
		String bodytext=driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodytext.contains("chaudhari"), "Lead not created");
		
	}
	
	@Test(priority=10)
	public void Editlead() {
		driver.findElement(By.xpath("//*[@id=\"Leads_listView_row_1\"]/td[1]/div/span[4]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"page\"]/ul[3]/li[2]")).click();
		driver.findElement(By.id("Leads_editView_fieldName_mobile")).sendKeys("7709059929");
		driver.findElement(By.xpath("//*[@id=\"EditView\"]/div[3]/div/div/button")).click();
		String bodytext=driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodytext.contains("7709059929"), "Lead not Edited");
	}
	@Test(priority=11)
	public void Deletelead() {
		driver.findElement(By.xpath("//*[@id=\"Leads_listView_row_1\"]/td[1]/div/span[4]/span/i")).click();
		driver.findElement(By.xpath("//*[@id=\"page\"]/ul[3]/li[3]")).click();
		driver.findElement(By.cssSelector(".btn.confirm-box-ok.confirm-box-btn-pad.btn-primary")).click();
		String bodytext=driver.findElement(By.tagName("body")).getText();
		Assert.assertFalse(bodytext.contains("Pavan"), "Lead not Deleted");
	}
	
	
	
	
	
	
	
	
	

}
