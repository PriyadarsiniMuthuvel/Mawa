import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserOPen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mstemp001\\workspace\\HybridDemo\\ChromeDriver\\chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.google.co.in/?gfe_rd=cr&ei=yudTWKX0Ban98wfqjo-wCg");
		 driver.findElement(By.id("sb_ifc0")).sendKeys("selenium");
		 
	}

}
