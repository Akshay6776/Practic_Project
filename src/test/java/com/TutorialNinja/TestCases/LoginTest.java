package com.TutorialNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TurorialNinja.Utils.utils;
import com.TutorialNinja.PageObjects.AccountsPage;
import com.TutorialNinja.PageObjects.HomePage;
import com.TutorialNinja.PageObjects.LoginPage;
import com.TutorialsNinja.Base.Base;

public class LoginTest extends Base{
	
	public WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AccountsPage accountsPage;
	
	@BeforeMethod
	public void setup() 
	{
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		homePage.clickOnMyAccounts();
		loginPage = homePage.clickOnLoginButton();
	}
	
	@Test(priority = 0,dataProvider = "supplyTestData")
	public void varifyLoginWithValidCerdentils(String Email, String Password) 
	{
		loginPage.enterEmail(Email);
		loginPage.enterPassword(Password);
		accountsPage = loginPage.clickOnLoginButton();
		String My_Accounts = accountsPage.getMyAccount_Title();
		Assert.assertEquals(My_Accounts,dataProp.getProperty("my_Accounts_Title"),"My Account title is not found after Loging in");
		
	}
	
	@Test(priority = 1)
	public void varifyLoginWithInvalidCredentils() 
	{		
		loginPage.enterEmail(utils.generateRandomUsername()+"@gmail.com");
		loginPage.enterPassword(utils.generateRandomUsername());
		loginPage.clickOnLoginButton();
		String warningMessage = loginPage.getLoginErrorMessage();

		Assert.assertEquals(warningMessage, dataProp.getProperty("Login_warning_Message"),"Warning Message is not shown");
	}
	
	@Test(priority = 2)
	public void varifyLoginWithInvalidEmailAndValidPasswordCredentils() 
	{
		loginPage.enterEmail(utils.generateRandomUsername()+"@gmail.com");
		loginPage.enterPassword(prop.getProperty("valiedPassword"));
		loginPage.clickOnLoginButton();
		String warningMessage = loginPage.getLoginErrorMessage();
		
		Assert.assertEquals(warningMessage, dataProp.getProperty("Login_warning_Message"),"Warning Message is not shown");
	}
	
	@Test(priority = 3)
	public void varifyLoginWithValidEmailAndInValidPasswordCredentils() 
	{
		loginPage.enterEmail(utils.generateRandomUsername()+"@gmail.com");
		loginPage.enterPassword(utils.generateRandomUsername());
		loginPage.clickOnLoginButton();
		
		String warningMessage = loginPage.getLoginErrorMessage();
		
		Assert.assertEquals(warningMessage, dataProp.getProperty("Login_warning_Message"),"Warning Message is not shown");
		
	
	}
	
	@Test(priority = 4)
	public void varifyLoginWithoutProvidingAnyCredentils() 
	{
		loginPage.clickOnLoginButton();

		String warningMessage = loginPage.getLoginErrorMessage();		
		Assert.assertEquals(warningMessage, dataProp.getProperty("Login_warning_Message"),"Warning Message is not shown");
		
	}
	
	@DataProvider
	public Object[][] supplyTestData() 
	{
		Object[][] data = null;
		try {
			data = utils.getExcelData("Sheet1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}



