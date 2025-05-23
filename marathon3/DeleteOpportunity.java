package marathon3;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteOpportunity extends baseClass {

		// "1. Login to https://login.salesforce.com
		// 2. Click on toggle menu button from the left corner
		// 3. Click view All and click Sales from App Launcher
		// 4. Click on Opportunity tab
		// 5. Search the Opportunity 'Salesforce Automation by *Your Name*'
		// 6. Click on the Dropdown icon and Select Delete
		// 7. Verify Whether Oppurtunity is Deleted using Oppurtunity Name
	@DataProvider(name="fetchData")
	public String [][] sendData() throws IOException{
		
		String[][] readData=ReadExcel1.readData();
		return readData;
		}
	

@Test(dataProvider = "fetchData" )
		

		public void runDeleteOpporunity(String OpporuntityName) throws InterruptedException {

		// Click on toggle menu button
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// Click view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// Click Sales from App Launcher
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// Click on Opportunity tab
		WebElement opportunities = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		driver.executeScript("arguments[0].click();", opportunities);
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[contains(@class,'test-listviewdisplayswitcher')]")).click();
		driver.findElement(By.xpath("//li[@title='Display as kanban']")).click();

		// 5. Search the Opportunity 'Salesforce Automation by *Your Name*'
		WebElement oppName = driver.findElement(By.xpath("//label[text()='Search this list...']//following::input[1]"));
		oppName.sendKeys(OpporuntityName);
		Thread.sleep(2000);
		oppName.sendKeys(Keys.ENTER);

		// 6. Click on the Dropdown icon and Select Delete
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='showActionsButtonContainer'])[1]")).click();

		WebElement delete = driver.findElement(By.xpath("(//div[text()='Delete'])[1]"));
		driver.executeScript("arguments[0].click();", delete);

		driver.findElement(By.xpath("//span[text()='Delete']")).click();

	}
}
