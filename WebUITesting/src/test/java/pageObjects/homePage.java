package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import customMethods.selenium_utils;
import java.util.ArrayList;
import java.util.List;

public class homePage {
    private WebDriver driver;
    private WebElement product_text;
    private WebElement sort_products_by;
    private List<WebElement> displayed_products;
    private List<WebElement> displayed_products_price;
    private WebElement burger_icon;
    private WebElement logout_slider_btn;

    // Constructor    
    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    // Lazily initialize web elements
    private void initializeElements() {
        product_text = driver.findElement(By.xpath("//span[@class='title' and text()='Products']"));
        sort_products_by = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        displayed_products = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        displayed_products_price = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        burger_icon = driver.findElement(By.id("react-burger-menu-btn"));
        logout_slider_btn = driver.findElement(By.id("logout_sidebar_link"));
        
    }

    // Verify products page
    public void verifyProductsPage() {
        initializeElements();
        String product_text_title = product_text.getText().toString();
        selenium_utils.assertText(driver, product_text_title, "Products", 0);
    }

    public void sortProducts(String sort_by) {
        initializeElements();
        selenium_utils.select_dropdown(driver, sort_products_by, sort_by);
    }

    public <WebElements> List<String> getDisplayedProducts(WebElements wb) {
        initializeElements();
        List<String> products = new ArrayList<>();
        for (WebElement product : displayed_products) {
            products.add(product.getText().toString());
            System.out.println(product.getText().toString());
        }
        return products;
    }

    public void checkSortedProductsByName(String sort_by){
        initializeElements();
        List<String> before_sort_products = getDisplayedProducts(displayed_products);
        
        sortProducts(sort_by);
        List<String> after_sort_products = getDisplayedProducts(displayed_products);
        if(selenium_utils.compareLists(before_sort_products, after_sort_products) == true) {
            System.out.println("Success: Products are sorted successfully");
        } else {
            System.out.println("Failed: Products are not sorted successfully");
        }
    }
    
    public void checkSortedProductsByPrice(String sort_by){
        initializeElements();
        List<String> before_sort_products = getDisplayedProducts(displayed_products_price);
        sortProducts(sort_by);
        List<String> after_sort_products = getDisplayedProducts(displayed_products);
        if(selenium_utils.compareLists(before_sort_products, after_sort_products) == true) {
            System.out.println("Success: Products are sorted successfully");
        } else {
            System.out.println("Failed: Products are not sorted successfully");
        }
    }
    
    public void logoutFromApplication() {
    	initializeElements();
    	selenium_utils.clickElement(driver, burger_icon, 0);
    	selenium_utils.clickElement(driver, logout_slider_btn, 0);
    }
    
}
