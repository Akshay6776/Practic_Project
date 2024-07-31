package com.TutorialNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
		
//	driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
//	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataProp.getProperty("valied_Product"));
//	driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
//	String search_Error_Message = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText();
	
	WebDriver driver;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement My_Accounts_Button;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement Login_Button;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	private WebElement register_Button;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement searchErrorMessage;

	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccounts() 
	{
		My_Accounts_Button.click();
	}
	
	public LoginPage clickOnLoginButton() 
	{
		Login_Button.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegisterButton() 
	{
		register_Button.click();
		return new RegisterPage(driver);
	}
	
	public void searchProduct(String productName) 
	{
		searchField.sendKeys(productName);
	}
	
	public SearchResultPage clickOnsearchButton() 
	{
		searchButton.click();
		return new SearchResultPage(driver);
	}
	
	public String getSearchErrorMessage() 
	{
		return searchErrorMessage.getText();
	}
	
	
}
