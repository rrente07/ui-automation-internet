package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FramesPage extends BasePage{
    By frameTop_Locator =  By.name("frame-top");
    By frameLeft_Locator =  By.name("frame-left");
    By frameMiddle_Locator = By.name("frame-middle");
    By frameRight_Locator = By.name("frame-right");
    By frameButton_Locator = By.name("frame-bottom");

     /**
     * Get text from the Left Frame
     **/
    public String getTextLeftFrame() {
        return getFrameText(frameTop_Locator, frameLeft_Locator);
    }

    /**
     * Get text from the Middle Frame
     **/
    public String getTextMiddleFrame() {
        return getFrameText(frameTop_Locator, frameMiddle_Locator);
    }

    /**
     * Get text from the Right Frame
     **/
    public String getTextRightFrame() {
        return getFrameText(frameTop_Locator, frameRight_Locator);
    }

    /**
     * Get text from the Button Frame
     **/
    public String getTextButtonFrame() {
        return getFrameText(frameTop_Locator, frameButton_Locator);
    }


    /**
     * Get text from the Button Frame
     **/
    public String getFrameButtonText() {
        // Locate and switch to Button frame
        WebElement frameButton = driver.findElement(frameButton_Locator);
        driver.switchTo().frame(frameButton);
        // Get text
        String texto = driver.findElement(By.tagName("body")).getText();
        // Return to main content
        driver.switchTo().defaultContent();
        return texto;
    }

}
