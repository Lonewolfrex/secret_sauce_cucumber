package stepDefinitions;

import org.openqa.selenium.WebDriver;

import customMethods.custom_logger;
import customMethods.selenium_utils;
import customMethods.webdriver_factory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.homePage;
import pageObjects.loginPage;

public class HomePageStepDefinitions extends BaseStepDefinitions {
    
    private WebDriver driver;
    private homePage home_page;
    private loginPage login_page;
    
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
    
    @Then("I should be logged in successfully")
    public void verifySuccessfulLoginToProductsPage() {
    	custom_logger.log("Feature File Step:I should be logged in successfully");
        try {
            home_page.verifyProductsPage();
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }

    @Then("I should be able to sort the displayed products by name A-Z")
    public void sortDisplayedProductsByNameInAscendingOrder() {
    	custom_logger.log("Feature File Step:I should be able to sort the displayed products by name A-Z");
        try {
            home_page.checkSortedProductsByName("Name (A to Z)");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }
    
    @Then("I should be able to sort the displayed products by name Z-A")
    public void sortDisplayedProductsByNameInDescendingOrder() {
    	custom_logger.log("Feature File Step:I should be able to sort the displayed products by name Z-A");
        try {
            home_page.checkSortedProductsByName("Name (Z to A)");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }
    
    @Then("I should be able to sort the displayed products by price low to high")
    public void sortDisplayedProductsByPriceInAscendingOrder() {
    	custom_logger.log("Feature File Step:I should be able to sort the displayed products by price low to high");
        try {
            home_page.checkSortedProductsByPrice("Price (low to high)");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }
    
    @Then("I should be able to sort the displayed products by price high to low")
    public void sortDisplayedProductsByPriceInDescendingOrder() {
    	custom_logger.log("Feature File Step:I should be able to sort the displayed products by price high to low");
        try {
            home_page.checkSortedProductsByPrice("Price (high to low)");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }
    
    @Then("I should be able to click on Add to Cart button of a product")
    public void addProductToCart() {
    	custom_logger.log("Feature File Step:I should be able to click on Add to Cart button of a product");
        try {
            home_page.checkSortedProductsByPrice("Price (high to low)");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }
    
    @And("I should be able to see the count on the cart icon as one")
    public void verifyAddedProductCountInCart() {
    	custom_logger.log("Feature File Step:I should be able to see the count on the cart icon as one");
        try {
            home_page.validateProductCountInCart("1");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }
    
    @Then("I should be able to remove the product from Cart")
    public void removeProductFromCart() {
    	custom_logger.log("Feature File Step:I should be able to remove the product from Cart");
        try {
            home_page.checkSortedProductsByPrice("Price (high to low)");
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }
    
    @And("I should be able to see the count on the cart icon as zero")
    public void verifyZeroAddedProductCountInCart() {
    	custom_logger.log("Feature File Step:I should be able to see the count on the cart icon as zero");
        try {
            home_page.validateEmptyCart();
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }   
    
    @Then("I should be able to log out from the application")
    public void logoutFromApplication() {
        try {
        	custom_logger.log("Feature File Step:I should be able to log out from the application");
            home_page.logoutFromApplication();
            login_page.verifyNavigationToLoginPage();
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }  
}