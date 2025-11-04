package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AuthenticationPage;
import pages.FramesPage;
import pages.HomePage;
import pages.SecurelogginPage;

import java.util.List;

public class FrameTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(FrameTest.class);
    static HomePage homePage;
    static FramesPage framesPage;

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        framesPage = new FramesPage();
     }

    @Test
    public void verifyFrameLeftText() {
        var AuthenticationPage =homePage.clickOnFrameLink();
        String currentText = framesPage.getTextLeftFrame();
        String expectedText = "LEFT";
        logger.info("The text is the following:" + currentText);
        Assertions.assertEquals(expectedText, currentText, "The text of the frame is not present");
}

    @Test
    public void verifyFrameMiddleText() {
        var AuthenticationPage =homePage.clickOnFrameLink();
        String currentText = framesPage.getTextMiddleFrame();
        String expectedText = "MIDDLE";
        logger.info("The text is the following:" + currentText);
        Assertions.assertEquals(expectedText, currentText, "The text of the frame is not present");
    }

    @Test
    public void verifyFrameRightText() {
        var AuthenticationPage =homePage.clickOnFrameLink();
        String currentText = framesPage.getTextRightFrame();
        String expectedText = "RIGHT";
        logger.info("The text is the following:" + currentText);
        Assertions.assertEquals(expectedText, currentText, "The text of the frame is not present");
    }

    @Test
    public void verifyFrameButtonText() {
        var AuthenticationPage =homePage.clickOnFrameLink();
        String currentText = framesPage.getFrameButtonText();
        String expectedText = "BOTTOM";
        logger.info("The text is the following:" + currentText);
        Assertions.assertEquals(expectedText, currentText, "The text of the frame is not present");
    }

    @Test
    public void verifyAllFramesContent() {
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        for (WebElement frame : frames) {
            driver.switchTo().frame(frame);
            String text = driver.findElement(By.tagName("body")).getText();
            logger.info("Text of Frame" + frame.getAttribute("name") + ": " + text);
            driver.switchTo().defaultContent();
        }
    }


}
