package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderCompletePage extends BasePage {

    @FindBy(id = "checkout_complete_container")
    private WebElement checkoutCompleteDiv;

    public OrderCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean purchaseIsSuccessful() {
        return elementIsAvailable(checkoutCompleteDiv);
    }
}
