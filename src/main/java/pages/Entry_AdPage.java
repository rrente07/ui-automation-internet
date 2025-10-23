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
    private By modalCloseBtn_Locator = By.className("modal-footer");
    private By EntryAd_Locator = By.xpath("//div[@class='example']//a[text()='click here']");


    public boolean isModalVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(modal_Locator));
            return modal.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }

    }

    public void ClickCloseModal(){
        // Create an explicit wait with a 10-second timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the modal window becomes visible on the page
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(modal_Locator));
        // Wait until the "Close" button inside the modal is clickable
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(modalCloseBtn_Locator));
        // Click the "Close" button to dismiss the modal
        WebElement element = findElement(modalCloseBtn_Locator);
        element.click();
        // Wait until the modal is no longer visible (has disappeared from the DOM or screen)
        wait.until(ExpectedConditions.invisibilityOf(modal));
    }


    public boolean isModalGone() {
try {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //Wait for modal to disappear or not visible
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(modal_Locator));
}catch (TimeoutException e){
    //If the modal is present after 10 seconds, returns false
    return false;
}}

public void clickOnClikHereOption(){
        // Create an explicit wait with a 10-second timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the modal window becomes visible on the page
        WebElement click_here = wait.until(ExpectedConditions.visibilityOfElementLocated(EntryAd_Locator));
    WebElement element = findElement(EntryAd_Locator);
    element.click();
    }

}