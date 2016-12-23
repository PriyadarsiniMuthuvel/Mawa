package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

import org.jsoup.Jsoup;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constant.Constant;
import exception.CustomException;

public class ActionKeywords2 {
	
	public static void loginVerify(String ElementID,String data,WebDriver driver) throws Exception{
		
		try{
			
			WebElement element = driver.findElement(By.xpath(ElementID));
			
		}
		catch(NoSuchElementException c){
			throw new CustomException("Login failed due to invalid data");
		}
	}
	public static void loginVerifyCss(String ElementID,String data,WebDriver driver) throws Exception{
			
			try{
				
				WebElement element = driver.findElement(By.cssSelector(ElementID));
				
			}
			catch(NoSuchElementException c){
				throw new CustomException("Login failed due to invalid data");
			}
		}
	
	public static void linkText(String ElementID,String data,WebDriver driver){
		try{
			driver.findElement(By.linkText(ElementID)).click();
		}
		catch(NoSuchElementException c){
			throw c;
		}
	}
	public static void partial_linkText(String ElementID,String data,WebDriver driver){
		try{
			driver.findElement(By.partialLinkText(ElementID)).click();
		}
		catch(NoSuchElementException c){
			throw c;
		}
	}
	
	public static void verifyOA(String ElementID,String data,WebDriver driver) throws Exception{
		try{
			WebElement element = driver.findElement(By.xpath(ElementID));
			highLightElement(driver, element);
		}
		catch(NoSuchElementException c){
			throw new CustomException("Task creation failed due to invalid data");
			//throw new CustomException();
		}
	}

	//Drop-down box
	public static void clickOnDropdownXpath(String ElementID, String data,WebDriver driver) throws Exception{
	try{
		presenceOfElementXpath(ElementID, data, driver);
		WebElement E = driver.findElement(By.xpath(ElementID));
		Select dropdown = new Select(E);
		dropdown.selectByVisibleText(data);
		}
		catch(Exception ex){
		throw ex;
		}
	}
	//Drop-down box
		public static void clickOnDropdownCss(String ElementID, String data,WebDriver driver) throws Exception{
		try{
			presenceOfElementCss(ElementID, data, driver);
			WebElement E = driver.findElement(By.cssSelector(ElementID));
			Select dropdown = new Select(E);
			dropdown.selectByVisibleText(data);
			}
			catch(Exception ex){
			throw ex;
			}
		}
		public static void clickOnDropdownCss_Index(String ElementID, String data,WebDriver driver) throws Exception{
			try{
				int index = Integer.parseInt(data);
				presenceOfElementCss(ElementID, data, driver);
				WebElement E = driver.findElement(By.cssSelector(ElementID));
				Select dropdown = new Select(E);
				dropdown.selectByIndex(index);
				}
				catch(Exception ex){
				throw ex;
				}
			}
		public static void upload(String ElementID, String data,WebDriver driver) throws IOException{
			String path = Constant.filePath + ElementID;
			Runtime.getRuntime().exec(path);
		}
		
		
	//To clear the text in text box
	public static void clearText(String ElementID,String data,WebDriver driver) throws Exception{
	try{
		presenceOfElementID(ElementID,data,driver);
		 
		driver.findElement(By.id(ElementID)).clear();
		}
		catch(Exception ex){
		throw ex;
		}
	}

