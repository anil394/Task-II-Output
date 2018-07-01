package room5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscribeNewsletter {

@Test
	public void subscription (){
	System.setProperty("webdriver.chrome.driver", "F:/chromedriver.exe");//Path to Browser driver
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://room5.trivago.com/");//Launching test Web site
	 
	WebElement confirmBox = driver.findElement(By.xpath("//*[@id='confirm']"));
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].click()", confirmBox); 
	
	driver.findElement(By.className("et-email")).sendKeys("dexabc@gmail.com");
	driver.findElement(By.className("submit")).click();
	

	//Checkpoint to verify if Newsletter subscription is successful
	String successMsg ="You are now checked-in!";
	Assert.assertEquals(successMsg, "You are now checked-in!");
	
	driver.close();
	
	}
}