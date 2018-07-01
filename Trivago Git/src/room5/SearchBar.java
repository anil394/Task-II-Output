package room5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchBar {

	@Test
	public void locationSearch() {
	System.setProperty("webdriver.chrome.driver", "F:/chromedriver.exe");//Path to Browser driver
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://room5.trivago.com/");//Launching test Web site
	
	//Search for test location on search bar
	driver.findElement(By.className("search-icon")).click();
	WebElement locate=driver.findElement(By.xpath("//*[@id='search']/div[1]/div[2]/input"));
	locate.sendKeys("Europe");
	locate.sendKeys(Keys.ENTER);
	
	driver.close();
	}
}

