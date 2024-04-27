package stepDefinitions;

import org.openqa.selenium.WebDriver;

import customMethods.selenium_utils;
import customMethods.webdriver_factory;
import io.cucumber.java.en.Then;
import pageObjects.homePage;
import pageObjects.loginPage;

public class HomePageStepDefinitions {
	
    private WebDriver driver;
    private homePage home_page;
    private loginPage login_page;
	
    public HomePageStepDefinitions() throws Throwable {
        try {
        	this.driver = webdriver_factory.createDriver();
            login_page = new loginPage(driver);
            home_page = new homePage(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Then("I should be logged in successfully")
    public void verifySuccessfulLoginToProductsPage() {
        // Verify that the products page is displayed
        try {
            home_page.verifyProductsPage();
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }

    @Then("I should be able to sort the displayed products by name A-Z")
    public void sortDisplayedProductsByNameInAscendingOrder() {
        try {
            home_page.checkSortedProductsByName("Name (A to Z)");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        };
    }
    @Then("I should be able to sort the displayed products by name Z-A")
    public void sortDisplayedProductsByNameInDescendingOrder() {
        try {
            home_page.checkSortedProductsByName("Name (Z to A)");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        };
    }
    @Then("I should be able to sort the displayed products by price low to high")
    public void sortDisplayedProductsByPriceInAscendingOrder() {
        try {
            home_page.checkSortedProductsByPrice("Price (low to high)");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        };
    }
    @Then("I should be able to sort the displayed products by price high to low")
    public void sortDisplayedProductsByPriceInDescendingOrder() {
        try {
            home_page.checkSortedProductsByPrice("Price (high to low)");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        };
    }
    @Then("I should be able to log out from the application")
    public void logoutFromApplication() {
        try {
            home_page.logoutFromApplication();
            login_page.verifyNavigationToLoginPage();
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        };    	
    }
    
    
}
