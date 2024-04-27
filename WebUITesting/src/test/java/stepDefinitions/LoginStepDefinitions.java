package stepDefinitions;

import org.openqa.selenium.WebDriver;

import customMethods.selenium_utils;
import customMethods.webdriver_factory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.loginPage;

public class LoginStepDefinitions {
	
    private WebDriver driver;
    private loginPage login_page;
    
    public LoginStepDefinitions() throws Throwable {
        try {
        	this.driver = webdriver_factory.createDriver();
            login_page = new loginPage(driver);
            new homePage(driver);
        } catch (Exception e) {
            e.printStackTrace();
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
