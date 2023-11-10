package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderOverviewPage extends BasePage {

    @FindBy(className = "summary_info")
    private WebElement summaryInfoDiv;
    @FindBy(id = "finish")
    private WebElement finishButton;

    public OrderOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean orderOverviewPageIsAvailable() {
        return elementIsAvailable(summaryInfoDiv);
    }

    public OrderCompletePage finishPurchase() {
        clickOn(finishButton);
        return new OrderCompletePage(driver);
    }

}
