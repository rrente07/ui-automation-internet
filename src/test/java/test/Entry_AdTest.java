package test;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DynamicLoadingPage;
import pages.Dynamic_LoadingPage1;
import pages.Entry_AdPage;
import pages.HomePage;

public class Entry_AdTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(Entry_AdTest.class);

    static HomePage homePage;
    static Entry_AdPage entryAdPage;


    @BeforeAll
    static void setUp() {

    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        entryAdPage = new Entry_AdPage();
        homePage = new HomePage(driver);
    }

    //Verify Dynamically Loaded Page Elements Example 1
    @Test
    @DisplayName("EntryAd-Test")
    public void entryAd_Test() {
        //Click on the page menu Entry Ad
        entryAdPage = homePage.clickOnEntryAd();
        boolean isDisplayed = entryAdPage.isModalVisible();
        logger.info("the modal is displayed {}", isDisplayed);
        Assertions.assertTrue(isDisplayed, "The modal is not displayed");
}

    //Verify Modal Close
    @Test
    @DisplayName("CloseModal-Test")
    public void CloseModal_Test() {
        //Click on the page menu Entry Ad
        entryAdPage = homePage.clickOnEntryAd();
        boolean isDisplayed = entryAdPage.isModalVisible();
        logger.info("the modal is displayed {}", isDisplayed);
        entryAdPage.ClickCloseModal();
        boolean modalIsgone = entryAdPage.isModalGone();
        logger.info("The modal is gone: " + modalIsgone);
        Assertions.assertFalse(!modalIsgone, "Modal is not present in DOM");
    }

    //Verify Modal Close
    @Test
    @DisplayName("Reappear After Reenable - Test")
    public void entryAd_ReappearAfterReenableTest() {
        //Click on the page menu Entry Ad
        entryAdPage = homePage.clickOnEntryAd();
        entryAdPage.clickOnClikHereOption();
        boolean isDisplayed = entryAdPage.isModalVisible();
        logger.info("the modal is displayed {}", isDisplayed);
    }


}
