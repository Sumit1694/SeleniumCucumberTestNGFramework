package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {

	public WebDriver driver;
	String offersPageProductName;
	String landingPageProductName;
	TestContextSetup testContextSetup;
	OffersPage offersPage;
	LandingPage landingPage;

	public OffersPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.offersPage = testContextSetup.pageObjectManager.getOffersPage();
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	private static final Logger log = LoggerFactory.getLogger(OffersPageStepDefinitions.class);

	@Then("^user serached for (.+) shortname in offers page to check if product exist with same name$")
	public void user_serached_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
		log.info("user switching to offers page");
		switchToOffersPage();
		log.info("user searching item offerspage");
		offersPage.searchItem(shortName);
		log.info("user capturing product name!");
		offersPageProductName = offersPage.getProductName();
	}
	public void switchToOffersPage()
	{
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.SwitchToChildWindow();
	}

	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page()
	{
		log.info("user verifying product name is matching on landing and offersPage!");
		Assert.assertEquals(testContextSetup.landingPageProductName, offersPageProductName);
		testContextSetup.genericUtils.switchToParentWindow();
	}
}
