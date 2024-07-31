package com.TutorialsNinja.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import com.TurorialNinja.Utils.utils;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public Base() 
	{
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TutorialsNinja\\Config\\config.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataProp = new Properties();
		File dataFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TutorialNinja\\TestData\\TestData.properties");
		FileInputStream fis2 = null;
		try {
			fis2 = new FileInputStream(dataFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dataProp.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public WebDriver initializeBrowserAndOpenApplication(String browser_Name) 
	{			
		switch (browser_Name) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			//driver = new ChromeDriver();
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utils.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}	
	

	
	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}
	
}
