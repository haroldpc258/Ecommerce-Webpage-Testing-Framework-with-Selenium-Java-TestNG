package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(className = "login_logo")
    private WebElement loginLogoDiv;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage login(String username, String password) {
        writeIn(usernameInput, username);
        writeIn(passwordInput, password);
        clickOn(loginButton);
        return new ProductsPage(driver);
    }

    public boolean loginPageIsAvailable() {
        return elementIsAvailable(loginLogoDiv);
    }
}
