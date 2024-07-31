package com.TurorialNinja.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utils {
	
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 10;
	
	public static String generateRandomUsername() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789._"; // Allowed characters in Gmail username
        int length = 10; // Length of the random username

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Generate random characters for the username
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }
	
	public static String generateRandom10DigitNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Ensure the first digit is not zero to maintain 10 digits
        sb.append(random.nextInt(9) + 1); // First digit (1-9)

        // Generate the remaining 9 digits
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(10)); // 0-9 for each digit
        }

        return sb.toString();
    }

	 public static Object[][] getExcelData(String sheetName) 
	 {
		 File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TutorialNinja\\TestData\\Logindata.xlsx");
		 FileInputStream fisExcel = null;
		try {
			fisExcel = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fisExcel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 XSSFSheet sheet = workbook.getSheet(sheetName);
		 
		 //no of rows
		 int noOfRows = sheet.getLastRowNum();
		 
		 //no of columns
		 int noOfColumns = sheet.getRow(0).getLastCellNum();
		 
		 Object data[][] = new Object[noOfRows][noOfRows];
		 
		 for(int i=0;i<noOfRows;i++) 
		 {
			 XSSFRow row = sheet.getRow(i+1);
			 for(int j=0;j<noOfColumns;j++) 
			 {
				 XSSFCell cell = row.getCell(j);
				 CellType celltype = cell.getCellType();
				 
				 switch (celltype) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				default:
					break;
				}
				 
				 
			 }
		 }
		 return data;
	 }
	

	 public static String captureScreenshot(WebDriver driver,String testName) 
	 {
			File srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String destinationScreenShotPath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
			try {
				FileHandler.copy(srcScreenShot,new File (destinationScreenShotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return destinationScreenShotPath;
	 }
	 
	 
	
	 
	 
	
}
