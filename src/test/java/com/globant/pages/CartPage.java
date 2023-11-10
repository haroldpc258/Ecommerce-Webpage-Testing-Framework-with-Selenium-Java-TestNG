package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "cart_list")
    private WebElement cartListDiv;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    @FindBy(className = "cart_button")
    private List<WebElement> removeItemButtons;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean cartPageIsAvailable() {
        return elementIsAvailable(cartListDiv);
    }

    public PersonalInfoPage checkoutProducts() {
        clickOn(checkoutButton);
        return new PersonalInfoPage(driver);
    }

    public boolean itemsWereRemoved() {
        return removeItemButtons.isEmpty();
    }

    public void removeItems() {
        for (WebElement element : removeItemButtons) {
            clickOn(element);
        }
    }
}
