package com.globant.pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(ElementNotInteractableException.class);
    }

    protected boolean elementIsAvailable(WebElement element) {
        return element.isEnabled() && element.isDisplayed();
    }

    protected void clickOn(WebElement element) {
        waitToBeClickable(element);
        element.click();
    }

    protected void writeIn(WebElement element, String text) {
        waitVisibilityOf(element);
        element.sendKeys(text);
    }

    private void waitToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void waitVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
