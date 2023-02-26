package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException
	{
		Properties prop= new Properties();
		String projectpath=System.getProperty("user.dir");
		FileInputStream fis= new FileInputStream(projectpath+"\\src\\test\\resources\\global.properties");
		prop.load(fis);
		
		String url=prop.getProperty("QAUrl");
		if(driver==null) 
		{
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
			if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		driver.get(url);
	}
	return driver;
	}
		
	

	}
	



