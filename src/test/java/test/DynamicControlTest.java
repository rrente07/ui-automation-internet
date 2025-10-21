package test;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DynamicControlPage;
import pages.HomePage;

public class DynamicControlTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(DynamicControlTest.class);

    static HomePage homePage;
    static DynamicControlPage dynamicControlPage;

    @BeforeAll
    static void setUp() {
        dynamicControlPage = new DynamicControlPage();
        homePage = new HomePage(driver);
    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    //Verify Remove Checkbox
    @Test
    @DisplayName("Checkbox - Disabled")
    public void toggleCheckbox() {
        //Click on the page menu Dynamic Control
        dynamicControlPage = homePage.clickOnDynamicControl();

       //Initial status
        boolean checkboxInitiallyPresent = dynamicControlPage.checkboxIsPresent();
        logger.info("Initial checkbox state: {}", checkboxInitiallyPresent ? "PRESENT" : "NOT PRESENT");

        //First click: change status
        dynamicControlPage.WaitForAddRemoveBtn();
        dynamicControlPage.clickAddRemoveButton();
        String firstMessage = dynamicControlPage.getDynamicMessage();
        logger.info("Message after clicking: {}", firstMessage);

        if (!checkboxInitiallyPresent) {
    Assertions.assertEquals("It's gone!", firstMessage, "Expected message after removing checkbox");
    Assertions.assertFalse(dynamicControlPage.checkboxIsPresent(), "El checkbox debería haber sido eliminado");
        }else {
    Assertions.assertEquals("It's back!", firstMessage, "Expected that the checkbox was adding");
    Assertions.assertTrue(dynamicControlPage.checkboxIsPresent(), "The checkbox should be adding");
}
    }

    //Verify Remove Checkbox
    @Test
    @DisplayName("Checkbox - Enable")
    public void toggleCheckbox1() {
        //Click on the page menu Dynamic Control
        dynamicControlPage = homePage.clickOnDynamicControl();

        //First click: change status
        dynamicControlPage.WaitForAddRemoveBtn();
        dynamicControlPage.clickAddRemoveButton();
        dynamicControlPage.clickAddRemoveButton();
        //Initial status
        boolean checkboxInitiallyPresent = dynamicControlPage.checkboxIsPresent();
        System.out.println("¿Checkbox is present? " + checkboxInitiallyPresent);

        String secondMessage = dynamicControlPage.getDynamicMessage();
        logger.info("Message after clicking: {}", secondMessage);

            Assertions.assertEquals("It's back!", secondMessage, "Expected message after removing checkbox");
            Assertions.assertTrue(dynamicControlPage.checkboxIsPresent(), "The checkbox should be adding");
}}
