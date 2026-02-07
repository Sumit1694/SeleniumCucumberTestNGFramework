package stepDefinitions;

import org.testng.Assert;

import base.TestContextSetup;
import io.cucumber.java.en.Then;
import pages.CheckoutPage;

public class CheckoutPageStepDefinitions {

	CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;

	public CheckoutPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_enter_promo_code_and_place_order()
	{
		Assert.assertTrue(checkoutPage.isPromoBtnDisplayed());
		Assert.assertTrue(checkoutPage.isPlaceOrderDisplayed());
	}

	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) throws InterruptedException
	{
		checkoutPage.CheckoutItems();
	}
}