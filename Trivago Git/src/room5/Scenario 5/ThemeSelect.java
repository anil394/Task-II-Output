package room5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThemeSelect {

	@Test
	public void selTheme(){
	System.setProperty("webdriver.chrome.driver", "F:/chromedriver.exe");//Path to Browser driver
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://room5.trivago.com/");//Launching test Web site
	
	driver.findElement(By.className("nav-icon")).click();
	
	WebElement themeFamily = driver. findElement(By.xpath("//*[@id='menu']/div/div/div[2]/div[2]/div/div[1]/div[2]/a/div/div"));
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click()", themeFamily); //Test theme "Family" is selected
	
	driver.close();
    }
}