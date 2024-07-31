package com.TutorialNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
	
	WebDriver driver;
	
	public AccountsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@id='content']/h2)[1]")
	private WebElement my_Account_Title;
	
	public String getMyAccount_Title() 
	{
		return my_Account_Title.getText();
	}

}
