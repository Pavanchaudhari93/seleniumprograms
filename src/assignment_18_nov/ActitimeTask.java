package assignment_18_nov;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Openbrowser;

public class ActitimeTask {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Openbrowser.setup("chrome", "https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.id("container_tasks")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"taskManagementPage\"]/div[1]/div[1]/div[1]/div[1]/div[3]/div")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[19]/div[3]")).click();Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[1]/div[3]")).click();Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[2]/div/div[1]/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[2]/td[1]/input")).sendKeys("Pavan H Chaudhari");
		driver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[4]/td[1]/input")).sendKeys("Acceleration");
		driver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[1]/input")).sendKeys("Task Creation and Deletion");
		Thread.sleep(4000);driver.findElement(By.xpath("//*[@id=\"ext-gen51\"]/td[2]")).click();Thread.sleep(4000);
//		driver.findElement(By.xpath("//*[@id=\"ext-gen136\"]")).click();
//		date
		driver.findElement(By.xpath("//*[@id=\"ext-gen105\"]/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/a/em/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"ext-gen143\"]")).click();
//		checkbox
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[6]/label/span[2]"));
		System.out.println("Displayed or not : "+checkbox.isDisplayed());
		System.out.println("Enebled or not : "+checkbox.isEnabled());
		System.out.println("Selected or not : "+checkbox.isSelected());
		checkbox.click();
		System.out.println("After clicking, ckeckboc is Selected or not : "+checkbox.isSelected());
//		create task
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[2]/div[2]/div[1]/div/div[1]")).click();
//		Task Deletetion
		driver.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[1]/div[2]/div[2]/div[1]/div/table/tbody/tr/td[1]/div/input")).sendKeys("Task Creation and Deletion");Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[4]/div/div/div[1]/div/div[6]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"taskManagementPage\"]/div[2]/div[2]/div[1]/div[1]/div/div[5]/div[1]/div")).click();
	}

}
