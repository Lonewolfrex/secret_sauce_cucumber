package stepDefinitions;

import org.openqa.selenium.WebDriver;

import customMethods.selenium_utils;
import customMethods.webdriver_factory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseStepDefinitions {
    protected WebDriver driver;

    @Before
    public void setUp() throws Throwable {
        driver = webdriver_factory.createDriver();
    }

    @After
    public void tearDown() {
    	webdriver_factory.quitDriver();
    }
}