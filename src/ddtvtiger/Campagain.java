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

public class Campagain {
	WebDriver driver;
	

	@BeforeClass
	public void setup() {
		driver= Openbrowser.setup("chrome","http://vtiger-demo.it-solutions4you.com/index.php");
	}
	
	@Test(priority=4)
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

	@Test(priority=5)
	public void CreateCampaigans()
	{
		driver.findElement(By.id("appnavigator")).click();
		Actions action=new Actions(driver);
		WebElement marketing=driver.findElement(By.xpath("//*[@id=\"app-menu\"]/div/div[2]/div[2]"));
		action.moveToElement(marketing).perform();
		
		List<WebElement> submenu=driver.findElements(By.xpath("//*[@id=\"mCSB_1_container\"]/li"));
		
		for(int i=0;i<submenu.size()-1;i++);
		submenu.get(0).click();
		
		driver.findElement(By.id("Campaigns_listView_basicAction_LBL_ADD_RECORD")).click();
		driver.findElement(By.id("Campaigns_editView_fieldName_campaignname")).sendKeys("Disney");
		
		driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).click();
		driver.switchTo().activeElement().sendKeys("admin",Keys.ENTER);
//		or
//		WebElement search=driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]"));
//		search.sendKeys("admin",Keys.ENTER);

		
//		date select
		driver.findElement(By.id("Campaigns_editView_fieldName_closingdate")).click();
//		momth change
		driver.findElement(By.xpath("//div[1]/table/thead/tr[1]/th[3]")).click();
//		date picker
		driver.findElement(By.cssSelector(".datepicker-days>table>tbody>tr:nth-of-type(2)>td:nth-of-type(4)")).click();
//		xpth--> //div[7]/div[1]/table/tbody/tr[2]/td[4]
		
//		save campaigans
		driver.findElement(By.cssSelector(".btn.btn-success.saveButton")).click();
		
		driver.navigate().back();
		driver.navigate().back();
		
//		verify new campaigns saved
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Disney"), "new campaigns not saved");
		
	}
	
	@Test(priority=6)
	public void EditCampaigans()
	{
		driver.findElement(By.xpath("//*[@id=\"Campaigns_listView_row_1\"]/td[1]/div/span[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"page\"]/ul[3]/li[2]")).click();
		
		driver.findElement(By.id("s2id_autogen5")).click();
		driver.switchTo().activeElement().sendKeys("Primary",Keys.ENTER);
		driver.findElement(By.cssSelector(".btn.btn-success.saveButton")).click();
		
//		ckeck campaigns edited or not
		String bodyText=driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Primary Email"), "Campaigns not edited");
	}
	
	@Test(priority=7)
	public void DeleteCampaigns() {
		System.out.println("ok");
//		driver.findElement(By.xpath("//*[@id=\"Campaigns_listView_row_1\"]/td[1]/div/span[3]/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"page\"]/ul[3]/li[3]/a")).click();
//		driver.findElement(By.xpath("//div[2]/div/div[2]/button[2]")).click();
		String bodyText=driver.findElement(By.tagName("body")).getText();
		WebElement delete=driver.findElement(By.xpath("//*[@id=\"Campaigns_listView_row_1\"]/td[1]/div/span[1]/input"));
		delete.click();
		delete.isSelected();
		driver.findElement(By.xpath("//*[@id=\"Campaigns_listView_massAction_LBL_DELETE\"]")).click();
		driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div[2]/button[2]")).click();
		Assert.assertFalse(bodyText.contains("Primary Email"), "Campaigns not Deleted");
		
	}
	
	@AfterClass
	void chormeclose() {
		driver.close();
		System.out.println("done");
	}
}
