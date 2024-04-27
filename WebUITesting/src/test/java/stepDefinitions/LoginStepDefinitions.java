package stepDefinitions;

import org.openqa.selenium.WebDriver;

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
    }
    
    @Given("I launch the SauceLabs demo website")
    public void launchWebsite() throws Throwable {
        try {
            driver.get("https://www.saucedemo.com/");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }

    @When("I enter the username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        // Enter the username and password
        try {
            login_page.enterCredentials(username, password);
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }

    @When("I click on the Login button")
    public void clickLoginButton() {
        // Click on the Login button
        try {
            login_page.clickLoginButton();
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }

    @Then("I should view the login error message {string}")
    public void verifyErrorMessage(String errorMessage) {
        // Verify that an error message is displayed
        try {
            login_page.verifyErrorMessage(errorMessage);
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }
    
    @Then("I close the browser")
    public void closeBrowser() {
        // Close the browser
        selenium_utils.killDriver(driver);
    }
}