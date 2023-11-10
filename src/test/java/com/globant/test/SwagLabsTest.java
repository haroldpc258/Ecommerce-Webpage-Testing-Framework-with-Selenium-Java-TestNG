package com.globant.test;

import com.globant.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SwagLabsTest extends BaseTest {

    @Test
    @Parameters({ "usernameInput", "passwordInput" })
    public void loginTest(String usernameInput, String passwordInput) {
        LoginPage loginPage = loadFirstPage();
        ProductsPage resultPage = loginPage.login(usernameInput, passwordInput);
        Assert.assertTrue(resultPage.productsPageIsAvailable());
    }

    @Test
    @Parameters({ "usernameInput", "passwordInput" })
    public void purchaseProductsTest(String usernameInput, String passwordInput) {
        LoginPage loginPage = loadFirstPage();
        ProductsPage productsPage = loginPage.login(usernameInput, passwordInput);
        Assert.assertTrue(productsPage.productsPageIsAvailable());
        CartPage cartPage = productsPage.addProductsToCart();
        Assert.assertTrue(cartPage.cartPageIsAvailable());
        PersonalInfoPage personalInfoPage = cartPage.checkoutProducts();
        Assert.assertTrue(personalInfoPage.personalInfoPageIsAvailable());
        OrderOverviewPage orderOverviewPage = personalInfoPage.continuePurchase();
        Assert.assertTrue(orderOverviewPage.orderOverviewPageIsAvailable());
        OrderCompletePage orderCompletePage = orderOverviewPage.finishPurchase();
        Assert.assertTrue(orderCompletePage.purchaseIsSuccessful());
    }

    @Test
    @Parameters({ "usernameInput", "passwordInput" })
    public void removeItemsOfCart(String usernameInput, String passwordInput) {
        LoginPage loginPage = loadFirstPage();
        ProductsPage productsPage = loginPage.login(usernameInput, passwordInput);
        Assert.assertTrue(productsPage.productsPageIsAvailable());
        CartPage cartPage = productsPage.addProductsToCart();
        Assert.assertTrue(cartPage.cartPageIsAvailable());
        cartPage.removeItems();
        Assert.assertTrue(cartPage.itemsWereRemoved());
    }

    @Test
    @Parameters({ "usernameInput", "passwordInput" })
    public void logOutTest(String usernameInput, String passwordInput) {
        LoginPage loginPage = loadFirstPage();
        ProductsPage productsPage = loginPage.login(usernameInput, passwordInput);
        Assert.assertTrue(productsPage.productsPageIsAvailable());
        loginPage = productsPage.logout();
        Assert.assertTrue(loginPage.loginPageIsAvailable());
    }
}
