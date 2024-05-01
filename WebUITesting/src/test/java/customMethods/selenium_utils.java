// SeleniumUtils.java
package customMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class selenium_utils {
    
    public static boolean isElementReady(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void clickElement(WebDriver driver, WebElement element, int timeoutInSeconds) {
        if (isElementReady(driver, element, timeoutInSeconds)) {
            element.click();
        } else {
            System.err.println("Element not ready or not found.");
            driver.quit();
            throw new RuntimeException("Element not ready or not found.");
        }
    }
    
    // fillField method
    public static void fillField(WebDriver driver, WebElement element, String text, int timeoutInSeconds) {
        if (isElementReady(driver, element, timeoutInSeconds)) {
            element.clear();
            element.sendKeys(text);
        } else {
            System.err.println("Element not ready or not found.");
            driver.quit();
            throw new RuntimeException("Element not ready or not found.");
        }
    }

    public static void waitForElement(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void assertText(WebDriver driver, String actualText, String expectedText, int timeoutInSeconds) {
        Assert.assertEquals(actualText, expectedText);
    }

    public static void killDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public static void closeBrowser(WebDriver driver) {
        if (driver != null) {
            driver.close();
        }
    }

    public static void screen_maximize(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void select_dropdown(WebDriver driver, WebElement element, String text) {
        if(isElementReady(driver, element, 5)) {
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(text);
        }
    }

    public static boolean compareLists(List<String> list1, List<String> list2) {
        return list1.equals(list2);
    }
    
    public static void report_logger(String log_comments) {
    	Reporter.log(log_comments);
    }
}
