package test;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DynamicControlPage;
import pages.DynamicLoadingPage;
import pages.Dynamic_LoadingPage1;
import pages.HomePage;

public class DynamicLoadingTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(DynamicLoadingTest.class);

    static HomePage homePage;
    static DynamicLoadingPage dynamicLoadingPage;
    static Dynamic_LoadingPage1  dynamicLoadingPage1;

    @BeforeAll
    static void setUp() {
        dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage1 = new Dynamic_LoadingPage1();
        homePage = new HomePage(driver);
    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    //Verify Dynamically Loaded Page Elements Example 1
    @Test
    @DisplayName("Dynamic - Load")
    public void dynamicLoadingTest() {
        //Click on the page menu Dynamic Control
        dynamicLoadingPage = homePage.clickOnDynamicLoading();
        dynamicLoadingPage.clickOnDynamicLoading1();
        dynamicLoadingPage1.clickOnStartBtn();
        String getText1 = dynamicLoadingPage1.getTextLoading();
        logger.info("the text is {}", getText1);
        Assertions.assertEquals("Hello World!", getText1, "The message is not equal");
    }

    //Verify Dynamically Loaded Page Elements Example 2
    @Test
    @DisplayName("Dynamic - Load")
    public void dynamicLoading1Test() {
        //Click on the page menu Dynamic Control
        dynamicLoadingPage = homePage.clickOnDynamicLoading();
        dynamicLoadingPage.clickOnDynamicLoading2();
        dynamicLoadingPage1.clickOnStartBtn();
        String getText1 = dynamicLoadingPage1.getTextLoading();
        logger.info("the text is {}", getText1);
        Assertions.assertEquals("Hello World!", getText1, "The message is not equal");
    }
}
