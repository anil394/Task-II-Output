package room5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Destination {
	
	@Test
	public void destNavigate(){
	System.setProperty("webdriver.chrome.driver", "F:/chromedriver.exe");//Path to Browser driver
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://room5.trivago.com/");//Launching test Web site
	
	driver.findElement(By.className("nav-icon")).click();
	driver.findElement(By.className("menu-title")).click();
	driver.findElement(By.className("destination-menu")).click();//Navigated to destination through Menu
	
	driver.close();
    }
}