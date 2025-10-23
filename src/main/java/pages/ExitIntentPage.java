package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ExitIntentPage extends BasePage{
    private final Logger logger = LoggerFactory.getLogger(ExitIntentPage.class);
    private By modalBody_Locator = By.className("modal");
    private By modalBtnClose_Locator = By.className("modal-footer");

        private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Check if the modal is displayed.
     */
    public boolean isModalDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(modalBody_Locator));
            return modal.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Close the modal
     */
    public void closeModal() {
        WebElement closeButton = findElement(modalBtnClose_Locator);
        closeButton.click();
        waitForElementGoAway(modalBody_Locator);
    }

    public void triggerExitIntent(WebDriver driver) {
        String script = """
        var e = new MouseEvent('mouseleave', {
            bubbles: true,
            cancelable: true,
            clientX: 100,
            clientY: -50, // Y negativo para simular salir por arriba
            relatedTarget: null
        });
        document.body.dispatchEvent(e);
    """;
        ((JavascriptExecutor) driver).executeScript(script);

        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
    }




}







