package stepDefinitions;

import org.openqa.selenium.WebDriver;
import customMethods.custom_logger;
import customMethods.selenium_utils;
import customMethods.webdriver_factory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.loginPage;

public class LoginStepDefinitions extends BaseStepDefinitions {
    
    private WebDriver driver;
    private loginPage login_page;
    private homePage home_page;
    
    @Before
    public void setUp() throws Throwable {
        driver = webdriver_factory.createDriver();
        login_page = new loginPage(driver);
        home_page = new homePage(driver);
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            selenium_utils.killDriver(driver);
        }
        custom_logger.flush();
    }
    
    @Given("I launch the SauceLabs demo website")
    public void launchWebsite() throws Throwable {
        try {
        	custom_logger.log("Feature File Step:I launch the SauceLabs demo website");
            driver.get("https://www.saucedemo.com/");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }

    @When("I enter the username {string} and password {string}")
    public void enterCredentials(String username, String password) {
    	custom_logger.log("Feature File Step:I enter the username "+username+" and password "+password);
        try {
            login_page.enterCredentials(username, password);
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }

    @When("I click on the Login button")
    public void clickLoginButton() {
    	custom_logger.log("Feature File Step:I click on the Login button");
        try {
            login_page.clickLoginButton();
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }

    @Then("I should view the login error message {string}")
    public void verifyErrorMessage(String errorMessage) {
    	custom_logger.log("Feature File Step:I should view the login error message "+errorMessage);
        try {
            login_page.verifyErrorMessage(errorMessage);
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }
    
    @Then("I close the browser")
    public void closeBrowser() {
    	custom_logger.log("Feature File Step:I close the browser");
        selenium_utils.killDriver(driver);
    }
}