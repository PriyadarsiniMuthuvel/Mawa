package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	
	private static File file = null;
	private static FileInputStream inputStream = null;
	private static FileOutputStream outputStream = null;

	public static Workbook workbook =null;
	
	public static CellStyle style = null;
	public static Font font = null;
	private static Sheet sheet = null;
	private static Row row = null;
	private static Cell cell =null;
	
	private static int totalRows=0;
	private static int totalCols=0;
	
	//To get the sheet name from workbook
	public static Sheet getSheet(String filePath,String sheetName) throws Exception{
		try {
			 workbook = readWorkbook(filePath, sheetName); 
		     sheet = workbook.getSheet(sheetName);
		}
		catch(Exception ex){
			ex.getStackTrace();
			throw ex;
		}
		return sheet;
	}
	
	public static Workbook readWorkbook(String filePath,String sheetName) throws Exception{
		try {
			file =    new File(filePath);
		    inputStream = new FileInputStream(file);     
		    String fileExtensionName = filePath.substring(filePath.indexOf("."));
		    
		     if(fileExtensionName.equals(".xlsx")){
		    	 workbook = new XSSFWorkbook(inputStream);
		    }
		     else if(fileExtensionName.equals(".xls")){
		         workbook = new HSSFWorkbook(inputStream);
		    }     
		}
		catch(Exception ex){
			throw ex;
		}
		return workbook;
	}
	
	public static Workbook writeWorkbook (String filePath) throws Exception{
		try {
			file =    new File(filePath);
		    outputStream = new FileOutputStream(file);     
		    String fileExtensionName = filePath.substring(filePath.indexOf("."));
		 
		     if(fileExtensionName.equals(".xlsx")){
		    	 workbook = new XSSFWorkbook();
		    }
		     else if(fileExtensionName.equals(".xls")){
		         workbook = new HSSFWorkbook();
		    }     
		}
		catch(Exception ex){
			throw ex;
		}
		return workbook;
	}
	
	//To get the total number of row in the excel sheet
	public static int getNumberOfRows(String filePath,String sheetName) throws Exception{
	try {
	     sheet=getSheet(filePath, sheetName);
	     totalRows = sheet.getLastRowNum();    
	    }
		catch(Exception ex){
			throw ex;
		}
	 return totalRows;
	}
	
	//To get the total number of columns in the excel sheet
	public static int getNumberOfCols(String filePath,String sheetName) throws Exception{
	try {
	       sheet=getSheet(filePath, sheetName);
		   totalRows = sheet.getLastRowNum(); 
		   row=sheet.getRow(0);
		   totalCols=row.getLastCellNum();
    	 }
		catch(Exception ex){
			throw ex;
		}
	return totalCols;
	}

	//To read the data from the concerned cell
	public static String readExcel(String filePath,String sheetName,int RowNumber,int ColNumber) throws Exception{
	Object result = null;
	try
	{
		sheet=getSheet(filePath, sheetName);
	    row=sheet.getRow(RowNumber);
		    
	    if(row != null){
	    	cell= row.getCell(ColNumber);
	    	if(cell!=null){
		    	switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:// numeric value in excel
					if(DateUtil.isCellDateFormatted(cell)){
						Date myDate = cell.getDateCellValue();
						SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
				        result = formatter.format(myDate);
					}
					else{
						result = new BigDecimal(cell.getNumericCellValue()).toPlainString();
					}
					break;
					
				case Cell.CELL_TYPE_STRING: // string value in excel
					result = cell.getStringCellValue();
					break;
					
				case Cell.CELL_TYPE_BOOLEAN: // boolean value in excel
					result = cell.getBooleanCellValue();
					break;
					
				case Cell.CELL_TYPE_BLANK: // blank value in excel
					result = cell.getStringCellValue();
					break;
				
				case Cell.CELL_TYPE_ERROR: // Error value in excel
					result = cell.getErrorCellValue()+"";
					break;
		    	}
	    	}
	    	else{
	    		return null;
	    	}
	    }
	    else{
	    	return null;
	    }
	    inputStream.close(); 
	}
	catch (Exception ex){
		throw ex;
		}
	return result.toString();	
}

	//To write the data in the concerned cell
	public static void existingWriteExcel(String filePath,String sheetName,String dataToWrite,int RowNumber,int ColNumber) throws Exception
	{
		try{
			sheet=getSheet(filePath, sheetName);
			
			if(ColNumber==0)
			{
			    row = sheet.createRow(RowNumber);
			    cell = row.createCell(ColNumber);
		        cell.setCellValue(dataToWrite);
	            sheet.autoSizeColumn(ColNumber);	        
			 }
			 else
			 {
				 row = sheet.getRow(RowNumber); 
				 cell = row.createCell(ColNumber);
				 cell.setCellValue(dataToWrite);
			     sheet.autoSizeColumn(ColNumber);
			 }
		    inputStream.close();
		    outputStream = new FileOutputStream(file);
		    workbook.write(outputStream);
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if (outputStream != null) {
	            outputStream.flush();
	            outputStream.close();
	        }
		}
	 }

	//Create a write operation for pie chart analysis
	public static void createPieExcel(String filePath,String sheetName,int dataToWrite,int RowNumber,int ColNumber) throws Exception{
		try{
			file =    new File(filePath);
			Path path = Paths.get(filePath);
	
			if (Files.notExists(path)) {
				workbook = writeWorkbook(filePath);
				sheet = workbook.createSheet(sheetName);
				sheet=workbook.getSheet(sheetName);
				
				style = workbook.createCellStyle();
		    	font = workbook.createFont();
		    	
				sheet.createRow(0).createCell(0).setCellValue("Status");
				sheet.getRow(0).createCell(1).setCellValue("Count");
				
				sheet.createRow(1).createCell(0).setCellValue("Failed");
				sheet.createRow(2).createCell(0).setCellValue("Skipped");
				sheet.createRow(3).createCell(0).setCellValue("Passed");
				
				sheet.createRow(4).createCell(0).setCellValue("Total Test cases");
				
				row = sheet.getRow(RowNumber); 
				cell = row.createCell(ColNumber);
				cell.setCellValue(dataToWrite);
				
		    	font.setColor(IndexedColors.RED.index);
		    	style.setFont(font);
				cell.setCellStyle(style);
			    sheet.autoSizeColumn(ColNumber);
			
			}
			else if (Files.exists(path)) {

			    sheet = workbook.getSheet(sheetName);
				sheet=getSheet(filePath, sheetName);
			    row = sheet.getRow(RowNumber);
			    cell = row.createCell(ColNumber);
				cell.setCellValue(dataToWrite);
				
				style = workbook.createCellStyle();
		    	font = workbook.createFont();
				
		    	if(RowNumber==1){
			    	font.setColor(IndexedColors.RED.index);
				}
				else if(RowNumber==2){
			    	font.setColor(IndexedColors.GREEN.index);
				}
				else if(RowNumber==3){
			    	font.setColor(IndexedColors.BLUE.index);
				}
				style.setFont(font);
				cell.setCellStyle(style);
				sheet.autoSizeColumn(ColNumber);
				inputStream.close();
			}
		        outputStream = new FileOutputStream(file);
		        workbook.write(outputStream);
		}
		catch(Exception ex){
			throw ex;
		}
		finally {
	        if (outputStream != null) {
	           	outputStream.flush();
	            outputStream.close();
	        }
	    }
	}
}
