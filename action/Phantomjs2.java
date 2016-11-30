package action;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Phantomjs2 {
	public static void main(String[] args) throws Exception {
        File file = new File("C:/phantomjs-2.1.1-windows/bin/phantomjs.exe");				
        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
        WebDriver driver = new PhantomJSDriver();	
      driver.get("http://www.google.com");         
        WebElement element = driver.findElement(By.name("q"));	
        element.sendKeys("Guru99");					
        element.submit();         			
        System.out.println("Page title is: " + driver.getTitle());		
        driver.quit();
        
}		
}
