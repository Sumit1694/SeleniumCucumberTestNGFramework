package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enums.WaitStrategy;
import utils.WaitUtils;

public class CheckoutPage {

	private static final Logger log = LoggerFactory.getLogger(CheckoutPage.class);
	private final WaitUtils waitUtils;


	public CheckoutPage(WaitUtils waitUtils)
	{
		this.waitUtils=waitUtils;
	}

	By cartBag = By.xpath("//div[@class='cart']/child::a[@class='cart-icon']/child::img");
	By checkoutButton = By.xpath("//div[@class='action-block']/child::button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn = By.xpath("//button[@class='promoBtn' and text()='Apply']");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

	public void CheckoutItems()
	{
		log.info("Clicking on cartBag!");
		waitUtils.waitForElement(cartBag, WaitStrategy.CLICKABLE).click();
		log.info("Clicking on checkoutButton!");
		waitUtils.waitForElement(checkoutButton, WaitStrategy.CLICKABLE).click();
	}

	public Boolean isPromoBtnDisplayed()
	{
		log.info("Verifying PromoBtn is displayed!");
		return waitUtils.waitForElement(promoBtn, WaitStrategy.VISIBLE).isDisplayed();
	}

	public Boolean isPlaceOrderDisplayed()
	{
		log.info("Verifying placeOrder is displayed!");
		return waitUtils.waitForElement(placeOrder, WaitStrategy.VISIBLE).isDisplayed();
	}
}