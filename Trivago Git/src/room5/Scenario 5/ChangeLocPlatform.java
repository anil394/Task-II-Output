package room5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeLocPlatform{
	
	@Test
	public void changeLocation(){
	System.setProperty("webdriver.chrome.driver", "F:/chromedriver.exe");//Path to Browser driver
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://room5.trivago.com/");//Launching given Web site
	
	Select drpCountry=new Select (driver.findElement(By.className("locales-dropdown")));
	drpCountry.selectByVisibleText("Deutschland");//Test location is selected
	
	//Checkpoint to verify URL for selected Location
	String currentUrl=driver.getCurrentUrl();
	Assert.assertEquals(currentUrl, "http://room5.trivago.de/");
	
	driver.close();
    }
}