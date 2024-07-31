package com.TutorialNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(utils.generateRandomUsername());
//	driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(utils.generateRandomUsername());
//	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(utils.generateRandomUsername()+"@gamil.com");
//	driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(utils.generateRandom10DigitNumber());
//	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("valiedPassword"));
//	driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("valiedPassword"));
//	driver.findElement(By.xpath("//input[@name='agree']")).click();
//	driver.findElement(By.xpath("//input[@value='Continue']")).click();
//	driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
//	String Email_Already_Exists_Warning_Message = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
//	String privacy_Policy_Error_Mess = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
//	String first_Name_Error_Mess = driver.findElement(By.xpath("//div[@class='text-danger' and contains(text(),'First Name')]")).getText();
//	String last_Name_Error_Mess = driver.findElement(By.xpath("//div[@class='text-danger' and contains(text(),'Last Name')]")).getText();
//	String Email_Error_Mess = driver.findElement(By.xpath("//div[@class='text-danger' and contains(text(),'E-Mail')]")).getText();
//	String telephone_Error_Mess = driver.findElement(By.xpath("//div[@class='text-danger' and contains(text(),'Telephone')]")).getText();
//	String password_Error_Mess = driver.findElement(By.xpath("//div[@class='text-danger' and contains(text(),'Password')]")).getText();
	
	
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstNameField;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement EmailField;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephoneField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmpasswordField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicyAgreeField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	private WebElement NewsLetterradiobutton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement EmailAlreadyExistsWarningMessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyErrorMess;
	
	@FindBy(xpath="//div[@class='text-danger' and contains(text(),'First Name')]")
	private WebElement firstNameErrorMess;
	
	@FindBy(xpath="//div[@class='text-danger' and contains(text(),'Last Name')]")
	private WebElement lastNameErrorMessage;
	
	@FindBy(xpath="//div[@class='text-danger' and contains(text(),'E-Mail')]")
	private WebElement EmailErrorMess;
	
	@FindBy(xpath="//div[@class='text-danger' and contains(text(),'Telephone')]")
	private WebElement TelephoneErrorMess;
	
	@FindBy(xpath="//div[@class='text-danger' and contains(text(),'Password')]")
	private WebElement passwordErrorMessage;
	
	
	public void enterAllCredintils(String first_Name,String last_Name,String e_mail,String telephone,String password) 
	{
		firstNameField.sendKeys(first_Name);
		lastNameField.sendKeys(last_Name);
		EmailField.sendKeys(e_mail);
		telephoneField.sendKeys(telephone);
		passwordField.sendKeys(password);
		confirmpasswordField.sendKeys(password);
	}
	
	public void clickYesNewsLetter() 
	{
		NewsLetterradiobutton.click();
	}
	
	public void clickAgreePrivacyPolicy() 
	{
		privacyPolicyAgreeField.click();
	}
	
	public AccountSuccessPage clickContinueButton() 
	{
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public String getEmailAlreadyExistErrorMessage() 
	{
		return EmailAlreadyExistsWarningMessage.getText();
	}
	
	public String getPrivacyPolicyAllertMessage() 
	{
		return privacyPolicyErrorMess.getText();
	}
	
	public String getFirstNameErrorMessage() 
	{
		return firstNameErrorMess.getText();
	}
	
	public String getLastNameErrorMessage() 
	{
		return lastNameErrorMessage.getText();
	}
	
	public String getEmailErrorMessage() 
	{
		return EmailErrorMess.getText();
	}
	
	public String getTelephoneErrorMessage() 
	{
		return TelephoneErrorMess.getText();
	}
	
	public String getPasswordErrorMessage() 
	{
		return passwordErrorMessage.getText();
	}
	
}
