package runners;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import configs.BrowserContext;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenarios.txt",glue="stepDefinitions",monochrome=true,dryRun=false,
plugin= {"html:target/cucumber.html","json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedTestRunner extends AbstractTestNGCucumberTests {

	@BeforeTest(alwaysRun = true)
    @Parameters("browser")
    public void setBrowser(@Optional String browser) {

        System.out.println(">>> Setting browser for thread: " + browser);

        if (browser != null) {
            BrowserContext.setBrowser(browser);
        }
    }

	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
