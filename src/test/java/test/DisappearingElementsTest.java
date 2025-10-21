package test;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DisappearingElementsPage;
import pages.HomePage;

public class DisappearingElementsTest extends BaseTest{
    private final Logger logger = LoggerFactory.getLogger(DisappearingElementsTest.class);
static HomePage homePage;
static DisappearingElementsPage disappearingElementsPage;


    @BeforeAll
    static void setUp() {
        disappearingElementsPage = new DisappearingElementsPage();
        homePage = new HomePage(driver);
    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("VerifyHomeLink")
    public void VerifyHomeLinkTest(){
        //Navigate to Disappearing Element Page
        disappearingElementsPage = homePage.clickOnDisappearingElements();

        //Attempt to click the Home us link if it is present
        boolean HomeLinkIsPresent = disappearingElementsPage.clickLinkHomeIfPresent();
        logger.info("The link is present: {}", HomeLinkIsPresent);

        //Attempt to click the Home link if it is present
        if (HomeLinkIsPresent) {
            String expectedURL = "https://the-internet.herokuapp.com/";
            String currentURL = driver.getCurrentUrl();
            Assertions.assertEquals(expectedURL, currentURL, "Incorrect URL after clicking Home");
        }else {
                // Log a warning if the link was not present on this page load
                logger.warn("Portfolio link was not present — skipping assertion");
            }
        }


    @Test
    @DisplayName("VerifyAboutLink")
    public void VerifyAboutLinkTest(){
        //Navigate to Disappearing Element Page
        disappearingElementsPage = homePage.clickOnDisappearingElements();

        //Attempt to click the Contact us link if it is present
        boolean AboutIsPresent = disappearingElementsPage.clickLinkAboutIfPresent();
        logger.info("The link is present: {}", AboutIsPresent);

        //If the link was present, verify the URL is correct
        if (AboutIsPresent) {
       String expectedURL = "https://the-internet.herokuapp.com/about/";
       String currentURL = driver.getCurrentUrl();
       Assertions.assertEquals(expectedURL, currentURL, "Incorrect URL after clicking About");
        }else {
            // Log a warning if the link was not present on this page load
            logger.warn("Portfolio link was not present — skipping assertion");
        }
    }

    @Test
    @DisplayName("VerifyContactUsLink")
    public void VerifyContactUsLinkTest(){
        //Navigate to Disappearing Element Page
        disappearingElementsPage = homePage.clickOnDisappearingElements();

        //Attempt to click the Contact us link if it is present
        boolean ContactUsIsPresent = disappearingElementsPage.clickLinkContactUsIfPresent();
        logger.info("The link is present: {}", ContactUsIsPresent);

        //If the link was present, verify the URL is correct
        if (ContactUsIsPresent) {
            String expectedURL = "https://the-internet.herokuapp.com/contact-us/";
            String actualURL = driver.getCurrentUrl();
            Assertions.assertEquals(expectedURL, actualURL, "Incorrect URL after clicking Contact Us");
        } else
            {
                // Log a warning if the link was not present on this page load
                logger.warn("Portfolio link was not present — skipping assertion");
            }
         }

    @Test
    @DisplayName("VerifyPortfolio")
    public void VerifyPortfolioLinkTest(){
        //Navigate to Disappearing Element Page
        disappearingElementsPage = homePage.clickOnDisappearingElements();

        //Attempt to click the Portfolio link if it is present
        boolean PortfolioIsPresent = disappearingElementsPage.clickLinkPortfolioIfPresent();
        logger.info("The link is present: {}", PortfolioIsPresent);

        //If the link was present, verify the URL is correct
        if (PortfolioIsPresent) {
            String expectedURL = "https://the-internet.herokuapp.com/portfolio/";
            String actualURL = driver.getCurrentUrl();
            Assertions.assertEquals(expectedURL, actualURL, "Incorrect URL after clicking Portfolio");
        } else
        {
            // Log a warning if the link was not present on this page load
            logger.warn("Portfolio link was not present — skipping assertion");
        }
    }


    @Test
    @DisplayName("Verify Gallery link if present")
    public void verifyGalleryLinkTest() {
        //Navigate to Disappearing Element Page
        disappearingElementsPage = homePage.clickOnDisappearingElements();

        //Attempt to click the Gallery link if it is present
        boolean GalleryIsPresent = disappearingElementsPage.clickLinkGalleryIfPresent();
        logger.info("The link is present: {}", GalleryIsPresent);

        //If the link was present, verify the URL is correct
        if (GalleryIsPresent) {
            String expectedURL = "https://the-internet.herokuapp.com/gallery/";
            String actualURL = driver.getCurrentUrl();
            Assertions.assertEquals(expectedURL, actualURL, "Incorrect URL after clicking Gallery");
        } else {
            // Log a warning if the link was not present on this page load
            logger.warn("Gallery link was not present — skipping navigation assertion");
        }
    }

    }

