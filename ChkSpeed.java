
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ChkSpeed {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mstemp001\\workspace\\HybridDemo\\ChromeDriver\\chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
	               
	 // Maximize the window
	 driver.manage().window().maximize();   
	 long start = System.currentTimeMillis();
	 System.out.println(start);
	 //driver.get("https://cs52.salesforce.com/0013600000U8zhv/e?retURL=%2F0013600000U8zhv&_CONFIRMATIONTOKEN=VmpFPSxNakF4TmkweE1pMHlOVlF3T1Rvek5Eb3dOaTQyTXpKYSxtaENwZW5JUTBsbUppR2RCWkpWSHRILE1qYzNNekU0&common.udd.actions.ActionsUtilORIG_URI=%2F0013600000U8zhv%2Fe");
	 driver.get("http://www.dell.com/en-us/gaming/alienware?cs=19");
	 //driver.findElement(By.id("username")).sendKeys("vennila@mstsolutions.com.fullcopy");
	 //driver.findElement(By.id("password")).sendKeys("metasoft2");
	// driver.findElement(By.id("Login")).click();


	 //WebElement ele =driver.findElement(By.id("username"));
	 
	 long finish = System.currentTimeMillis();
	 System.out.println(finish);
	 long totalTime = finish - start; 
	 double totalsec=totalTime/1000;
	 double minutes=totalsec/60;
	 System.out.println("Total Time for page load in ms - "+totalTime); 
	 System.out.println("Total Time for page load in sec- "+totalsec); 

	 System.out.println("Total Time for page load in min- "+minutes); 
	 if(totalsec>1){
		 Thread.sleep(2000);
	 }
	 }

    }          
		