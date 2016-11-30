/**
 * 
 */
package screenshot;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import constant.Constant;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

/**
 * @author MSTEMP187
 *
 */
public class Screen {

	public static void screenshot(WebDriver screenDriver, String testCaseSheet_testCaseID, ExtentTest logger) throws IOException{
		try{
			File file  = ((TakesScreenshot)screenDriver).getScreenshotAs(OutputType.FILE);
			File dir = new File(Constant.screenshotPath+testCaseSheet_testCaseID);
			dir.mkdirs();
						
			String fileName= Constant.screenshotPath+testCaseSheet_testCaseID+"/"+testCaseSheet_testCaseID+".jpg";
			FileUtils.copyFile(file, new File(fileName));
			String img = logger.addScreenCapture(fileName);
		    logger.log(LogStatus.INFO, "Image", "Attached screen shot" + img); 
		}
		catch(Exception ex){
			System.out.println("Exception while taking screen shot");
			logger.log(LogStatus.ERROR, ex.getMessage());
			throw ex;
		}
		
	}
	
	public static void fullScreenshot(WebDriver screenDriver, String testCaseSheet_testCaseID, ExtentTest logger) throws IOException{
		try{
			String fileName= Constant.screenshotPath+testCaseSheet_testCaseID+"/"+testCaseSheet_testCaseID+".png";
			
			File dir = new File(Constant.screenshotPath+testCaseSheet_testCaseID);
			dir.mkdirs();
			
			Screenshot imageScreen = new AShot()
					.shootingStrategy(new ViewportPastingStrategy(100))
					.coordsProvider(new WebDriverCoordsProvider())
					.takeScreenshot(screenDriver);
			ImageIO.write(imageScreen.getImage(), "PNG", new File(fileName));
			
			String img = logger.addScreenCapture(fileName);
		    logger.log(LogStatus.INFO, "Image", "Attached screen shot" + img); 
		}
		catch(Exception ex){
			System.out.println("Exception while taking screen shot");
			throw ex;
		}
	}
}
