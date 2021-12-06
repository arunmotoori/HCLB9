package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.SearchPage;
import resources.Base;

public class SearchTest extends Base {
	
	public WebDriver driver = null;

	SearchPage searchPage = null;
	
	@Test
	public void searchForAnExistingProduct() {
		
		searchPage = new SearchPage(driver);
		
		searchPage.enterProductNameIntoSearchBoxField(prop.getProperty("existingProduct"));
		searchPage.clickSearchButton();
		
		Assert.assertTrue(searchPage.verifyThePresenceOfProductInSearchResults());
		
	}
	
	@Test
	public void searchForANonExistingProduct() {
		
		searchPage = new SearchPage(driver);
		
		searchPage.enterProductNameIntoSearchBoxField(prop.getProperty("nonExistingProduct"));
		searchPage.clickSearchButton();
		
		Assert.assertTrue(searchPage.verifyThePresenceOfNoProductMessage());
		
	}
	
	
	@BeforeMethod
	public void setup() throws IOException {
		
		driver = initializeBrowser();
		
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}
