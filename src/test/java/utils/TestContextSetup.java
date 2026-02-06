package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public WaitUtils waitUtils;
	public String landingPageProductName;

	public TestContextSetup()
	{
		testBase = new TestBase();
	}

	public void initializeDriver() throws IOException
	{
		driver = testBase.initializeDriver();
		pageObjectManager = new PageObjectManager();
		waitUtils = new WaitUtils();
		genericUtils = new GenericUtils(driver);
	}

}
