package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(id = "inventory_container")
    private WebElement inventoryDiv;
    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartButtons;
    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;
    @FindBy(className = "bm-menu")
    private WebElement menuDiv;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean productsPageIsAvailable() {
        return elementIsAvailable(inventoryDiv);
    }

    public CartPage addProductsToCart() {
        for (int i = 0; i < 3; i++) {
            WebElement addProductButton = addToCartButtons.get(i);
            clickOn(addProductButton);
        }
        clickOn(cartLink);

        return new CartPage(driver);
    }

    public LoginPage logout() {
        clickOn(menuButton);
        clickOn(logoutLink);
        return new LoginPage(driver);
    }
}
