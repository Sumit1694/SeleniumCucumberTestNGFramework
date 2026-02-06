package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {

	public WebDriver driver;
	String offersPageProductName;
	String landingPageProductName;
	TestContextSetup testContextSetup;
	CheckoutPage checkoutPage;

	public CheckoutPageStepDefinitions(TestContextSetup testContextSetup)
	{
        this.testContextSetup=testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	private static final Logger log = LoggerFactory.getLogger(CheckoutPageStepDefinitions.class);

	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place()
	{
		log.info("user is able to see promoBtn and placeOrder!");
        Assert.assertTrue(checkoutPage.isPromoBtnDisplayed());
        Assert.assertTrue(checkoutPage.isPlaceOrderDisplayed());
	}

	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void User_has_ability_to_checkout_and_validate(String name) throws InterruptedException
	{
		log.info("checking items!");
        checkoutPage.CheckoutItems();
	}

}
