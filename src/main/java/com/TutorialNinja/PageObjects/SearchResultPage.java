package com.TutorialNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	WebDriver driver;
	
	public SearchResultPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']")).isDisplayed()
	
	@FindBy(xpath="//a[normalize-space()='HP LP3065']")
	private WebElement product;
	
	
	public boolean verifyTheProductIsDisplayed() 
	{
		return product.isDisplayed();
	}
	
	
	
}
