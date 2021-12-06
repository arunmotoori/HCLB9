package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css="a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")
	WebElement myAccount;
	
	@FindBy(linkText="Login")
	WebElement loginOption;
	
	public void clickOnMyAccount() {
		
		myAccount.click();
		
	}
	
	public void selectLoginOption() {
		
		loginOption.click();
		
	}
	
}
