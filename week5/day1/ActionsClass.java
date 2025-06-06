package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionsClass {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver drive = new ChromeDriver();
		
		drive.manage().window().maximize();// maximize the browser

		drive.get("https://www.amazon.in/");// Load the Url
		
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		drive.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		
		drive.findElement(By.id("nav-search-submit-button")).click();
		
		WebElement element = drive.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		
		String prizeOfPhone = element.getText();
		System.out.println("Price list displayed first is "+prizeOfPhone);
		
		//Actions mouseHover=new Actions(drive);
		WebElement moreElement = drive.findElement(By.xpath("(//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal'])[1]"));
		//mouseHover.moveToElement(moreElement).click().perform();
		moreElement.click();
		String phoneDetails = moreElement.getText();
		System.out.println(phoneDetails);
		
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Set<String> windowHandles1 = drive.getWindowHandles(); // declaring the window handling as set
		List<String> window1 = new ArrayList<String>(windowHandles1); // convert set to List
		drive.switchTo().window(window1.get(1));
		
		drive.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		
		Thread.sleep(1000);
		
		//drive.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button-announce']")).click();
		
		String subTotal = drive.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		System.out.println("Sub Total of the Cart is "+ subTotal);
		
		
		
		//drive.close();
	
	}

}
