package customMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class webdriver_factory {
	private static WebDriver driver;
	
    public static WebDriver createDriver() throws Throwable {
        if (driver == null) {
            String browser = config_reader.getBrowserType();
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chrome_options = new ChromeOptions();
                    chrome_options.setHeadless(false);
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                    driver = new ChromeDriver(chrome_options);
                    break;
                    
                case "firefox":
                	FirefoxOptions firefox_options = new FirefoxOptions();
                	firefox_options.setHeadless(false);
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                    driver = new FirefoxDriver(firefox_options);
                    break;
                    
                case "edge":
                    System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                    
                default:
                    throw new IllegalArgumentException("Invalid browser specified: " + browser);
            }
            selenium_utils.screen_maximize(driver);
        }
        return driver;
    }
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Set driver to null after quitting to prevent further usage
        }
    }
}
    

