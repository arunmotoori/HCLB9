package tests;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	public WebDriver driver = null;

	HomePage homePage = null;
	LoginPage loginPage = null;
	
	@Test(priority=1)
	public void loginWithValidCredentials() {
		
		homePage = new HomePage(driver);
		
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		
		loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickLoginButton();
		
		AccountPage accountPage = new AccountPage(driver);
		
		Assert.assertEquals(accountPage.verifyThePresenceOfEditYourAccountInformationLink(),false);
		
	}
	
	@Test(priority=2)
	public void loginWithInvalidUsernameAndInvalidPassword() {
		
		homePage = new HomePage(driver);
		
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		
		loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddress("amotoorihclabc"+getTimeStamp()+"@gmail.com");
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}
	
	@Test(priority=3)
	public void loginWithInvalidUsernameAndValidPassword() {
		
		homePage = new HomePage(driver);
		
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddress("amotoorihclabc"+getTimeStamp()+"@gmail.com");
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}
	
	@Test(priority=4)
	public void loginWithValidUsernameAndInvalidPassword() {
		
		homePage = new HomePage(driver);
		
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		
		loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
		
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
	
	public String getTimeStamp() {
		
		Date date = new Date();
		
		String dateString = date.toString(); 
		
		String timeStamp = dateString.replace(" ","_").replace(":","_");
		
		return timeStamp;
		
	}

}
