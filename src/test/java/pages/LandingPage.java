package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enums.WaitStrategy;
import utils.DriverUtils;
import utils.WaitUtils;

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
	private By productsearchAppeared = By.xpath("//div[@class='product']");
	private By quantityInCart = By.xpath("//div[contains(@class,'cart-preview')]//div[@class='product-total']/child::p[@class='quantity']");
	private By cartBag = By.xpath("//img[@alt='Cart']");

	public void searchItem(String name)
	{
		log.info("Searching product with name: {}", name);
		waitUtils.waitForElement(search, WaitStrategy.VISIBLE).sendKeys(name);
	}

	public void incrementQuantity(int quantity) {
		log.info("Incrementing quantity of searched product: " + quantity);

		// Wait until the product appears
		waitUtils.waitForElement(productsearchAppeared, WaitStrategy.VISIBLE).isDisplayed();

		int i = quantity - 1;

		while (i > 0) {
			boolean clicked = false;
			int attempts = 0;

			// Retry clicking the increment button if StaleElementReferenceException occurs
			while (!clicked && attempts < 3) {
				try {
					waitUtils.waitForElement(increment, WaitStrategy.CLICKABLE).click();
					clicked = true; // success
				} catch (StaleElementReferenceException e) {
					log.warn("StaleElementReferenceException caught. Retrying click... Attempt: " + (attempts + 1));
				}
				attempts++;
			}

			if (!clicked) {
				log.error("Failed to click increment button after 3 attempts.");
				throw new RuntimeException("Unable to increment product quantity due to stale element.");
			}

			i--;
		}
	}

	public void clickCartBag()
	{
		waitUtils.waitForElement(cartBag, WaitStrategy.VISIBLE).click();;
	}

	public String getQuantityAddedInCart()
	{
		return waitUtils.waitForElement(quantityInCart, WaitStrategy.VISIBLE).getText().split(" ")[0].trim();
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

	public void clearSearchField() {
		log.info("Clearing search field");
		waitUtils.waitForElement(search, WaitStrategy.VISIBLE).clear();
		waitUtils.waitForElement(productName, WaitStrategy.VISIBLE);
	}
}
