package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import customMethods.selenium_utils;

public class loginPage {
    private WebDriver driver;

    // Web elements
    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement errorMessage;

    // Constructor
    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Initialize web elements lazily
    private void initializeElements() {
        usernameField = driver.findElement(By.id("user-name"));
        passwordField = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.id("login-button"));
        errorMessage = driver.findElement(By.className("error-message-container"));
    }

    // Enter Credentials
    public void enterCredentials(String username, String password) {
        initializeElements(); // Initialize elements when needed
        selenium_utils.fillField(driver, usernameField, username, 0);
        selenium_utils.fillField(driver, passwordField, password, 0);
    }

    // Click on login button
    public void clickLoginButton() {
        initializeElements(); // Initialize elements when needed
        selenium_utils.clickElement(driver, loginButton, 0);
    }

    // Get error message text
    public void verifyErrorMessage(String login_errorMsg) {
        initializeElements(); // Initialize elements when needed
        selenium_utils.assertText(driver, errorMessage.getText().toString(), login_errorMsg, 2);
    }
    
    public void verifyNavigationToLoginPage() {
    	initializeElements();
    	selenium_utils.isElementReady(driver, usernameField, 0);
    }
}
