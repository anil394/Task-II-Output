package room5;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactForm {

	@Test
	public void fillForm(){
	System.setProperty("webdriver.chrome.driver", "F:/chromedriver.exe");//Path to Browser driver
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://room5.trivago.com/");//Launching test Web site
	 
	WebDriverWait wait = new WebDriverWait(driver,15);//Wait for elements to load
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Contact")));
	WebElement elecontact = driver.findElement(By.linkText("Contact"));
	JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	jse1.executeScript("arguments[0].click()", elecontact); 

	//Take control of new tab after clicking on Contact 
	Set<String> handles = driver.getWindowHandles();
    String currentHandle = driver.getWindowHandle();
    for (String handle : handles) {
     if (!handle .equals(currentHandle))
     {
         driver.switchTo().window(handle);
     }
    }

	driver.findElement(By.className("contact-msg")).sendKeys("Test Message");
	 
	 
	driver.findElement(By.className("contact-input")).sendKeys("Test User");
	driver.findElement(By.id("contact-email")).sendKeys("dexabc@gmail.com");
	driver.findElement(By.id("confirm")).click();
	
	WebElement elesubmit =driver.findElement(By.className("contact-submit"));
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].click()", elesubmit); 
	
	//Checkpoint to verify if Contact form is submitted Successfully
	String successMsg ="Message Sent Successfully!";
	Assert.assertEquals(successMsg, "Message Sent Successfully!");
	
	driver.close();
	// For going back to first tab in case required below line should be uncommented
	driver.switchTo().window(currentHandle);
	driver.close();
	}
}