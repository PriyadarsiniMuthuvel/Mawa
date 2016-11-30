package action;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import exception.CustomException;


public class ZonelTime {

	public static void DateComparison(String ElementID, String text,WebDriver driver) throws Exception{
		SimpleDateFormat gmtDateFormat = new SimpleDateFormat("MM-dd-YYYY");
		gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		String GDate = gmtDateFormat.format(new Date());
        System.out.println("Current Date and Time in GMT time zone: " + GDate);
        WebElement Ldate= driver.findElement(By.cssSelector(ElementID));
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
