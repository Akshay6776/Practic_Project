package com.TutorialNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
//	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Email);
//	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(Password);
//	driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
//	String My_Accounts = driver.findElement(By.xpath("(//div[@id='content']/h2)[1]")).getText();
//	String warningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement EmailField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement PasswordField;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement LoginButton;
	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement WarningMessage;
	
	
	
	public void enterEmail(String Email) 
	{
		EmailField.sendKeys(Email);
	}
	
	public void enterPassword(String password) 
	{
		PasswordField.sendKeys(password);
	}
	
	public AccountsPage clickOnLoginButton() 
	{
		LoginButton.click();
		return new AccountsPage(driver);
	}


	public String getLoginErrorMessage() 
	{
		return WarningMessage.getText();
	}
}
