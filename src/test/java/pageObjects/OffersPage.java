package pageObjects;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.WaitStrategy;
import utils.WaitUtils;

public class OffersPage {

	private final WaitUtils waitUtils;
	private static final Logger log = LoggerFactory.getLogger(OffersPage.class);

	public OffersPage(WaitUtils waitUtils)
	{
		this.waitUtils=waitUtils;
	}

	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("tr td:nth-child(1)");

	public void searchItem(String name)
	{
		log.info("Entering product name into search field!");
		waitUtils.waitForElement(search, WaitStrategy.VISIBLE).sendKeys(name);
	}

	public void getSearchText()
	{
		log.info("capturing search appeared text!");
		waitUtils.waitForElement(search, WaitStrategy.VISIBLE).getText();
	}

	public String getProductName()
	{
		log.info("capturing productName text!");
		return waitUtils.waitForElement(productName, WaitStrategy.VISIBLE).getText();
	}
}
