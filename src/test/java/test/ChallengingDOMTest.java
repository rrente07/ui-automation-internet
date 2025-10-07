package test;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.BrokenImagePage;
import pages.ChallengingDOMPage;
import pages.HomePage;

import javax.print.attribute.standard.MediaSize;
import java.io.File;
import java.io.IOException;

public class ChallengingDOMTest extends BaseTest {


    static HomePage homePage;
    static ChallengingDOMPage ChallengingDOMPage;

    @BeforeAll
    static void setUp() {
        ChallengingDOMPage = new ChallengingDOMPage();
        homePage = new HomePage(driver);
    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void getScreenShoot() {
        try {
            // Get the screenshot before
            File before = ChallengingDOMPage.getCanvasScreenshot();
            ChallengingDOMPage.ClickOnBtnFoo();
            File after = ChallengingDOMPage.getCanvasScreenshot();

            Assertions.assertTrue(before.exists(), "The screenshot 'before' was created");
            Assertions.assertTrue(after.exists(), "The screenshot 'after' was created");

            // Compare if both screenshots are the same
            ChallengingDOMPage page = new ChallengingDOMPage();
            boolean compareImagesTrue = page.compareImages(before, after);

            Assertions.assertFalse(compareImagesTrue, "Canvas did not change after clicking the button.");

        } catch (IOException e) {
            Assertions.fail("Error comparing screenshots: " + e.getMessage());
        }
    }
}
