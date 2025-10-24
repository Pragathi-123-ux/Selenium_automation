package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipField = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserDetails(String fname, String lname, String zip) {
        driver.findElement(firstNameField).sendKeys(fname);
        driver.findElement(lastNameField).sendKeys(lname);
        driver.findElement(zipField).sendKeys(zip);
    }

    public void continueCheckout() {
        driver.findElement(continueBtn).click();
    }

    public void finishOrder() {
        // ✅ Add explicit wait to ensure the button is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        finishButton.click();
    }
}