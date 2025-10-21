package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Entry_AdPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(Entry_AdPage.class);
    private By modal_Locator = By.id("modal");


    public boolean isModalVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(modal_Locator));
            return modal.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }

    }
}