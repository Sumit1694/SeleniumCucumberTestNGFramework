package base;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import configs.ConfigReader;
import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
	private static final Logger log = LoggerFactory.getLogger(TestBase.class);

	public WebDriver initializeDriver() throws IOException {
	    BrowserType browser = ConfigReader.getBrowserType();
	    log.info("Initializing browser: {}", browser);
	    log.info("Navigating to URL: {}", ConfigReader.getUrl());

	    if (DriverFactory.getDriver() == null) {
	        WebDriver driver;
	        switch (browser) {
	            case CHROME:
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();
	                break;

	            case FIREFOX:
	                WebDriverManager.firefoxdriver().setup();
	                driver = new FirefoxDriver();
	                break;

	            case EDGE:
	                WebDriverManager.edgedriver().setup();
	                driver = new EdgeDriver();
	                break;

	            default:
	                throw new RuntimeException("Unsupported browser: " + browser);
	        }

	        driver.manage().window().maximize();
	        driver.get(ConfigReader.getUrl());
	        DriverFactory.setDriver(driver);
	    }
	    return DriverFactory.getDriver();
	}

}