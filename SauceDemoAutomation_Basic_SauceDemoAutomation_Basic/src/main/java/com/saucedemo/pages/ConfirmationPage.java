package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    private WebDriver driver;
    private By confirmationMsg = By.className("complete-header");
    private By menuBtn = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMsg).getText();
    }

    public void logout() {
        driver.findElement(menuBtn).click();
        driver.findElement(logoutLink).click();
    }
}
