package com.TurorialNinja.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	
	public static ExtentReports getExtentReport() 
	{
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\Reports\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Tutorials Ninja Test Automation Results");
		sparkReporter.config().setDocumentTitle("TN Automation Results");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		
		Properties configProp = new Properties();
		File confFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TutorialsNinja\\Config\\config.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(confFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			configProp.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application Url", configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser", configProp.getProperty("browser"));
		extentReport.setSystemInfo("Email", configProp.getProperty("valiedEmail"));
		extentReport.setSystemInfo("Password", configProp.getProperty("valiedPassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("user Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("java version", System.getProperty("java.version"));
		
		return extentReport;
		
	}

}
