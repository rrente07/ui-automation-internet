package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AddRemoveElementsPage;
import pages.HomePage;

import java.util.List;

public class AddRemoveElementsTest extends BaseTest{

private static final Logger logger = LoggerFactory.getLogger(AddRemoveElementsTest.class);
static HomePage homePage;
static AddRemoveElementsPage addRemoveElementsPage;


    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

@Test
    public void testAddElement(){
    addRemoveElementsPage = homePage.ClickOnAddRemoveElements();
    logger.info("Current URL: " + driver.getCurrentUrl());
    logger.info("Trying to click on the button...");
    addRemoveElementsPage.clickAddElement();
    boolean isPresent = addRemoveElementsPage.isVisibleDeleteBtn();
    Assertions.assertTrue(isPresent, "Failed: The element is not present");
    logger.info("The element is present:" + isPresent );
}


    @Test
    public void testAddMultipleElements(){
        addRemoveElementsPage = homePage.ClickOnAddRemoveElements();
        logger.info("Current URL: " + driver.getCurrentUrl());
        addRemoveElementsPage.addMultipleDeleteButtons(5);
        int beforeDelete = addRemoveElementsPage.countDeleteButtons();
        Assertions.assertEquals(5, beforeDelete, "Failed because there are different number of button than expected");
        }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7}) // valores dinámicos para probar
    public void testRemoveElement(int ints){
        addRemoveElementsPage = homePage.ClickOnAddRemoveElements();
        logger.info("Current URL: " + driver.getCurrentUrl());

        addRemoveElementsPage.addMultipleDeleteButtons(ints);

        int beforeDelete = addRemoveElementsPage.countDeleteButtons();
        logger.info("Buttons to delete: {}", beforeDelete);

        int afterDelete = addRemoveElementsPage.removeDeleteButtons(beforeDelete);

        Assertions.assertEquals(beforeDelete, afterDelete, "We do not add buttons correctly");
        Assertions.assertEquals(beforeDelete, beforeDelete, "We do not add buttons correctly");
    }

}
