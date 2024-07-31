package com.TutorialNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TurorialNinja.Utils.utils;
import com.TutorialNinja.PageObjects.AccountSuccessPage;
import com.TutorialNinja.PageObjects.HomePage;
import com.TutorialNinja.PageObjects.RegisterPage;
import com.TutorialsNinja.Base.Base;

public class RegisterTest extends Base{
	
	public WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	SoftAssert sa;
	
	@BeforeMethod
	public void initiate() 
	{
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		homePage.clickOnMyAccounts();
		registerPage = homePage.clickOnRegisterButton();
	}
	
	
	@Test(priority = 0)
	public void verifyRegisteringAnAccountWithMandatoryFields() 
	{
//		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(utils.generateRandomUsername());
//		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(utils.generateRandomUsername());
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(utils.generateRandomUsername()+"@gamil.com");
//		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(utils.generateRandom10DigitNumber());
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("valiedPassword"));
//		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("valiedPassword"));
//		driver.findElement(By.xpath("//input[@name='agree']")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		registerPage.enterAllCredintils(utils.generateRandomUsername(),
				utils.generateRandomUsername(),
				utils.generateRandomUsername()+"@gamil.com",
				utils.generateRandom10DigitNumber(),
				prop.getProperty("valiedPassword"));
		registerPage.clickAgreePrivacyPolicy();
		accountSuccessPage = registerPage.clickContinueButton();
		String acc_Creation_Success_Mess = accountSuccessPage.getSuccessMessage();
		//String acc_Creation_Success_Mess = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		
		Assert.assertEquals(acc_Creation_Success_Mess, dataProp.getProperty("Account_Creation_Success_Message"),"Account success page not shown");	
	}
	
	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithProvidingAllFields() 
	{
//		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(utils.generateRandomUsername());
//		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(utils.generateRandomUsername());
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(utils.generateRandomUsername()+"@gamil.com");
//		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(utils.generateRandom10DigitNumber());
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("valiedPassword"));
//		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("valiedPassword"));
//		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
//		driver.findElement(By.xpath("//input[@name='agree']")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		registerPage.enterAllCredintils(utils.generateRandomUsername(),
				utils.generateRandomUsername(),
				utils.generateRandomUsername()+"@gamil.com",
				utils.generateRandom10DigitNumber(),
				prop.getProperty("valiedPassword"));
		registerPage.clickYesNewsLetter();
		registerPage.clickAgreePrivacyPolicy();
		accountSuccessPage = registerPage.clickContinueButton();
		
		String acc_Creation_Success_Mess = accountSuccessPage.getSuccessMessage();
		
		Assert.assertEquals(acc_Creation_Success_Mess, dataProp.getProperty("Account_Creation_Success_Message"),"Account success page not shown");
			
	}
	
	@Test(priority = 2)
	public void verifyRegisteringAccountWithAlreadyExistingEmail() 
	{
//		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(utils.generateRandomUsername());
//		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(utils.generateRandomUsername());
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("valiedEmail"));
//		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(utils.generateRandom10DigitNumber());
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("valiedPassword"));
//		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("valiedPassword"));
//		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
//		driver.findElement(By.xpath("//input[@name='agree']")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		registerPage.enterAllCredintils(utils.generateRandomUsername(),
				utils.generateRandomUsername(),
				prop.getProperty("valiedEmail"),
				utils.generateRandom10DigitNumber(),
				prop.getProperty("valiedPassword"));
		registerPage.clickYesNewsLetter();
		registerPage.clickAgreePrivacyPolicy();
		registerPage.clickContinueButton();
		
//		String Email_Already_Exists_Warning_Message = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String Email_Already_Exists_Warning_Message = registerPage.getEmailAlreadyExistErrorMessage();
		
		Assert.assertEquals(Email_Already_Exists_Warning_Message, dataProp.getProperty("Email_Already_Exist_Error_Message"),"Warning Message not shown");
	}
	
	@Test(priority = 3)
	public void verifyRegisteringAnAccountWithoutProvidingAnyFields() 
	{		
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		registerPage.clickContinueButton();
		
		sa = new SoftAssert();
		
//		String privacy_Policy_Error_Mess = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String privacy_Policy_Error_Mess = registerPage.getPrivacyPolicyAllertMessage();
		sa.assertEquals(privacy_Policy_Error_Mess, dataProp.getProperty("Privacy_policy_Warning_Message"),"Privacy Policy Error Message not found");
		
//		String first_Name_Error_Mess = driver.findElement(By.xpath("//div[@class='text-danger' and contains(text(),'First Name')]")).getText();
		String first_Name_Error_Mess = registerPage.getFirstNameErrorMessage();
		sa.assertEquals(first_Name_Error_Mess, dataProp.getProperty("First_Name_Error_Message"),"First Name Error Message Not Shown");
		
//		String last_Name_Error_Mess = driver.findElement(By.xpath("//div[@class='text-danger' and contains(text(),'Last Name')]")).getText();
		String last_Name_Error_Mess = registerPage.getLastNameErrorMessage();
		sa.assertEquals(last_Name_Error_Mess, dataProp.getProperty("Last_Name_Error_Message"),"Last Name Error Message Not Shown");
		
//		String Email_Error_Mess = driver.findElement(By.xpath("//div[@class='text-danger' and contains(text(),'E-Mail')]")).getText();
		String Email_Error_Mess = registerPage.getEmailErrorMessage();
		sa.assertEquals(Email_Error_Mess, dataProp.getProperty("Email_Error_Message"),"E-Mail address Error Message Not Shown");
		
//		String telephone_Error_Mess = driver.findElement(By.xpath("//div[@class='text-danger' and contains(text(),'Telephone')]")).getText();
		String telephone_Error_Mess = registerPage.getTelephoneErrorMessage();
		sa.assertEquals(telephone_Error_Mess, dataProp.getProperty("TelePhone_NO_Error_Message"),"Telephone number Error Message Not Shown");
		
		
//		String password_Error_Mess = driver.findElement(By.xpath("//div[@class='text-danger' and contains(text(),'Password')]")).getText();
		String password_Error_Mess = registerPage.getPasswordErrorMessage();
		sa.assertEquals(password_Error_Mess, dataProp.getProperty("Password_Error_Message"),"Password field Error Message Not Shown");
		
		sa.assertAll();

	}
}
