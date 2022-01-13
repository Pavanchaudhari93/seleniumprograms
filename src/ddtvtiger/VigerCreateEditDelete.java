package ddtvtiger;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.Openbrowser;

public class VigerCreateEditDelete {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver= Openbrowser.setup("chrome","http://vtiger-demo.it-solutions4you.com/index.php");
	}
	
	@Test(priority=0)
	public void login() throws InterruptedException
	{
		Assert.assertEquals(driver.getTitle(),"vtiger - Demo of CRM vtiger 7.1 by IT-Solutions4You","False");
		WebElement txtmail=driver.findElement(By.id("username"));
		txtmail.clear();
		txtmail.sendKeys("standarduser",Keys.TAB);
		
		WebElement txtpwd=driver.switchTo().activeElement();
		txtpwd.clear();
		txtpwd.sendKeys("standarduser");
		
		driver.findElement(By.xpath("//*[@id=\"loginFormDiv\"]/form/div[3]/button")).click();
	}
	@Test(priority=1)
	public void CreateContact() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"appnavigator\"]/div/span")).click();
		Actions action = new Actions(driver);
		WebElement listMarketing =driver.findElement(By.xpath("//*[@id=\"MARKETING_modules_dropdownMenu\"]/div/span[2]"));

		action.moveToElement(listMarketing).perform();
		
		List<WebElement> submenu=driver.findElements(By.xpath("//*[@id=\"mCSB_1_container\"]/li"));
		System.out.println(submenu.size());
		
		for(int i=0;i<submenu.size()-1;i++) {
			System.out.println(submenu.get(i).getText());
		}
		submenu.get(2).click();
		
		driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
		
//		WebElement dropdown=driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]"));

		driver.findElement(By.id("Contacts_editView_fieldName_firstname")).sendKeys("Pavan");
		driver.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys("Chaudhari");
//		driver.findElement(By.xpath("//*[@id=\"s2id_autogen5\"]/a")).click();
//		driver.findElement(By.xpath("//*[@id=\"s2id_autogen6_search\"]")).sendKeys("admin",Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"EditView\"]/div[3]/div/div/button")).click();
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(2000);
		
//		verify is new contact created or not 
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Pavan"), "Text not found!");
	}
	@Test(priority=2)
	public void EditContact()
	{
		driver.findElement(By.xpath("//*[@id=\"Contacts_listView_row_1\"]/td[1]/div/span[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"page\"]/ul[3]/li[2]")).click();
		driver.findElement(By.id("Contacts_editView_fieldName_mobile")).sendKeys("7709059929");
		driver.findElement(By.xpath("//*[@id=\"EditView\"]/div[3]/div/div/button")).click();
//		verify is new contact is Edited or not 
		String EditbodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(EditbodyText.contains("7709059929"), "Number not found!");
	}	
	@Test(priority=3)
	public void DeleteContact() throws InterruptedException
	{	
		driver.findElement(By.xpath("//*[@id=\"Contacts_listView_row_1\"]/td[1]/div/span[4]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"page\"]/ul[3]/li[3]")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div[2]/button[2]")).click();
		Thread.sleep(2000);
//		verify is new contact is Deleted or not 
		String DeletebodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertFalse(DeletebodyText.contains("7709059929"), "Contact successfully Deleted!");
		
	}
	
	@AfterClass
	void chormeclose() {
		driver.close();
		System.out.println("done");
	}
}