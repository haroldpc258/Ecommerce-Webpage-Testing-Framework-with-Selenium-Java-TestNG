package com.globant.test;

import com.globant.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    @Parameters({ "browser", "url" })
    public void setUp(String browser, String url) {
        setUpDriver(browser);
        maximizeWindow();
        navigateTo(url);
    }

    public LoginPage loadFirstPage() {
        return new LoginPage(driver);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void setUpDriver(String browser) {
        switch (browser) {
            case "chrome" -> {
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                driver = new EdgeDriver();
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
