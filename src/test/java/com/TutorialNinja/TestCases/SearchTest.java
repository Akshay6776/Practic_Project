package com.TutorialNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TutorialNinja.PageObjects.HomePage;
import com.TutorialNinja.PageObjects.SearchResultPage;
import com.TutorialsNinja.Base.Base;

public class SearchTest extends Base{
	
	public WebDriver driver;
	HomePage homePage;
	SearchResultPage searchResultPage;
	
	@BeforeMethod
	public void getToSearch() 
	{
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homePage = new HomePage(driver);
	}
	
	@Test(priority = 0)
	public void verifySearchingWithExistingProductName() 
	{
//		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataProp.getProperty("valied_Product"));
//		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		homePage.searchProduct(dataProp.getProperty("valied_Product"));
		searchResultPage = homePage.clickOnsearchButton();
		
		Assert.assertTrue(searchResultPage.verifyTheProductIsDisplayed(),"Product name is not Displayed");
	}

	@Test(priority = 1)
	public void verifySearchingWithNonExistingProductName() 
	{
//		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataProp.getProperty("Invalied_Product"));
//		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		homePage.searchProduct(dataProp.getProperty("Invalied_Product"));
		homePage.clickOnsearchButton();
		
//		String search_Error_Message = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText();
		String search_Error_Message = homePage.getSearchErrorMessage();
		Assert.assertEquals(search_Error_Message, dataProp.getProperty("search_Product_Error_Message"),"Search Error Message not Displayed");
	
	}
	
	@Test(priority = 2)
	public void verifySearchingWithoutGivingAnyProductName() 
	{
//		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		homePage.clickOnsearchButton();
		
//		String search_Error_Message = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText();
		String search_Error_Message = homePage.getSearchErrorMessage();
		Assert.assertEquals(search_Error_Message, dataProp.getProperty("search_Product_Error_Message"),"Search Error Message not Displayed");
	
	}
	
}
