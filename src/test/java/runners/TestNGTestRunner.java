package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features",glue="stepDefinitions",monochrome=true,
dryRun=false,tags = "@PlaceOrder or @CheckoutPage or @OffersPage", plugin= {"html:target/cucumber.html","json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	//Enable only when need to run from xml
	/*@BeforeTest(alwaysRun = true)
	@Parameters("browser")
	public void setBrowser(@Optional String browser) {

		System.out.println(">>> Setting browser for thread: " + browser);

		if (browser != null) {
			BrowserContext.setBrowser(browser);
		}
	}*/

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}