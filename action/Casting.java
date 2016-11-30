package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Casting {
	
	public static void main(String args[]){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mstemp001\\workspace\\HybridDemo\\ChromeDriver\\chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		    //driver=new FirefoxDriver();
		    driver.manage().window().maximize();
		    driver.get("http://www.google.com");
	}
	}

