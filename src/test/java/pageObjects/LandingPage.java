package pageObjects;

import org.openqa.selenium.By;
import utils.DriverUtils;
import utils.WaitStrategy;
import utils.WaitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LandingPage {

	private static final Logger log = LoggerFactory.getLogger(LandingPage.class);
	private final WaitUtils waitUtils;

	public LandingPage(WaitUtils waitUtils)
	{
		this.waitUtils=waitUtils;
	}

	private By search = By.xpath("//input[@class='search-keyword']");
	private	By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.linkText("Top Deals");
	private By increment = By.xpath("//div[@class='stepper-input']/descendant::a[@class='increment']");
	private By addToCart = By.xpath("//div[@class='product-action']/child::button");

	public void searchItem(String name)
	{
		log.info("Searching product with name: {}", name);
		waitUtils.waitForElement(search, WaitStrategy.VISIBLE).sendKeys(name);
	}

	public void incrementQuantity(int quantity)
	{
		log.info("incrementing quantity of searched product: " + quantity);
		int i=quantity-1;
		while(i>0)
		{
			waitUtils.waitForElement(increment, WaitStrategy.CLICKABLE).click();
			i--;
		}
	}

	public void addToCart()
	{
		log.info("Adding product to cart!");
		waitUtils.waitForElement(addToCart, WaitStrategy.CLICKABLE).click();
	}

	public String getProductName(String expectedName)
	{
		log.info("Getting text of searched product!");
		return waitUtils.waitForText(productName, expectedName);
	}

	public void selectTopDealsPage()
	{
		log.info("Opening topDeals page!");
		waitUtils.waitForElement(topDeals, WaitStrategy.CLICKABLE).click();
	}

	public String getTitleLandingPage()
	{
		log.info("Getting title of LandingPage!");
		return DriverUtils.getTitle();
	}
}
