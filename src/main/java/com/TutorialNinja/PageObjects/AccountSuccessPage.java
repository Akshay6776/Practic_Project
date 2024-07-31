package com.TutorialNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	
	WebDriver driver;
	
	public AccountSuccessPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	String acc_Creation_Success_Mess = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement acc_Creation_Success_Message;
	
	public String getSuccessMessage() 
	{
		return acc_Creation_Success_Message.getText();
	}
	
}
