package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CheckboxesPages;
import pages.ContextMenuPages;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContextMenuTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(ContextMenuTest.class);
    static HomePage homePage;
    static ContextMenuPages ContextMenuPages;


    @BeforeAll
    static void setUp() {
        ContextMenuPages = new ContextMenuPages();
        homePage = new HomePage(driver);
    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }


    @Test
    public void SelectOptionTest() {
        var contextMenuPage = homePage.ClickOnContextMenu();
        contextMenuPage.VerifyContextMenuDisplayed();
        Alert alert = driver.switchTo().alert();
        String alertText = homePage.getAlertText();
        assertEquals("You selected a context menu", alertText);
        logger.info("This is the text of the alert:" + alertText);
        alert.accept();
    }
}
