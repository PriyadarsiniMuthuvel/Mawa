package action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class Training {
	public static void main(String args[])throws Exception
	 {
	  // Open Firefox
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mstemp001\\workspace\\HybridDemo\\ChromeDriver\\chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
	                
	  // Maximize the window
	  driver.manage().window().maximize();
	 
	  // Open facebook
	  driver.get("https://login.salesforce.com/");
	 
	  // Enter Username
	  driver.findElement(By.id("username")).sendKeys("priyadarsinipriya91@gmail.com");
	 
	  // Enter password
	  driver.findElement(By.id("password")).sendKeys("mst2016");
	 
	  // Create object of Robot class
	  Robot r=new Robot();
	 
	   // Press Enter
	   r.keyPress(KeyEvent.VK_ENTER);
	 
	   // Release Enter
	   //r.keyRelease(KeyEvent.VK_ENTER);
	                  
	}
	 
}