	public static void getVolunteerID(String ElementID,String data, WebDriver driver) throws InterruptedException{
		try{
			presenceOfElementCss(ElementID,data,driver);		
			WebElement element = driver.findElement(By.cssSelector(ElementID));
			String value = element.getText();
			highLightElement(driver, element);
			Constant.volunteerID=value;
		}
		catch(NoSuchElementException c){
			throw new CustomException("Error in input data");
		}
	}
	//To enter the text in text box
	public static void enterText(String ElementID,String data,WebDriver driver) throws InterruptedException{
		try{
			presenceOfElementID(ElementID,data,driver);
			WebElement element = driver.findElement(By.id(ElementID));
			element.sendKeys(data);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public static void enterTextXpath(String ElementID,String data,WebDriver driver) throws InterruptedException{
		try{
			presenceOfElementXpath(ElementID,data,driver);		
			driver.findElement(By.xpath(ElementID)).sendKeys(data);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public static void enterTextCss(String ElementID,String data,WebDriver driver) throws InterruptedException{
		try{
			presenceOfElementCss(ElementID,data,driver);		
			driver.findElement(By.cssSelector(ElementID)).sendKeys(data);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public static void enterStoredTextCss(String ElementID,String data,WebDriver driver) throws InterruptedException{
		try{
			presenceOfElementCss(ElementID,data,driver);		
			driver.findElement(By.cssSelector(ElementID)).sendKeys(Constant.volunteerID);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	
	//For clicking the button
	public static void clickOnButtonID(String ElementID, String data,WebDriver driver){
		try{
			presenceOfElementID(ElementID,data,driver);
			driver.findElement(By.id(ElementID)).click();
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public static void CSSselector_Click(String ElementID, String data,WebDriver driver){
		try{
			presenceOfElementCss(ElementID,data,driver);
			driver.findElement(By.cssSelector(ElementID)).click();
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public static void CSSselector_Click_IfAvail(String ElementID, String data,WebDriver driver){
		try{
			driver.findElement(By.cssSelector(ElementID)).click();
		}
		catch(Exception ex){
			return;
		}
	}
	
	public static void dateExecutor(String ElementID, String data,WebDriver driver){
		((JavascriptExecutor)driver).executeScript ("document.getElementById('"+ElementID+"').removeAttribute('readonly',0);");

		WebElement BirthDate= driver.findElement(By.id(ElementID));
		BirthDate.clear();
		BirthDate.sendKeys(data);
	}
	
	
	//For clicking the button
	public static void clickOnButtonXpath(String Xpath, String data, WebDriver driver){
		try{
			presenceOfElementXpath(Xpath,data,driver);
			driver.findElement(By.xpath(Xpath)).click();
		}
		catch(Exception ex){
			throw ex;
		}
	}

	//Drop-down box
	public static void clickOnDropdown(String ElementID, String data,WebDriver driver){
		try{
			presenceOfElementID(ElementID,data,driver);	
			WebElement E = driver.findElement(By.id(ElementID));
			Select dropdown = new Select(E);
			dropdown.selectByVisibleText(data);
		}
		catch(Exception ex){
			throw ex;
		}
	}
		
	//Verify the element is present or not.
	public static boolean verifyElement(String ElementID, String data,WebDriver driver){
		boolean element=false;
		try{
			if(driver.findElements(By.id(ElementID)).size() != 0){
				WebElement E = driver.findElement(By.id(ElementID));
				E.isDisplayed();
				element= true;
			}
			else{
				System.out.println("Element not found on the screen");
				element=false;
			}
		}
		catch(Exception ex){
			throw ex;
		}
		return element;
	}
	
	//Get the URL 
	public static void getURL(String ElementID, String data, WebDriver driver){
		try{
			driver.manage().window().maximize();
			driver.get(data);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public static void storeURL(String ElementID, String data, WebDriver driver){
		Constant.tempUrl = driver.getCurrentUrl();
	}
	public static void getStoredURL(String ElementID, String data, WebDriver driver){
		try{
			driver.manage().window().maximize();
			driver.get(Constant.tempUrl);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.navigate().refresh();
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	
	//Wait until the element is located.
	public static void presenceOfElementID(String ElementID, String data, WebDriver driver)
	{
		try{
			WebElement E = (new WebDriverWait(driver, 15))
					  .until(ExpectedConditions.presenceOfElementLocated(By.id(ElementID)));
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public static void presenceOfElementXpath(String xpath,String data,WebDriver driver)
	{
		try{
			WebElement E = (new WebDriverWait(driver, 30))
					  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public static void presenceOfElementCss(String css,String data,WebDriver driver)
	{
		try{
			WebElement E = (new WebDriverWait(driver, 30))
					  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
		}
		catch(Exception ex){
			throw new CustomException(css + "- Element is not available");
		}
	}
	public static void app(String ElementID, String text,WebDriver driver){
		try{
			WebElement table = driver.findElement(By.xpath(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("li"));
			int rows_count = rows_table.size();
			boolean test = false;
			String relationValue = null; 
			for(int row=0; row<rows_count; row++){
				
				relationValue = rows_table.get(row).getText();
				String[] output ;
				output = text.split("\\|");
				int count = output.length;
				
				for(int i=0;i<count;i++){
						
					if(output[i].equals(relationValue)){
						System.out.println("Value matches");
						test = true;
					}
					else{
						test = false;
					}
					
				}
			}
			if(test==false){
				throw new CustomException("");
			}
		}
		catch(NoSuchElementException c){
			throw c;
		}
	}
	public static void verify_tablerowCount(String ElementID, String text,WebDriver driver){
		try{
			WebElement table = driver.findElement(By.cssSelector(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			int excel_count = Integer.parseInt(text);
			
			if((rows_count!=excel_count)){
				throw new CustomException("The rows count in the related list is not matched with the excel.");
			}
		}
		catch(NoSuchElementException c){
			throw c;
		}
	}
	
	public static void register_table(String ElementID, String text,WebDriver driver){
		try{
			WebElement table = driver.findElement(By.cssSelector(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			boolean test = false;
			String relationValue=null; 
			for(int row=1; row<=rows_count; row++){
				
				List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
				relationValue = col_table.get(0).getText();
					
				if(text.equals(relationValue)){
					
					String value = col_table.get(9).findElement(By.tagName("a")).getText();
					if(value.equals("Register")){
						col_table.get(9).findElement(By.tagName("a")).click();
						test = true;
						break;
					}
				}
			}
			
			if(test==false){
				throw new CustomException("The given value "+text+" is not matched with the data ");
			}
		}
		catch(NoSuchElementException c){
			throw c;
		}
	}
	public static void VerifyRegister_table(String ElementID, String text,WebDriver driver){
		try{
			WebElement table = driver.findElement(By.cssSelector(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			boolean test = true;
			String relationValue=null; 
			for(int row=1; row<rows_count; row++){
				
				List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
				relationValue = col_table.get(0).getText();
					
				if(text.equals(relationValue)){
					test = false;
				}
			}
			
			if(test==false){
				throw new CustomException("The given training "+text+" should not be displayed.");
			}
		}
		catch(NoSuchElementException c){
			throw c;
		}
	}
	
	
	public static boolean cancel_table(String ElementID, String text,WebDriver driver){
		try{
			WebElement table = driver.findElement(By.cssSelector(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			boolean test = false;
			String relationValue=null; 
			for(int row=1; row<=rows_count; row++){
				
				List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
				relationValue = col_table.get(0).getText();
					
				if(text.equals(relationValue)){
					
					String value = col_table.get(9).findElement(By.tagName("a")).getText();
					if(value.equals("Cancel")){
						col_table.get(9).findElement(By.tagName("a")).click();
						test = true;
						break;
					}
				}
			}
			
			if(test==false){
				throw new CustomException("The given value "+text+" is not matched with the fetched data " +relationValue);
			}
		}
		catch(NoSuchElementException c){
			throw c;
		}
		return false;
	}
	
	public static boolean click_SFContacts(String ElementID, String text,WebDriver driver){
		try{
			WebElement table = driver.findElement(By.xpath(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			boolean test = false;
			String relationValue=null; 
			for(int row=1; row<=rows_count; row++){
				
				WebElement col_table = rows_table.get(row).findElement(By.tagName("th"));
				
				relationValue = col_table.getText();
				if(text.equals(relationValue)){
					WebElement anchor = col_table.findElement(By.tagName("a"));
					anchor.click();
					test = true;
					break;
					}
				}
			
			if(test==false){
				throw new CustomException("The given contact value "+text+" is not matched with the fetched data " +relationValue);
			}
		}
		
		catch(NoSuchElementException c){
			throw c;
		}
		return false;
	}
	
	
	public static boolean click_VolunteerID(String ElementID, String text,WebDriver driver){
		try{
			WebElement table = driver.findElement(By.cssSelector(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			boolean test = false;
			String relationValue=null; 
			for(int row=1; row<=rows_count; row++){
				
				WebElement col_table = rows_table.get(row).findElement(By.tagName("th"));
				
				relationValue = col_table.getText();
				if((Constant.volunteerID).equals(relationValue)){
					WebElement anchor = col_table.findElement(By.tagName("a"));
					anchor.click();
					test = true;
					break;
					}
				}
			
			if(test==false){
				throw new CustomException("The given value is not matched with the fetched data " +relationValue);
			}
		}
		
		catch(NoSuchElementException c){
			throw c;
		}
		return false;
	}
	
	public static boolean choose_Volunteer(String ElementID, String text,WebDriver driver){
		try{
			
			WebElement table = driver.findElement(By.xpath(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			boolean test = false;
			String relationValue=null; 
			for(int row=1; row<=rows_count; row++){
				
				WebElement col_table = rows_table.get(row).findElement(By.tagName("th"));
				
				relationValue = col_table.getText();
				if(Constant.volunteerID.equals(relationValue)){
					WebElement anchor = col_table.findElement(By.tagName("a"));
					anchor.click();
					test = true;
					break;
					}
				}
			
			if(test==false){
				throw new CustomException("The given value "+Constant.volunteerID+" is not matched with the fetched data " +relationValue);
			}
		}
		
		catch(NoSuchElementException c){
			throw c;
		}
		return false;
	}
	public static void MouseHover(String ElementID, String text,WebDriver driver) throws Exception{
		String[] Element=ElementID.split("\\|");
		String[] texts=text.split("\\|");
		String Element1=Element[0];
		String Element2=Element[1];
		int textCount = texts.length;
		WebElement E = (new WebDriverWait(driver, 15))
				  .until(ExpectedConditions.presenceOfElementLocated(By.linkText(Element1)));
		Actions action = new Actions(driver);
		 action.moveToElement(E).clickAndHold().perform();
		 Thread.sleep(3000);
		 if(driver.findElement(By.cssSelector(Element2)).isDisplayed()){
			 String toolTipText = driver.findElement(By.cssSelector(Element2)).getText();
			 for(int i=0;i<textCount;i++){
				 String splitedText = texts[i];
				 if(!toolTipText.contains(splitedText)){
						throw new CustomException("The ToolTip Text is not matched!");
				 }
			 }
				
		}
		else{
			throw new CustomException("The ToolTip Text is not displayed!");
			} 
		 }
		
	public static boolean clickOpenActivity(String ElementID, String text,WebDriver driver){
		try{
			WebElement table = driver.findElement(By.xpath(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			boolean test = false;
			String relationValue=null; 
			for(int row=1; row<=rows_count; row++){
				
				List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
				relationValue = col_table.get(0).getText();
					
				if(text.equals(relationValue)){
					col_table.get(0).findElement(By.tagName("a")).click();
					test = true;
					break;
				}
			}
			
			if(test==false){
				throw new CustomException("The given value "+text+" is not matched with the fetched data " +relationValue);
			}
			}
		catch(NoSuchElementException c){
			throw c;
		}
		return true;
	}

	//click the Orientation record in the recent list items
	public static boolean click_SFOrientationListviewtable(String ElementID, String text,WebDriver driver){
				try{
					WebElement table = driver.findElement(By.cssSelector(ElementID));
					
					List<WebElement> rows_table = table.findElements(By.tagName("tr"));
					int rows_count = rows_table.size();
					boolean test = false;
					String relationValue=null;
					for(int row=1; row<=rows_count; row++){
						
						relationValue = rows_table.get(row).getText();
						
						if(text.equals(relationValue)){
							test = true;
							rows_table.get(row).findElement(By.tagName("a")).click();
							return true;
						}
					}
					if(test==false){
	                    throw new CustomException("The given orientation value "+text+" is not matched with the fetched data " +relationValue);
	              }
				}
				
				catch(NoSuchElementException c){
					throw c;
				}
				return false;
			}

	public static boolean click_SFRelatedListtable(String ElementID, String text,WebDriver driver){
	try{
		WebElement table = driver.findElement(By.cssSelector(ElementID));
		
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		boolean test = false;
		String relationValue=null;
		for(int row=1; row<=rows_count; row++){
			List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
			int col_count = col_table.size();
			
			for(int col=0; col<col_count;col++){
				relationValue = col_table.get(col).getText();
				if(text.equals(relationValue)){
					WebElement head_table= rows_table.get(row).findElement(By.tagName("th"));
					WebElement link= head_table.findElement(By.tagName("a"));
					link.click();
					test = true;
					return true;
					}
				}
			}
			if(test==false){
                throw new CustomException("The value given in excel "+text+" is not matched with the fetched data " +relationValue);
          }
			
			}
		catch(NoSuchElementException c){
			throw c;
		}
		return false;
	}

	public static boolean verifyBG_Duration(String ElementID,String data,WebDriver driver){
	try{
		String duration = driver.findElement(By.cssSelector(ElementID)).getText();
		if(duration.equals(data))
		return true;
		else
		throw new CustomException("'Are you residing in US for past 7 years?' field value in SF(" + duration + ") is not matched with the value in Portal(" + data + ").");
	}
	catch(NoSuchElementException c){
			throw new CustomException("Issue in 'Are you residing in US for past 7 years?' field.");
		}
	}
	
	public static boolean verifyRegisterAvailableSeatCount(String ElementID, String text,WebDriver driver){
	try{
            WebElement table = driver.findElement(By.cssSelector(ElementID));
           
            List<WebElement> rows_table = table.findElements(By.tagName("tr"));
            int rows_count = rows_table.size();
            boolean test = false;
            String relationValue=null;
            for(int row=1; row<=rows_count; row++){
                 
                  List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
                  relationValue = col_table.get(0).getText();
                        
                  if(text.equals(relationValue)){
                        
                         int Expected_AvailableSeat = Integer.parseInt(col_table.get(6).getText())-1;
                         int Actual_AvailableSeat = Integer.parseInt(col_table.get(7).getText());
                         if(Expected_AvailableSeat == Actual_AvailableSeat){
                                test = true;
                                break;
                         }
                  }
            }
	           
            if(test==false){
                  throw new CustomException("Available Seat value is not calculated as expected.");
            }
	     }
	     catch(NoSuchElementException c){
	            throw c;
	     }
	     return false;
	}
	
	public static boolean verifyCancelAvailableSeatCount(String ElementID, String text,WebDriver driver){
	try{
	            WebElement table = driver.findElement(By.cssSelector(ElementID));
	           
	            List<WebElement> rows_table = table.findElements(By.tagName("tr"));
	            int rows_count = rows_table.size();
	            boolean test = false;
	            String relationValue=null;
	            for(int row=1; row<=rows_count; row++){
	                 
                  List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
                  relationValue = col_table.get(0).getText();
	                        
                  if(text.equals(relationValue)){
                        
                     int Expected_AvailableSeat = Integer.parseInt(col_table.get(6).getText());
                     int Actual_AvailableSeat = Integer.parseInt(col_table.get(7).getText());
                     if(Expected_AvailableSeat == Actual_AvailableSeat){
                        test = true;
                        break;
                     }
                  }
	            }
	           
            if(test==false){
                  throw new CustomException("Available Seat value is not calculated as expected.");
            }
	     }
	     catch(NoSuchElementException c){
	            throw c;
	     }
	     return false;
	}
	public static boolean verifyNoVolunteerWish(String ElementID, String text,WebDriver driver){
		try{
	            WebElement table = driver.findElement(By.cssSelector(ElementID));
	           
	            List<WebElement> rows_table = table.findElements(By.tagName("tr"));
	            int rows_count = rows_table.size();
	            boolean test = true;
	            String relationValue=null;
	            for(int row=1; row<rows_count; row++){
	                 
	                  List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
	                  relationValue = col_table.get(2).getText();
	                        
	                  if(text.equals(relationValue)){
	                        test = false;
	                        break;
	                        }
	                  }
	        
	            if(test==false){
	                  throw new CustomException("Volunteer Wish should not be displayed in portal.");
	            }
		     }
		     catch(NoSuchElementException c){
		            throw c;
		     }
		     return false;
		}
	public static boolean verifyVolunteerNeededCount(String ElementID, String text,WebDriver driver){
		try{
	            WebElement table = driver.findElement(By.cssSelector(ElementID));
	           
	            List<WebElement> rows_table = table.findElements(By.tagName("tr"));
	            int rows_count = rows_table.size();
	            boolean test = false;
	            String relationValue=null;
	            for(int row=1; row<rows_count; row++){
	                 
	                  List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
	                  relationValue = col_table.get(2).getText();
	                        
	                  if(text.equals(relationValue)){
	                        
	                         int Expected_VolunteerNeeded = 2;
	                         int Actual_VolunteerNeeded = Integer.parseInt(col_table.get(11).getText());
	                         if(Expected_VolunteerNeeded == Actual_VolunteerNeeded){
	                                test = true;
	                                return true;
	                         }
	                  }
	            }
		           
	            if(test==false){
	                  throw new CustomException("Volunteer Needed value is not calculated as expected.");
	            }
		     }
		     catch(NoSuchElementException c){
		            throw c;
		     }
		     return false;
		}
	public static boolean verifyApplication(String ElementID,String data,WebDriver driver) throws Exception{
		try{
			
			WebElement element = driver.findElement(By.xpath(ElementID));
			String portaldata = element.getText();
			
			if(portaldata.equals(data)){
				highLightElement(driver, element);
				return true;
			}
			else
				//return true;
				throw new CustomException("The value "+portaldata+"is not matched with the excel value "+data);
			}
		catch(NoSuchElementException c){
			//return true;
			throw c;
		}
	}
	public static boolean verifyApplication_Css(String ElementID,String data,WebDriver driver) throws Exception{
		try{
			
			WebElement element = driver.findElement(By.cssSelector(ElementID));
			String portaldata = element.getText();
			
			if(portaldata.equals(data)){
				highLightElement(driver, element);
				return true;
			}
			else
				//return true;
			throw new CustomException("The value "+portaldata+"is not matched with the excel value "+data);
			}
		catch(NoSuchElementException c){
			//return true;
			throw c;
		}
	}
	public static boolean verifyStyle_Css(String ElementID,String data,WebDriver driver) throws Exception{
		try{
			
			WebElement element = driver.findElement(By.cssSelector(ElementID));
			String portaldata = element.getCssValue("border-top-color");
			
			if(portaldata.equals(data)){
				highLightElement(driver, element);
				return true;
			}
			else
				
			throw new CustomException("The style "+portaldata+"is not matched with the excel value "+data);
			}
		catch(NoSuchElementException c){
			throw c;
		}
	}
	public static boolean verifyText_ID(String ElementID,String data,WebDriver driver) throws Exception{
		try{
			
			WebElement element = driver.findElement(By.id(ElementID));
			String portaldata = element.getAttribute("value");
			
			if(portaldata.equals(data)){
				highLightElement(driver, element);
				return true;
			}
			else
				//return true;
			throw new CustomException("The value "+portaldata+" is not matched with the excel value "+data);
			}
		catch(NoSuchElementException c){
			//return true;
			throw c;
		}
	}
	public static boolean verifyText_Css(String ElementID,String data,WebDriver driver) throws Exception{
		try{
			
			WebElement element = driver.findElement(By.cssSelector(ElementID));
			String portaldata = element.getAttribute("value");
			
			if(portaldata.equals(data)){
				highLightElement(driver, element);
				return true;
			}
			else
			throw new CustomException("The value "+portaldata+" is not matched with the excel value "+data);
			}
		catch(NoSuchElementException c){
			//return true;
			throw c;
		}
	}
	public static void verifyNoTraining_Css(String ElementID, String data, WebDriver driver) throws Exception{
		try{
			if(driver.findElement(By.cssSelector(ElementID)).isDisplayed()){
				if(data.equals(driver.findElement(By.cssSelector(ElementID)).getText()))
				throw new CustomException(data + "-Training should not be displayed.");
			}
			
		}
		catch(CustomException ex){
			throw ex;
		}
		catch(NoSuchElementException ex){
			
		}
	}
	public static void verifyNoOther(String ElementID, String data, WebDriver driver) throws Exception{
		try{
			if(driver.findElement(By.id(ElementID)).isDisplayed()){
				throw new CustomException(ElementID + "-Element should not be displayed.");
			}
			
		}
		catch(CustomException ex){
			throw ex;
		}
		catch(NoSuchElementException ex){
			
		}
	}

	public static void verifyNoOther_Css(String ElementID, String data, WebDriver driver) throws Exception{
		try{
			if(driver.findElement(By.cssSelector(ElementID)).isDisplayed()){
				throw new CustomException(ElementID + "-Element should not be displayed.");
			}
			
		}
		catch(CustomException ex){
			throw ex;
		}
		catch(NoSuchElementException ex){
			
		}
	}
	
	public static boolean verifyOther(String ElementID, String data,WebDriver driver) throws Exception{
		try{
			if(driver.findElement(By.id(ElementID)).isDisplayed()){
				return true;
			}
			else{
				throw new CustomException(ElementID + "-Element is not getting displayed.");
			}
		}
		catch(Exception ex){
			throw new CustomException(ElementID + "-Element is not getting displayed.");
		}
	}
	public static boolean verifyOther_Css(String ElementID, String data,WebDriver driver) throws Exception{
		try{
			if(driver.findElement(By.cssSelector(ElementID)).isDisplayed()){
				return true;
			}
			else{
				throw new CustomException(ElementID + "-Element is not getting displayed.");
			}
		}
		catch(Exception ex){
			throw new CustomException(ElementID + "-Element is not getting displayed.");
		}
	}
		
	//Verify Drop-down box
	public static boolean verifyDropdown(String ElementID, String data,WebDriver driver) throws Exception{
		try{
			String value = driver.findElement(By.id(ElementID)).getText();
			if(value.equals(data)){
				return true;
			}
			else{
				throw new CustomException(value + "-is not matched with the excel value.");
			}
		}
		
		catch(Exception ex){
			throw ex;
		}
	}
	
	public static boolean verifyDropdown_Css(String ElementID, String data,WebDriver driver) throws Exception{
		try{
			WebElement E = driver.findElement(By.cssSelector(ElementID));
			Select dropdown = new Select(E);
			String value = dropdown.getFirstSelectedOption().getText();
			if(value.equals(data)){
				highLightElement(driver, E);
				return true;
			}
			else{
				throw new CustomException("The value " + value + "in the dropdown-" + ElementID + ",is not matched with the excel value.");
			}
		}
		
		catch(Exception ex){
			throw ex;
		}
	}
	
	public static void clickOnDropdownvalue(String ElementID, String data,WebDriver driver) throws Exception{
	try{
		WebElement E = driver.findElement(By.id(ElementID));
		Select dropdown = new Select(E);
		dropdown.selectByValue(data);
		}
		catch(Exception ex){
		throw ex;
		}
	}
	//switch to frames 
	public static void switchToFrame(String ElementID, String data, WebDriver driver) throws Exception{
			try{
				driver.switchTo().frame(ElementID);
			}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public static boolean clickNonWishRegister(String ElementID, String text,WebDriver driver){
	try{
		String[] metadata ;
		metadata = text.split("\\|");
 		
 		String role=metadata[0];
		String name =metadata[1];
		
		WebElement table = driver.findElement(By.cssSelector(ElementID));
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		boolean test = false;
		String relationrole,relationname=null;
		//if(rows_count>1){
		for(int row=1; row<=rows_count; row++){
		List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
		relationname = col_table.get(7).getText();
		relationrole = col_table.get(2).getText();
			if(role.equals(relationrole) && name.equals(relationname)){
			col_table.get(0).findElement(By.tagName("a")).click();
			test = true;
			break;
			}
		}
		if(test==false){
			throw new CustomException("The given value "+text+" is not matched with the fetched data.");
		}
	}
	catch(NoSuchElementException c){
		throw c;
	}
	return true;
	}
	
	public static void clickNonWishAssignment(String ElementID, String text,WebDriver driver){
	try{
		WebElement table = driver.findElement(By.cssSelector(ElementID));
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		boolean test = false;
		String relationValue=null; 
			for(int row=1; row<=rows_count; row++){
			List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
			relationValue = col_table.get(6).getText();
				if(text.equals(relationValue)){
					col_table.get(0).findElement(By.tagName("a")).click();
					test = true;
					break;
				}
			}
			if(test==false){
			throw new CustomException("The given value "+text+" is not matched with the fetched data " +relationValue);
			}
		}
		catch(NoSuchElementException c){
			throw c;
		}
	}
	
	public static void checkNonWishAssignment(String ElementID, String text,WebDriver driver){
		try{
		WebElement table = driver.findElement(By.cssSelector(ElementID));
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		boolean test = false;
		String relationValue=null; 
			for(int row=1; row<rows_count; row++){
				List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
				relationValue = col_table.get(7).getText();
				if(text.equals(relationValue)){
					test = true;
				}
			}
			if(test==true){
				throw new CustomException("The given assigment value "+text+" is matched with the fetched data " +relationValue);
			}
		}
		catch(NoSuchElementException c){
			throw c;
		}
	}

	public static boolean checkNonWishRegister(String ElementID, String text,WebDriver driver){

	try{

		WebElement table = driver.findElement(By.cssSelector(ElementID));
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		boolean test = false;
		String relationValue=null;
			for(int row=1; row<rows_count; row++){
				List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
				relationValue = col_table.get(7).getText();
				if(text.equals(relationValue)){
				test = true;
				break;
				}
			}
			if(test==false){
				throw new CustomException("The given value "+text+" is not matched with the fetched data " +relationValue);
			}
		}
		catch(NoSuchElementException c){
			throw c;
		}
		return true;
	}

	
	public static boolean verifySignedDate(String ElementID, String data,WebDriver driver) throws Exception{
		try{
			String value = driver.findElement(By.id(ElementID)).getText();
			if(value.contains(data)){
				return true;
			}
			else{
				throw new CustomException("The signed/Expiration date " + value + "is not matched with the excel value.");
			}
		}
		catch(Exception ex){
			throw ex;
		}
	}

	public static boolean clickWishRegister(String ElementID, String text,WebDriver driver){
		try{
			String[] metadata ;
			metadata = text.split("\\|");
	 		
	 		String role=metadata[0];
			String name =metadata[1];
			
			
			WebElement table = driver.findElement(By.cssSelector(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			boolean test = false;
			String relationrole, relationname=null;
			
			//if(rows_count>1){
				for(int row=1; row<=rows_count; row++){
					
					List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
					relationrole = col_table.get(1).getText();
					relationname = col_table.get(2).getText();
						
					if(role.equals(relationrole) && name.equals(relationname)){
						col_table.get(0).findElement(By.tagName("a")).click();
						test = true;
						break;
					}
				}
			
			if(test==false){
				throw new CustomException("The given value "+text+" is not matched with the fetched data");
			}
			}
		catch(NoSuchElementException c){
			throw c;
		}
		return true;
	}
	
	public static void clickAssignment(String ElementID, String text,WebDriver driver){
		try{
			WebElement table = driver.findElement(By.cssSelector(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			boolean test = false;
			String relationValue=null; 
			for(int row=1; row<=rows_count; row++){
				
				List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
				relationValue = col_table.get(2).getText();
					
				if(text.equals(relationValue)){
					col_table.get(0).findElement(By.tagName("a")).click();
					test = true;
					break;
				}
			}
			
			if(test==false){
				throw new CustomException("The given value "+text+" is not matched with the fetched data " +relationValue);
			}
		}
		catch(NoSuchElementException c){
			throw c;
		}
	}
	
	public static void checkAssignment(String ElementID, String text,WebDriver driver){
		try{
			WebElement table = driver.findElement(By.cssSelector(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			boolean test = false;
			String relationValue=null; 
			for(int row=1; row<rows_count; row++){
				
				List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
				relationValue = col_table.get(2).getText();
					
				if(text.equals(relationValue)){
					test = true;
				}
			}
			
			if(test==true){
				throw new CustomException("The given assigment value "+text+" is matched with the fetched data " +relationValue);
			}
		}
		catch(NoSuchElementException c){
			throw c;
		}
	}
	
	public static boolean checkWishRegister(String ElementID, String text,WebDriver driver){
		try{
			WebElement table = driver.findElement(By.cssSelector(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			boolean test = false;
			String relationValue=null;
			
			for(int row=1; row<rows_count; row++){
					
				List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
				relationValue = col_table.get(2).getText();
				
					
				if(text.equals(relationValue)){
					test = true;
					break;
				}
			}
			
			if(test==false){
				throw new CustomException("The given value "+text+" is not matched with the fetched data " +relationValue);
			}
		}
		catch(NoSuchElementException c){
			throw c;
		}
		return true;
	}
	
	public static boolean clickEvent(String ElementID, String text,WebDriver driver){
	try{
		WebElement table = driver.findElement(By.xpath(ElementID));
		List<WebElement> events_table = table.findElements(By.tagName("li"));
		int event_count = events_table.size();
		boolean test = false;
		String relationValue=null;
		for(int row=0; row<event_count; row++){
			WebElement heading = events_table.get(row).findElement(By.tagName("a"));
			relationValue = heading.getText();
			if(text.equals(relationValue)){
				heading.click();
				test = true;
				break;
			}
		}
		if(test==false){
			throw new CustomException("The given event "+text+" is not matched with the fetched data " +relationValue);
		}
	}
	catch(NoSuchElementException c){
		throw c;
	}
	return true;
	}
	
	public static void switchToWindow(String ElementID, String data, WebDriver driver) throws Exception{
		try{
			driver.switchTo().defaultContent();
		}
		catch(Exception ex){
			throw ex;
		}
	}
		

	public static void chapterName(String ElementID, String data,WebDriver driver) throws Exception{
		try{
			boolean chapter = false;
			String[] metadata ;
			metadata = ElementID.split("\\|");
	 		
	 		String chapterClick=metadata[0];
			String table_xpath =metadata[1];
			String resultFrame = metadata[2];
			String Parent_Window = driver.getWindowHandle();
			
			driver.findElement(By.cssSelector(chapterClick)).click();
			
		    // Switching from parent window to child window   
		     for (String Child_Window : driver.getWindowHandles()){
		    	
		    	if(!Parent_Window.equals(Child_Window)){
				driver.switchTo().window(Child_Window);  
				
				// Performing actions on child window  
				driver.switchTo().frame(resultFrame);
				
				WebElement table = driver.findElement(By.cssSelector(table_xpath));
				List<WebElement> rows_table = table.findElements(By.tagName("tr"));
				int rows_count = rows_table.size();
				for(int row=1; row<rows_count; row++){
				
				WebElement col_table = rows_table.get(row).findElement(By.tagName("th"));
				String relationValue=null; 
				relationValue = col_table.getText();
					if(data.equals(relationValue)){
						WebElement anchor = col_table.findElement(By.tagName("a"));
						anchor.click();
						chapter = true;
						break;
						}
					}
			    }
		     } 
		     //Switching back to Parent Window  
		    driver.switchTo().window(Parent_Window);
		    if(chapter==false){
				throw new CustomException("The searched chapter name is matched with the given data");
			}
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public static void getTabURL(String ElementID, String data, WebDriver driver) throws Exception{
		//Thread.sleep(1000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1)); 
        String url = driver.getCurrentUrl();
        if(url.equalsIgnoreCase(data)){
        	driver.close();
        	driver.switchTo().window(tabs.get(0));
        }
        else{
        	throw new CustomException("View Orientation/Training LMS portal URL not matching.");
		}
	} 
	public static void CustomLinks_Newwindow(String ElementID, String data,WebDriver driver) throws Exception{
		try{
			String Parent_Window = driver.getWindowHandle();
			driver.findElement(By.cssSelector(ElementID)).click();
			    
		    for (String Child_Window : driver.getWindowHandles()){
		    	
		    	if(!Parent_Window.equals(Child_Window)){
				driver.switchTo().window(Child_Window);
				String url = driver.getCurrentUrl();
				if(url.startsWith(data)){
					driver.close();
		        	driver.switchTo().window(Parent_Window);
		        }
				else
					throw new CustomException("Custom Link is not working as expected.");
				
		    	}
		    }
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public static boolean isAlertPresent(WebDriver driver){
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e){
			return false;
		}
	}
	public static boolean View_LMS(String ElementID, String text,WebDriver driver){
	try{
		WebElement table = driver.findElement(By.xpath(ElementID));
		
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		boolean test = false;
		String relationValue=null; 
		for(int row=0; row<=rows_count; row++){
			
			List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
			relationValue = col_table.get(0).getText();
				
			if(text.equals(relationValue)){
				
				col_table.get(10).findElement(By.tagName("a")).click();
					test = true;
					break;
				
			}
		}
		
		if(test==false){
			throw new CustomException("The given value "+text+" is not matched with the fetched data " +relationValue);
		}
		}
		catch(NoSuchElementException c){
		throw c;
		}
		return false;
	}
	public static void Verify_LMS(String ElementID, String text,WebDriver driver){
			WebElement table = driver.findElement(By.xpath(ElementID));
			
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			String relationValue=null; 
			for(int row=1; row<rows_count; row++){
				
				List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
				relationValue = col_table.get(0).getText();
				try{	
					if(text.equals(relationValue)){
						String lms = col_table.get(10).findElement(By.tagName("a")).getText();
						if(lms.contains("View")){
							throw new CustomException("View LMS link should not be displayed for "+text);
						}
					}		
				}
				catch(NoSuchElementException c){
			
				}
			}
		}
		
	public static void selectUser(String ElementID, String text,WebDriver driver){
		try{
		WebElement table = driver.findElement(By.xpath(ElementID));
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		boolean test = false;
		String relationValue=null; 
			for(int row=1; row<rows_count; row++){
				List<WebElement> col_table = rows_table.get(row).findElements(By.tagName("td"));
				relationValue = col_table.get(2).getText();
				if(text.equals(relationValue)){
					col_table.get(2).findElement(By.tagName("a")).click();
					test = true;
					break;
				}
			}
			if(test==false){
				throw new CustomException("The given user value "+text+" is not matched with the fetched data " +relationValue);
			}
		}
		catch(NoSuchElementException c){
			throw c;
		}
	}
	
	public static void checkboxChecked(String ElementID, String text,WebDriver driver) throws Exception{

		boolean checkStatus;
		WebElement elem = driver.findElement(By.xpath(ElementID));
		checkStatus=elem.isSelected();
		
		if(checkStatus == false){
			elem.click();
		}
	} 
	
	public static void radioboxVerify(String ElementID, String text,WebDriver driver) throws Exception{

		boolean checkStatus,excelStatus;
		WebElement elem = driver.findElement(By.cssSelector(ElementID));
		checkStatus=elem.isSelected();
		excelStatus = Boolean.valueOf(text);
		if(checkStatus == excelStatus){
			highLightElement(driver, elem);
			return;
		}
		else{
			throw new CustomException("The status of radio button is not matched with excel sheet");
		}
	} 
	
	public static void checkboxUnchecked(String ElementID, String text,WebDriver driver) throws Exception{

		boolean checkStatus;
		WebElement elem = driver.findElement(By.xpath(ElementID));
		checkStatus=elem.isSelected();
		
		if(checkStatus == true){
			elem.click();
		}
	} 
	
	public static void alertAccept(String ElementID, String text,WebDriver driver) throws Exception{
		Thread.sleep(1000);
		Alert confirmationAlert = driver.switchTo().alert();
		text = confirmationAlert.getText();
		//System.out.println("Alert text is " + text);
		confirmationAlert.accept();
	} 
	//to clear the text and update the text

	public static void alterTextCss(String ElementID,String data,WebDriver driver) throws InterruptedException{
			try{
				presenceOfElementCss(ElementID,data,driver);		
				WebElement element=driver.findElement(By.cssSelector(ElementID));
				element.clear();
				element.sendKeys(data);
			}
			catch(Exception ex){
				throw ex;
			}
		}

	//to click the alert button

	public static void CSSselector_Clickalert(String ElementID, String data,WebDriver driver){
			try{
				presenceOfElementCss(ElementID,data,driver);
				driver.findElement(By.cssSelector(ElementID)).click();
				 WebDriverWait wait = new WebDriverWait(driver, 15, 100);
						    wait.until(ExpectedConditions.alertIsPresent());
				Alert alert=driver.switchTo().alert();
				alert.accept();
			}
			catch(Exception ex){
				throw ex;
			}
		}

	// for adding more time(application)
	public static void CSSselector_Click_wait(String ElementID, String data,WebDriver driver){
			try{
				presenceOfElementCss_wait(ElementID,data,driver);
				driver.findElement(By.cssSelector(ElementID)).click();
			}
			catch(Exception ex){
				throw ex;
			}
		}
		public static void Click_Xpath_wait(String ElementID, String data,WebDriver driver){
			try{
				presenceOfElementXpath_wait(ElementID,data,driver);
				WebElement element=driver.findElement(By.xpath(ElementID));
				element.click();
			}
			catch(Exception ex){
				throw ex;
			}
		}
	//

	public static void presenceOfElementCss_wait(String css,String data,WebDriver driver)
		{
			try{
				WebElement E = (new WebDriverWait(driver, 2500))
						  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
			}
			catch(Exception ex){
				throw new CustomException(css + "- Element is not available");
			}
		}
		public static void presenceOfElementXpath_wait(String css,String data,WebDriver driver)
		{
			try{
				WebElement E = (new WebDriverWait(driver, 2500))
						  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(css)));
			}
			catch(Exception ex){
				throw new CustomException(css + "- Element is not available");
			}
		}
		public static void alertVerify(String ElementID, String text,WebDriver driver) throws Exception{

			Alert confirmationAlert = driver.switchTo().alert();
			 String data= confirmationAlert.getText();
			//System.out.println("Alert text is " + text);
			if(data.equals(text)){
				System.out.println("Alert Text Verified");
			}
			else{
				throw new CustomException("The Alert Text is not matched!");
			}
		}  

	public static void EmailVerify(String ElementID, String text,WebDriver driver) throws InterruptedException, MessagingException, Exception {

		try{
			Thread.sleep(15000);
			
			String from=null, subject=null, content = null,
					from_email = null, subject_email=null,content_email=null;
			
			String[] emailVerify ;
			emailVerify = text.split("\\|");
	 		
	 		from=emailVerify[0];
			subject=emailVerify[1];
			content=emailVerify[2];
			Properties props = new Properties();
			props.setProperty("mail.store.protocol", "imaps");
			
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect(Constant.hostname, Constant.username, Constant.password);
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_WRITE);
			
			int count = inbox.getUnreadMessageCount();
			
			if(count >0){
		    	
				int totalCount = inbox.getMessageCount();
				
				for(int i=0; i<count;i++){
					
					int countEmail = totalCount-i;
					Message msg = inbox.getMessage(countEmail);
					msg.setFlag(Flags.Flag.SEEN, true);
					Address[] in = msg.getFrom();
					
					for(Address address :in){			
						from_email= address.toString();
						subject_email = msg.getSubject();
					}
					
					Object output = msg.getContent();
					if (output instanceof String)  
					{  
					    String body = (String)content;  
					    content_email = body.toString();
					}  
					else if (output instanceof Multipart) {  
					    Multipart mp = (Multipart)output;
					    BodyPart bp = mp.getBodyPart(0);
					    content_email = bp.getContent().toString();
					    System.out.println(content_email);
					}
					 String parsed_content = Jsoup.parse(content_email).text();
					 if(from.equals(from_email)){
				    				    	 
				    	 if(subject_email.contains(subject)){
				    	 
				    		 if (parsed_content.contains(content)){
				    			 System.out.println("Email verified");
				    			 i = count;
				     			}
				    		 	else{
				    		 		throw new CustomException("The given content value in excel is not matched with the fetched data ");
				    		 		}
				     		}
				    	 else{
				    		 throw new CustomException("The given subject value in excel  is not matched with the fetched data ");
				    	 }
				     }
				     else{
				    	 throw new CustomException("The given From value in excel is not matched with the fetched data ");
				     }
				}
			}
			else {
		    	 throw new CustomException("The mail is not received to the email address");
		     }
		}
		catch(Exception ex){
			throw ex;
		}
    }
	public static void GmailVerify(String ElementID, String text,WebDriver driver) throws InterruptedException, MessagingException, Exception {

		try{
			Thread.sleep(15000);
			
			String from=null, subject=null, content = null,
					from_email = null, subject_email=null,content_email=null;
			boolean bool = false;
			String[] emailVerify ;
			emailVerify = text.split("\\|");
	 		
	 		from=emailVerify[0];
			subject=emailVerify[1];
			content=emailVerify[2];
			Properties props = new Properties();
			props.setProperty("mail.store.protocol", "imaps");
			
			Session session = Session.getDefaultInstance(props);
			Store store = session.getStore();
			store.connect("imap.gmail.com", "mawoffshore@gmail.com","metasoft1");
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_WRITE);
			
			int count = inbox.getUnreadMessageCount();
			
			if(count >0){
		    	
				int totalCount = inbox.getMessageCount();
				
				for(int i=0; i<count;i++){
					
					int countEmail = totalCount-i;
					Message msg = inbox.getMessage(countEmail);
					msg.setFlag(Flags.Flag.SEEN, true);
					Address[] in = msg.getFrom();
					
					for(Address address :in){			
						from_email= address.toString();
						subject_email = msg.getSubject();
					}
					
					Object output = msg.getContent();
					if (output instanceof String)  
					{  
					    String body = (String)content;  
					    content_email = body.toString();
					}  
					else if (output instanceof Multipart) {  
					    Multipart mp = (Multipart)output;
					    BodyPart bp = mp.getBodyPart(0);
					    content_email = bp.getContent().toString();
					    System.out.println(content_email);
					}
					 String parsed_content = Jsoup.parse(content_email).text();
					 if(from.equals(from_email)){
				    				    	 
				    	 if(subject_email.contains(subject)){
				    	 
				    		 if (parsed_content.contains(content)){
				    			 i = count;
				    			 bool = true;
				     		}
				    	 }	 	
				    }
			}
			}
			else
				throw new CustomException("The expected mail is not received to the email address");
			if(bool == false){
		    	 throw new CustomException("The expected mail is not received to the email address");
		     }
		}
		catch(Exception ex){
			throw ex;
		}
    }
	public static void fetchDiagnosisURL(String ElementID, String text,WebDriver driver) throws InterruptedException, MessagingException, Exception {

		try{
			Thread.sleep(15000);
			
			String from=null, subject=null, content = null,
					from_email = null, subject_email=null,content_email=null;
			
			String[] emailVerify ;
			emailVerify = text.split("\\|");
	 		
	 		from=emailVerify[0];
			subject=emailVerify[1];
			content=emailVerify[2];
			Properties props = new Properties();
			props.setProperty("mail.store.protocol", "imaps");
			
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect(Constant.hostname, Constant.username, Constant.password);
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_WRITE);
			
			int count = inbox.getUnreadMessageCount();
			
			if(count >0){
		    	
				int totalCount = inbox.getMessageCount();
				
				for(int i=0; i<count;i++){
					
					int countEmail = totalCount-i;
					Message msg = inbox.getMessage(countEmail);
					msg.setFlag(Flags.Flag.SEEN, true);
					Address[] in = msg.getFrom();
					
					for(Address address :in){			
						from_email= address.toString();
						subject_email = msg.getSubject();
					}
					
					Object output = msg.getContent();
					if (output instanceof String)  
					{  
					    String body = (String)content;  
					    content_email = body.toString();
					}  
					else if (output instanceof Multipart) {  
					    Multipart mp = (Multipart)output;
					    BodyPart bp = mp.getBodyPart(1);
					    content_email = bp.getContent().toString();
					    System.out.println(content_email);
					}
					 String parsed_content = Jsoup.parse(content_email).text();
					 List<String> extractedUrls=extractUrls(content_email);
					 boolean bool = false;
					 if(from.equals(from_email)){
				    				    	 
				    	 if(subject.equals(subject_email)){
				    	 
				    		 if (parsed_content.startsWith(content)){
				    			 System.out.println("Email verified");
				    			 i = count;
				    			 for (String url : extractedUrls)
								    {
								    	if(url.contains("DiagnosisVerification")){
								    		driver.get(url);
								    		bool = true;
								    		enterTextCss(ElementID,Constant.volunteerID,driver);
								    	}
								    }
								    if(bool == false)
							    		throw new CustomException("The diagnosis verification URL is not available in the email");
							    
				     			}
				    		 	else{
				    		 		throw new CustomException("The given content value in excel is not matched with the fetched data ");
				    		 		}
				     		}
				    	 else{
				    		 throw new CustomException("The given subject value in excel  is not matched with the fetched data ");
				    	 }
				     }
				     else{
				    	 throw new CustomException("The given From value in excel is not matched with the fetched data ");
				     }
				}
			}
			else {
		    	 throw new CustomException("The mail is not received to the email address");
		     }
		}
		catch(Exception ex){
			throw ex;
		}
    }
		public static void fetchURL(String ElementID, String text,WebDriver driver) throws InterruptedException, MessagingException, Exception {
		// TODO Auto-generated method stub
		Thread.sleep(10000);
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		
		Session session = Session.getInstance(props, null);
		Store store = session.getStore();
		store.connect(Constant.hostname, Constant.username, Constant.password);
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);
		
		int count = inbox.getUnreadMessageCount();
		int totalCount = inbox.getMessageCount();
		if(count>0){
			for(int i=0; i<count;i++){
				
				int countEmail = totalCount-i;
				Message msg = inbox.getMessage(countEmail);
				
				Object output = msg.getContent();
				if (output instanceof Multipart) {  
				    Multipart mp = (Multipart)output;
				    BodyPart bp = mp.getBodyPart(0);
				    String content_email = bp.getContent().toString();
				    //System.out.println(content_email);
				    List<String> extractedUrls=extractUrls(content_email);
				    for (String url : extractedUrls)
				    {
				        driver.get(url);
				    }
				}
				else if(output instanceof String){
					
				   String body = (String)output;  
				   String content_email = body.toString();
				 
				   List<String> extractedUrls=extractUrls(content_email);
				   	for (String url : extractedUrls)
				    {
				        driver.get(url);
				    }
					 
			        System.out.println("Subject: " + msg.getSubject());
			        System.out.println("From: " + msg.getFrom()[0]);
			        System.out.println("Body: "+ msg.getContent());
				}
			}
		}
		else{
			throw new CustomException("The mail is not received to the email address");
		}
    }
	
	public static List<String> extractUrls(String text)
	{
	    List<String> containedUrls = new ArrayList<String>();
	    String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
	    Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
	    Matcher urlMatcher = pattern.matcher(text);

	    while (urlMatcher.find())
	    {
	        containedUrls.add(text.substring(urlMatcher.start(0),
	                urlMatcher.end(0)));
	    }
	    return containedUrls;
	}
	
	public static void highLightElement(WebDriver driver,WebElement element) throws InterruptedException{
		scroll(driver,element);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.background='yellow'", element);
		TimeUnit.MILLISECONDS.sleep(500);
		js.executeScript("arguments[0].style.background=''", element);
	}
	
	public static void scroll(WebDriver driver, WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
	public static void listviewtable(String ElementID, String text,WebDriver driver){
		boolean bool = false;
		List <WebElement> row = driver.findElements(By.cssSelector(ElementID));
		for(WebElement e: row)
		{
			if(text.equals(e.getText())){
				e.click();
				bool = true;
				return;
			}
		}
		if(bool == false)
			throw new CustomException(text + "- is not available in the webtable.");
	}
	public static void verify_listviewtable(String ElementID, String text,WebDriver driver){
		boolean bool = false;
		List <WebElement> row = driver.findElements(By.cssSelector(ElementID));
		for(WebElement e: row)
		{
			if(text.equals(e.getText())){
				bool = true;
				return;
			}
		}
		if(bool == true)
			throw new CustomException(text + "- should not be available in the webtable.");
	}
	public static void verifydriver(String ElementID, String text,WebDriver driver){
		try{
			String url = driver.getCurrentUrl();
	        if(url.startsWith(text)){
	        	throw new CustomException("The driver not closed.");
	        }
		}
		catch(Exception ex){
			return;
		}
	
	}
	public static void DateComparison(String ElementID, String text,WebDriver driver) throws Exception{
		SimpleDateFormat gmtDateFormat = new SimpleDateFormat("MM/dd/YYYY");
		gmtDateFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		String GDate = gmtDateFormat.format(new Date());
		WebElement element = driver.findElement(By.cssSelector(ElementID));
		String SDate=element.getText();
		if(!SDate.equals(GDate))
		{
			throw new CustomException("The date is not populated as expected.");
		}
		highLightElement(driver, element);
	}
	public static void switchtoTab(String ElementID, String text,WebDriver driver){
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		//Use the list of window handles to switch between windows
		driver.switchTo().window(tabs.get(1));
	}
	
	public static void SetTrimURL(String ElementID, String data, WebDriver driver){
			try{
				String url =driver.getCurrentUrl();
				String[] urlArray = url.split("/");
				String tempurl = urlArray[urlArray.length-1];
				String NewUrl =(data+tempurl);
				driver.get(NewUrl);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
			catch(Exception ex){
				throw ex;
			}
		}
		
		
	public static void wait(String ElementID, String data, WebDriver driver) throws Exception{
			try{
				Thread.sleep(50000);
			}
			catch(Exception ex){
				throw ex;
			}
		}
	public static void WindowHandler(String ElementID, String data,WebDriver driver) throws Exception{
		try{
			String[] metadata,testdata ;
			metadata = ElementID.split("\\|");
	 		
	 		String Win_P=metadata[0];
	 		String searchFrame =metadata[1];
	 		String Win_C =metadata[2];
			String resultFrame =metadata[3];
			String AccountName=metadata[4];
			String Country=metadata[5];
			String State=metadata[6];
			String Save=metadata[7];
			
			testdata=data.split("\\|");
			String Name=testdata[0];
			String Country_Data=testdata[1];
			String State_Data=testdata[2];
			
			String Parent_Window = driver.getWindowHandle();
			
			driver.findElement(By.cssSelector(Win_P)).click();
			
		    // Switching from parent window to child window   
		    for (String Child_Window : driver.getWindowHandles()){
		    	if(!Parent_Window.equals(Child_Window)){
				driver.switchTo().window(Child_Window);
				driver.switchTo().frame(searchFrame);
				driver.findElement(By.cssSelector(Win_C)).click();
				driver.switchTo().defaultContent();
				driver.switchTo().frame(resultFrame);
				driver.findElement(By.cssSelector(AccountName)).sendKeys(Name);
				Select select=new Select(driver.findElement(By.cssSelector(Country)));
				select.selectByVisibleText(Country_Data);
				Select select1=new Select(driver.findElement(By.cssSelector(State)));
				select1.selectByVisibleText(State_Data);
				driver.findElement(By.xpath(Save)).click();
				Thread.sleep(500);
				}
		    }
		     driver.switchTo().window(Parent_Window);
		}
		catch(Exception ex){
		  	throw ex;
		}
	}
		 
	public static boolean click_VolunteerID_Xpath(String ElementID, String text,WebDriver driver){
		try{
		WebElement table = driver.findElement(By.xpath(ElementID));
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		boolean test = false;
		String relationValue=null; 
		for(int row=1; row<=rows_count; row++){
		WebElement col_table = rows_table.get(row).findElement(By.tagName("th"));
		relationValue = col_table.getText();
		if(Constant.volunteerID.equals(relationValue)){
		WebElement anchor = col_table.findElement(By.tagName("a"));
		anchor.click();
		test = true;
		break;
		}
		}
		if(test==false){
		throw new CustomException("The given value is not matched with the fetched data " +relationValue);
		}
		}
		catch(NoSuchElementException c){
		throw c;
		}
		return false;
		}
}
