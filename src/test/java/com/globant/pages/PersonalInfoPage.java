package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInfoPage extends BasePage {

    @FindBy(className = "checkout_info")
    private WebElement checkoutInfoDiv;
    @FindBy(id = "first-name")
    private WebElement nameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;
    @FindBy(id = "continue")
    private WebElement continueButton;

    public PersonalInfoPage(WebDriver driver) {
        super(driver);
    }

    public boolean personalInfoPageIsAvailable() {
        return elementIsAvailable(checkoutInfoDiv);
    }

    public OrderOverviewPage continuePurchase() {
        writeIn(nameInput, "Harold");
        writeIn(lastNameInput, "Peña");
        writeIn(postalCodeInput, "4170021");
        clickOn(continueButton);
        return new OrderOverviewPage(driver);
    }


}
