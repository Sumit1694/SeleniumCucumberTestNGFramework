package utils;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import base.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
	private static final Logger log = LoggerFactory.getLogger(TestBase.class);

	public WebDriver initializeDriver() throws IOException
	{
		log.info("Initializing browser: {}", ConfigReader.getBrowser());
		log.info("Navigating to URL: {}", ConfigReader.getUrl());

		if(DriverFactory.getDriver()==null)
		{
			WebDriver driver;
			String browser = ConfigReader.getBrowser();
			switch(browser.toLowerCase())
			{
			    case "chrome":
			        WebDriverManager.chromedriver().setup();
			        driver = new ChromeDriver(); break;

			    case "firefox":
			        WebDriverManager.firefoxdriver().setup();
			        driver = new FirefoxDriver(); break;

			    case "edge":
			        WebDriverManager.edgedriver().setup();
			        driver = new EdgeDriver(); break;

			    default: throw new RuntimeException("Unsupported browser: " + browser);
			}
			driver.manage().window().maximize();
			driver.get(ConfigReader.getUrl());
			DriverFactory.setDriver(driver);
		}
		return DriverFactory.getDriver();
	}
}