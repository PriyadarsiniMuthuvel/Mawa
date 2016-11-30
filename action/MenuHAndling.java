package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuHAndling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mstemp001\\workspace\\HybridDemo\\ChromeDriver\\chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
	               
	 // Maximize the window
	 driver.manage().window().maximize();
	 driver.get("https://cs52.salesforce.com/");
	 driver.findElement(By.id("username")).sendKeys("vennila@mstsolutions.com.fullcopy");
	 driver.findElement(By.id("password")).sendKeys("metasoft2");
	 driver.findElement(By.id("Login")).click();
	 Thread.sleep(2000);
	WebElement Mmenu=driver.findElement(By.xpath("html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[2]/div/div/div[1]/span"));
	//WebElement E = (new WebDriverWait(driver, 15))
			//  .until(ExpectedConditions.presenceOfElementLocated(By.linkText("TestQAAug15 TestQAAug15")));
	WebElement SbMenu=driver.findElement(By.xpath("html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[2]/div/div/div[2]/div[3]/a[4]"));
	Actions builder = new Actions(driver);
	// Move cursor to the Main Menu Element
	builder.moveToElement(Mmenu).click();
	// Giving 5 Secs for submenu to be displayed
	Thread.sleep(5000);
	// Clicking on the Hidden SubMenu
	SbMenu.click();
	}

}
