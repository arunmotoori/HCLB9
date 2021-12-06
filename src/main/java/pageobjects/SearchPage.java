package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name="search")
	WebElement searchBox;
	
    @FindBy(css="button[class='btn btn-default btn-lg']")
	WebElement searchButton;
    
    @FindBy(linkText="HP LP3065")
    WebElement searchProduct;
    
    @FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
    WebElement noSuchProductMessage;
    
    public void enterProductNameIntoSearchBoxField(String productName) {
    	
    	searchBox.sendKeys(productName);
    	
    }
    
    public void clickSearchButton() {
    	
    	searchButton.click();
    	
    }
    
    public boolean verifyThePresenceOfProductInSearchResults() {
    	
    	boolean displayStatus = searchProduct.isDisplayed();
    	
    	return displayStatus;
    	
    }
    
    public boolean verifyThePresenceOfNoProductMessage() {
    	
    	boolean displayStatus = noSuchProductMessage.isDisplayed();
    	
    	return displayStatus;
    	
    }

}
