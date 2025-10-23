package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.ExitIntentPage;
import pages.HomePage;

import java.time.Duration;

public class ExistIntentTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(ExistIntentTest.class);
    static HomePage homePage;
    static ExitIntentPage exitIntentPage;

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit(); //
        }
    }

    @BeforeAll
    static void setUp() {
        exitIntentPage = new ExitIntentPage();
        homePage = new HomePage(driver);
    }

    @BeforeEach
    void setUpEach() {

        // Limpiar cookies y local storage antes de iniciar el test
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
        driver.navigate().refresh();
        // Refrescar la página para aplicar la limpieza
        driver.get("https://the-internet.herokuapp.com/");

        homePage = new HomePage(driver);
    }

}
