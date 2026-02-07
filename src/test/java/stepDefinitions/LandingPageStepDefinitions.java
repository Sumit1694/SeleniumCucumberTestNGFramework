package stepDefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {

	String offersPageProductName;
	String landingPageProductName;
	public LandingPage landingPage;
	TestContextSetup testContextSetup;

	public LandingPageStepDefinitions(TestContextSetup testContextSetup)
	{
        this.testContextSetup=testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	private static final Logger log = LoggerFactory.getLogger(LandingPageStepDefinitions.class);

	@Given("User is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
		log.info("User trying to get the title of landing page!");
       Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		log.info("User searching product on landing page");
		landingPage.searchItem(shortName);
		log.info("User capturting text of searched product!");
		testContextSetup.landingPageProductName = landingPage.getProductName(shortName).split("-")[0].trim();
        System.out.println("Product name is extracted: " + testContextSetup.landingPageProductName);
	}
	@When("Added {string} items of the selected product to cart")
	public void Added_items_of_selected_product_to_cart(String quantity)
	{
		log.info("user is incrementing quantity of product to add in the cart!");
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		log.info("user adding product to cart!");
		landingPage.addToCart();
	}
}
