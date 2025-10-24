package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.*;
import com.saucedemo.utils.ExcelUtils;

public class EndToEndTest extends BaseTest {

    @Test
    public void completePurchaseFlow() throws Exception {
        ExcelUtils.loadExcel("src/test/resources/testdata.xlsx", "LoginData");
        String username = ExcelUtils.getCellData(1, 0);
        String password = ExcelUtils.getCellData(1, 1);
        String fname = ExcelUtils.getCellData(1, 2);
        String lname = ExcelUtils.getCellData(1, 3);
        String zip = ExcelUtils.getCellData(1, 4);

        LoginPage login = new LoginPage(driver);
        login.login(username, password);

        ProductsPage products = new ProductsPage(driver);
        Assert.assertTrue(products.isProductsPageDisplayed());
        products.addProductsToCart();
        products.openCart();

        CartPage cart = new CartPage(driver);
        cart.proceedToCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterUserDetails(fname, lname, zip);
        checkout.continueCheckout();
        checkout.finishOrder();

        ConfirmationPage confirm = new ConfirmationPage(driver);
        Assert.assertTrue(confirm.getConfirmationMessage().contains("Thank you"));

        confirm.logout();
    }
}
