package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
    public LoginPage(WebDriver driver) {
    	
    	this.driver = driver;
    	
    	PageFactory.initElements(driver,this);
    	
    }
    
    @FindBy(id="input-email")
    WebElement emailAddress;
    
    @FindBy(id="input-password")
    WebElement passwordField;
    
    @FindBy(css="input[value='Login']")
    WebElement loginButton;
    
    @FindBy(css=".alert.alert-danger.alert-dismissible")
    WebElement warning;
    
    public void enterEmailAddress(String email) {
    	
    	emailAddress.sendKeys(email);
    	
    }
    
    
    public void enterPassword(String password) {
    	
    	passwordField.sendKeys(password);
    	
    }
    
    public void clickLoginButton() {
    	
    	loginButton.click();
    	
    }
    
    public String getWarningMessageText() {
    	
    	String warningText = warning.getText();
    	
    	return warningText;
    	
    }

}
