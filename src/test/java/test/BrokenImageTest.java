package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BrokenImagePage;
import pages.HomePage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrokenImageTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BrokenImageTest.class);


    static HomePage homePage;
    static BrokenImagePage brokenImagePage;

    @BeforeAll
    static void setUp() {
        brokenImagePage = new BrokenImagePage();
        homePage = new HomePage(driver);
    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("Validate broken images on the page")
    public void shouldDetectBrokenImages() {
        brokenImagePage = homePage.clickOnBrokenImage();
        logger.info("Navigated to: {}", driver.getCurrentUrl());

        List<String> brokenImages = brokenImagePage.validateBrokenImages();

        if (brokenImages.isEmpty()) {
            logger.info("✅ No broken images found.");
        } else {
            logger.warn("🔴 Broken images detected: {}", brokenImages.size());
            for (String src : brokenImages) {
                logger.warn("Broken image URL: {}", src);
            }
        }

        assertTrue(brokenImages.size() > 0, "Expected at least one broken image, but none were found.");
    }
}
