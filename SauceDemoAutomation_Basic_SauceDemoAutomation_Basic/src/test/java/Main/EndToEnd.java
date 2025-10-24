package Main;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.ConfirmationPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.ExcelUtils;

public class EndToEnd extends BaseTest {

    public EndToEnd() {
        super(); // Ensures BaseTest constructor is called
    }

    @Test
    public void completePurchaseFlow() throws Exception {
        // Load test data from Excel
        ExcelUtils.loadExcel("src/test/resources/testdata.xlsx", "LoginData");
        String username = ExcelUtils.getCellData(1, 0);
        String password = ExcelUtils.getCellData(1, 1);
        String fname = ExcelUtils.getCellData(1, 2);
        String lname = ExcelUtils.getCellData(1, 3);
        String zip = ExcelUtils.getCellData(1, 4);

        // Use inherited driver from BaseTest
        LoginPage login = new LoginPage(driver);
        login.login(username, password);

        ProductsPage products = new ProductsPage(driver);
        Assert.assertTrue(products.isProductsPageDisplayed(), "Products page is not displayed");
        products.addProductsToCart();
        products.openCart();

        CartPage cart = new CartPage(driver);
        cart.proceedToCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterUserDetails(fname, lname, zip);
        checkout.continueCheckout();
        checkout.finishOrder();

        ConfirmationPage confirm = new ConfirmationPage(driver);
        String message = confirm.getConfirmationMessage();
        Assert.assertNotNull(message, "Confirmation message is null");
        Assert.assertTrue(message.contains("Thank you"), "Expected 'Thank you' in confirmation message, but got: " + message);

        confirm.logout();
    }
}