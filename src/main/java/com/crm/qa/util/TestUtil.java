package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String TESTDATA_SHEET_PATH="F:/selenium/HybridFrameworkAutomation/src/main/java/com/crm/qa/testdata/TestData.xlsx";
	public static Workbook book;
	public static Sheet sh;
	public static String SHEET_NAME="contacts";
	

	public static void switchToFrame(){
		
		driver.switchTo().frame("mainpanel");
		
	}
	
	public static Object[][] getData(){
		
		FileInputStream file= null;
		
		try{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			
			book = WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e){
			e.printStackTrace();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		sh=book.getSheet(SHEET_NAME); 
		Object[][] data= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];	
		for(int i=0;i<sh.getLastRowNum();i++){
			
			for (int j=0;j<sh.getRow(0).getLastCellNum();j++){
				
				data[i][j]= sh.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
		/*Object[][] excellData = null;
		try {
				FileInputStream fs = new FileInputStream(fileName);
				Workbook wb = WorkbookFactory.create(fs);
				Sheet sh = wb.getSheet(sheetName);

				int rowcount = sh.getLastRowNum();
				int cellcount = sh.getRow(0).getLastCellNum();
				String data[][] = new String[rowcount][cellcount];
				for (int i = 1; i <= rowcount; i++) {
						Row r = sh.getRow(i);
				    for (int j = 0; j <=cellcount; j++) {
				    		Cell c = r.getCell(j);
				    	try {
				
				    		excellData[i - 1][j] = c.getStringCellValue();
				
				    		} 
				    		catch (Exception e) {
				    			e.printStackTrace();
				    		}
				    }
				}   
				return  excellData[][];
				   
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
				  
	}*/

		
		
	}
		
		
	}
