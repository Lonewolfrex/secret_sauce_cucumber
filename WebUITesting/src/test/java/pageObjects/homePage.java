package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

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
    private WebElement add_first_product_btn;
    private WebElement remove_first_product_btn;
    private List<WebElement> cart_product_count;

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
        add_first_product_btn = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        }

    // Verify products page
    public void verifyProductsPage() {
        initializeElements();
        String product_text_title = product_text.getText().toString();
        selenium_utils.assertText(driver, product_text_title, "Products", 3);
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
    
    public void addFirstProductToCart() {
    	initializeElements();
    	selenium_utils.clickElement(driver, add_first_product_btn, 3);
    }
    
    public void removeFirstProductFromCart() {
    	initializeElements();
    	remove_first_product_btn = driver.findElement(By.id("remove-sauce-labs-backpack"));
    	selenium_utils.clickElement(driver, remove_first_product_btn, 3);
    }
    
    public void validateProductCountInCart(String expected_count) {
    	initializeElements();
        cart_product_count = driver.findElements(By.xpath("//span[@class='shopping_cart_link']//span[@class='shopping_cart_badge']"));
    	String added_product_count = cart_product_count.get(0).getText().toString();
    	selenium_utils.assertText(driver, added_product_count, expected_count, 0);
    }
    
    public void validateEmptyCart() {
    	initializeElements();
        cart_product_count = driver.findElements(By.xpath("//span[@class='shopping_cart_link']//span[@class='shopping_cart_badge']"));
        if (cart_product_count.isEmpty()) {
            System.out.println("Cart is empty now.");
            Reporter.log("Cart is empty");
        } else {
            System.out.println("Failed: Cart is not empty");
            Reporter.log("Cart is not emptied.");
        }
    }
    
    public void logoutFromApplication() {
    	initializeElements();
    	selenium_utils.clickElement(driver, burger_icon, 5);
    	selenium_utils.clickElement(driver, logout_slider_btn, 5);
    }
    
}
