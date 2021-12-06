package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public Properties prop = null;
	
	public WebDriver initializeBrowser() throws IOException {
		
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream(new File("./src/main/java/resources/data.properties"));
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();		
			driver = new EdgeDriver();
			
		}else if(browserName.equalsIgnoreCase("opera")) {
			
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
	}

	public String takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		FileHandler.copy(srcFile,new File(destFilePath));
		return destFilePath;
		
	}
	
}
