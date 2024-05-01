package testRunners;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import customMethods.config_reader;
@CucumberOptions(
    features = {
    		"src/test/resources/features/HomePage.feature",
//    		"src/test/resources/features/Login.feature",
    		}, // Path to your feature files
    glue = {"stepDefinitions"},    // Package where your step definitions are located
    plugin = {"pretty", "html:target/cucumber-reports"} // Report generation options (optional)
)

public class TestRunner extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeTest
	@Parameters({ "browser" })
	public void defineBrowser(String browser) throws Throwable {
		config_reader.setBrowserType(browser);
	}
}
