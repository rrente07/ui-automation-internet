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
        entryAdPage = new Entry_AdPage();
        homePage = new HomePage(driver);
    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
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
}}
