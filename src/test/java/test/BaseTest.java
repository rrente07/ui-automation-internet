package test;

import config.BrowserType;
import config.DriverManager;
import config.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    public static WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        driver = WebDriverFactory.createDriver(BrowserType.CRHOME);
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterAll
    static void afterAll() {
        DriverManager.quitDriver();
    }
}