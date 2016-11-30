package testEngine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import action.ActionKeywords;
import atu.testrecorder.ATUTestRecorder;
import constant.Constant;
import exception.CustomException;
import screenshot.Screen;
import utility.ExcelUtility;

public class TestEngine {

	protected static WebDriver driver;
	protected static ExtentReports report;
	protected static ExtentTest logger,childLogger;
	protected static ChromeOptions options;
	private static Method arrayMethod[];
	public static ActionKeywords actionKeywords;
	public static String title = null;
	private static ATUTestRecorder recorder;
	private static WebDriver screenDriver;
	
	@BeforeTest
	public static void browserStartUp(){
		System.setProperty("webdriver.chrome.driver",Constant.chromeDriver);
		options = new ChromeOptions();
		options.addArguments("--disable-extensions");
        report = new ExtentReports(Constant.reportLocation,true);
	}
	
	@Test
	public static void main() throws Exception,CustomException {
		try{
			
			
			Path metapath1 = Paths.get(Constant.filePath+Constant.metaDataFileName);
			Path testpath1 = Paths.get(Constant.filePath+Constant.testDataFileName);
			String metapath = metapath1.toString();
			String testpath = testpath1.toString();
			
			//Check the meta data and test data file is exists.
			if(Files.exists(metapath1) && Files.exists(testpath1)){	
				
				String executionIndicator=null,testCaseSheet_testCaseID=null,
						testCaseFlow=null,screen_testCaseID=null,
						screenName=null,allScreens[]=null;
				
				int noOfTestCase,testData_Rows,metaData_Rows,testData_Columns;
				
				noOfTestCase = ExcelUtility.getNumberOfRows(testpath, Constant.flowSheetName);
				System.out.println("Number of test case"+noOfTestCase);
				
				for(int i=1; i<=noOfTestCase; i++){
					try{
					executionIndicator=ExcelUtility.readExcel(testpath,Constant.flowSheetName, i,0);
					
					if(executionIndicator!=null){
						title = ExcelUtility.readExcel(testpath,Constant.flowSheetName, i,2);
						logger=report.startTest(title);
						
						logger.assignCategory("Regression");
						logger.assignAuthor("MST Automation Tester");
						report.addSystemInfo("Selenium Version", "2.53.1");
						report.addSystemInfo("Environment", "Full Copy");
						if(executionIndicator.equals("Y")){
							try{
								
								driver = new ChromeDriver(options);
								screenDriver = new Augmenter().augment(driver);
																
								//Get the testCaseID & testCaseFlow
								testCaseSheet_testCaseID=ExcelUtility.readExcel(testpath,Constant.flowSheetName, i,1);
								testCaseFlow=ExcelUtility.readExcel(testpath,Constant.flowSheetName, i,3);
								recorder = new ATUTestRecorder(Constant.videoPath,Constant.videoFileName+testCaseSheet_testCaseID,false);
								recorder.start();
	
								if(testCaseFlow!=null){
													
								    allScreens=testCaseFlow.split("\\,");
								    int screen_count = allScreens.length;
											    
									for(int j=0;j<screen_count;j++){
										screenName=allScreens[j];
										//If the screen name is Completed, the following flow will occur.
										if(screenName.equals("Completed")){
											ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,"Test Case Completed Successfully",i,6);
										}
										else{
									 		testData_Rows=ExcelUtility.getNumberOfRows(testpath,screenName);	
											metaData_Rows=ExcelUtility.getNumberOfRows(metapath,screenName);					
											
											for(int k=1;k<=testData_Rows;k++){
												screen_testCaseID=ExcelUtility.readExcel(testpath,screenName,k,0);
																			
												if(testCaseSheet_testCaseID!=null && screen_testCaseID!=null && screen_testCaseID.equalsIgnoreCase(testCaseSheet_testCaseID)){
													testData_Columns=ExcelUtility.getNumberOfCols(testpath,screenName);
												
													for(int l=1;l<testData_Columns;l++){
														String testData=ExcelUtility.readExcel(testpath,screenName, k,l);
														String testData_FieldName=ExcelUtility.readExcel(testpath,screenName, 0, l);
																							
														if(testData==null || testData.equals("SKIP")){
															//System.out.println("No value in the cell..");
														}
														else{								
															for(int m=1;m<=metaData_Rows;m++){
																String metaData_FieldName=ExcelUtility.readExcel(metapath,screenName, m,0);
															
																if(testData_FieldName.equalsIgnoreCase(metaData_FieldName)){
																
																	String metaData_FieldAttribute=ExcelUtility.readExcel(metapath,screenName,m,2);
																	String type=ExcelUtility.readExcel(metapath,screenName, m, 1);
																												
																	actionKeywords = new ActionKeywords();
																	/*This will load all the methods in 'ActionKeywords' class.
																    It will be like array of method, use the break point here and watch it*/
																	arrayMethod= actionKeywords.getClass().getMethods();
																	
																	/*This is a loop which will run for the number of actions in the Action Keyword class 
																	arrayMethod contains all the method and arrayMethod.length returns the total number of methods*/
																	for(int z = 0;z  < arrayMethod.length;z++){
																		//This is now comparing the method name with the ActionKeyword value got from excel
																		if(arrayMethod[z].getName().equals(type)){
																			childLogger = report.startTest(metaData_FieldName+"-"+type);
																			arrayMethod[z].invoke(actionKeywords,metaData_FieldAttribute,testData,driver);
																			childLogger.log(LogStatus.PASS, metaData_FieldAttribute+ "-"+"Passed");
																			logger.appendChild(childLogger);
																			m=metaData_Rows+1;
																			//Once any method is executed, this break statement breaks the loop.
																			break;
																			}
																		}
																	}
																}
															}
														}
														k=testData_Rows+1; // break the loop, when the current test case execution is completed.
													}
												else{
													//System.out.println("The test case ID's are not matched with the Testcase sheet and "+screenName);
												}
											}
										}							
									}
								}
								else{
									ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,"Test case flow is invalid",i,6);
									ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,"Failed",i,7);
									logger.log(LogStatus.ERROR, "Test case flow is invalid");
								}
							} 
							catch(CustomException e){
								
								Screen.fullScreenshot(screenDriver,testCaseSheet_testCaseID,childLogger);
								ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,e.toString(),i,6);
								childLogger.log(LogStatus.FAIL,title,e.toString());
								logger.appendChild(childLogger);
							}
							catch(InvocationTargetException in){
								Throwable cause = in.getCause();
								Screen.screenshot(screenDriver,testCaseSheet_testCaseID,childLogger);
								ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,cause.getLocalizedMessage(),i,6);
								childLogger.log(LogStatus.FAIL,title,cause.toString());
								logger.appendChild(childLogger);
							} 
						
							catch (Exception ex){
								Reporter.log("Entered in to test execution catch block"+ex.toString());
								Screen.fullScreenshot(screenDriver,testCaseSheet_testCaseID,childLogger);
								ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,ex.toString(),i,6);
								childLogger.log(LogStatus.FAIL,title,ex.toString());
								logger.appendChild(childLogger);
							}
							try{
								String ActResult= ExcelUtility.readExcel(testpath,Constant.flowSheetName,i,6);
								String ExpResult= ExcelUtility.readExcel(testpath,Constant.flowSheetName,i,5);
								
								if(ActResult.contains(ExpResult)){
									ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,"Passed",i,7);
									logger.log(LogStatus.PASS, title,"Passed");
								}
								else{	
									ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,"Failed",i,7);
								}
							}
							catch(Exception ex){
								ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,ex.toString(),i,6);
								ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,"Failed",i,7);
							}
							driver.quit();
							recorder.stop();
						}
						else{
							ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,"",i,6);
							ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,"Skipped",i,7);
							logger.log(LogStatus.SKIP, title,"Skipped");
						}
						report.endTest(logger);
					}
					else{
						logger.log(LogStatus.ERROR, "Execution Indicator is null");
					}
					
					}
					catch(Exception ex){
						ExcelUtility.existingWriteExcel(testpath,Constant.flowSheetName,ex.toString(),i,6);
						logger.log(LogStatus.FAIL,title,ex.toString());
					}
				}
				
			}
			else{
				System.out.println("Metadata and testdata files does not exist");
			}
		}
		catch(Exception ex){
			ex.getMessage();
		}
	}
	
	@AfterTest
	public static void closeBrowser(){
		//logger.log(LogStatus.INFO, "Browser Closed");
		report.flush();
	}	
}
