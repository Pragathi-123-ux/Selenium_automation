package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;

    private By product1 = By.id("add-to-cart-sauce-labs-backpack");
    private By product2 = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsPageDisplayed() {
        return driver.getTitle().contains("Swag Labs");
    }

    public void addProductsToCart() {
        driver.findElement(product1).click();
        driver.findElement(product2).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}
