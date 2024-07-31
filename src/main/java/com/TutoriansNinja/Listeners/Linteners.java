package com.TutoriansNinja.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TurorialNinja.Utils.ExtentReport;
import com.TurorialNinja.Utils.utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Linteners implements ITestListener{

	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;
	
	@Override
	public void onStart(ITestContext context) {
		extentReport = ExtentReport.getExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName+" Started Executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		extentTest.log(Status.PASS,testName+" got Successfully Executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String destinationScreenShotPath = utils.captureScreenshot(driver, testName);
		
		extentTest.addScreenCaptureFromPath(destinationScreenShotPath);
		
		extentTest.log(Status.INFO,testName+ result.getThrowable());
		extentTest.log(Status.FAIL,testName+ " got failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO,testName+ result.getThrowable());
		extentTest.log(Status.SKIP,testName+ " got skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
		String pathExtentReport = System.getProperty("user.dir")+"\\Reports\\ExtentReports\\extentReport.html";
		File extentReportFile = new File(pathExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReportFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
