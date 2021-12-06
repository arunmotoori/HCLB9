package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

 
public class Loginusingclass {
    WebDriver driver;
    
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/");
    }
    
    @Test (priority=1)
    public void loginwidvalidcredential() {            //validcred
        
        
        driver.findElement(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.linkText("Login")).click();
        
        driver.findElement(By.id("input-email")).sendKeys("uui@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("uui");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        
        Assert.assertEquals(driver.findElement(By.linkText("Edit your account information")).isDisplayed(), true);

        }
    
    @Test(priority=2)
    public void loginwidinvalidcredential() {                    //invalidcred
        
        driver.findElement(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.cssSelector("li[class='dropdown open'] li:nth-child(5) a:nth-child(1)")).click();
        
        driver.findElement(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.linkText("Login")).click();
        
        driver.findElement(By.id("input-email")).sendKeys("uuiyy@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("uuig");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).getText().contains(" Warning: No match for E-Mail Address and/or Password."));
        
        }
    
    
    @AfterClass        //after evry test case after method will process 
    public void tearDown() {
        driver.quit();
    }

 

}