package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.DriverFactory;
import base.TestContextSetup;
import configs.BrowserContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}

	private static final Logger log = LoggerFactory.getLogger(Hooks.class);

	@Before
	public void beforeScenario(Scenario scenario) throws IOException {
		log.info("===== STARTING SCENARIO: {} =====", scenario.getName());
		testContextSetup.initializeDriver();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver = DriverFactory.getDriver();
		if(scenario.isFailed())
		{
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", "image");
		}
	}

	@After
	public void afterScenario(Scenario scenario) throws IOException
	{
		log.info("===== ENDING SCENARIO: {} | STATUS: {} =====", scenario.getName(), scenario.getStatus());
		WebDriver driver = DriverFactory.getDriver();

		if(driver!=null)
		{
			driver.quit();
			DriverFactory.removeDriver();
		}
		BrowserContext.clear();
	}
}
