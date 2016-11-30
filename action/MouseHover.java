package action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHover {
	public static void main(String args[])throws Exception
	 {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Mstemp001\\workspace\\HybridDemo\\ChromeDriver\\chromedriver.exe"); 
	 WebDriver driver=new ChromeDriver();
               
 // Maximize the window
 driver.manage().window().maximize();
 driver.get("https://cs52.salesforce.com/a0T5B0000007M0i");
 driver.findElement(By.id("username")).sendKeys("vennila@mstsolutions.com.fullcopy");
 driver.findElement(By.id("password")).sendKeys("metasoft2");
 driver.findElement(By.id("Login")).click();
 WebElement E = (new WebDriverWait(driver, 15))
		  .until(ExpectedConditions.presenceOfElementLocated(By.linkText("TestQAAug15 TestQAAug15")));
 //WebElement menu = driver.findElement(By.linkText("TestQAAug15 TestQAAug15"));
 Actions action = new Actions(driver);
 action.moveToElement(E).perform();
 Thread.sleep(2000);
 if(driver.findElement(By.id("lookup0033600000QJ8Wz00N3600000MqwPCHover")).isDisplayed()){
	 String toolTipText = driver.findElement(By.id("lookup0033600000QJ8Wz00N3600000MqwPCHover")).getText();
		System.out.println("Tool tip text present :- " + toolTipText);
 }

 
 //driver.switchTo().alert();
 //E.getScreenshotAs(arg0)
 
driver.close();
	
 
 
 // Enter Username


	 }
	
	
	}
