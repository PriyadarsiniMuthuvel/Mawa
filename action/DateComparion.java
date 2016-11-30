package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateComparion {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SimpleDateFormat gmtDateFormat = new SimpleDateFormat("MM-dd-YYYY");
		gmtDateFormat.setTimeZone(TimeZone.getTimeZone("US/Arizona"));
		String GDate = gmtDateFormat.format(new Date());
        System.out.println("Current Date and Time in GMT time zone: " + GDate);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mstemp001\\workspace\\HybridDemo\\ChromeDriver\\chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://cs52.salesforce.com/00Q5B000001tiDg");
		 driver.findElement(By.id("username")).sendKeys("vennila@mstsolutions.com.fullcopy");
		 driver.findElement(By.id("password")).sendKeys("metasoft2");
		 driver.findElement(By.id("Login")).click();
		 Thread.sleep(2000);
		WebElement Ldate= driver.findElement(By.cssSelector("div[id='00N3600000POLjS_ileinner']"));
		String SDate=Ldate.getText();
		 System.out.println(SDate);
		 if(SDate.equals(GDate))
		 {
			 System.out.println("Both date are Matched Successfully!!");
		 }
			 else{
				 System.out.println("Both date are not Matched!!");}
	 }
}

