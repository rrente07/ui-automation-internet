package pages;

import config.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;


//BasePage provides common Selenium WebDriver actions and utilities
public class BasePage {
    WebDriver driver; //declare objet the type Webdriver
    WebDriverWait wait; //declare objet the type wait
    private static final int TIMEOUT = 10; // maximum wait time (10 seconds)

    //Constructor initializes WebDriver and WebDriverWait.
    public BasePage() {
        this.driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }
    //Finds a web element by locator, waiting for its presence.
    public WebElement findElement(By locator) {
        //Waiting for the element to be present
        waitForElementToBePresent(locator);
        return driver.findElement(locator);
    }
    /**
     * Finds a list of web elements by locator, waiting for their presence.
     * @param locator By locator
     * @return List of WebElements found
     */
    public List<WebElement> findElements(By locator) {
        waitForElementToBePresent(locator);
        return driver.findElements(locator);
    }
    /**
     * Clicks on a web element found by locator, waiting for its presence.
     * @param locator By locator
     */
    public void click(By locator) {
        waitForElementToBePresent(locator);
        driver.findElement(locator).click();
    }
    /**
     * Scrolls to a web element by locator and clicks it using JavaScript.
     * @param locator By locator
     */
    public void scrollIntoViewAndClick(By locator){
        waitForElementToBeClickable(locator);
        WebElement element = findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);
        js.executeScript("arguments[0].click()",element);
    }

    public void scrollIntoViewAndClick(WebElement element){
        waitForElementToBeClickable(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);
        js.executeScript("arguments[0].click()",element);
    }

    public void scrollIntoViewAndClickAlert(By locator){
        waitForElementToBeClickable(locator);
        WebElement element = findElement(locator);
        System.out.println("Clicking button: " + element.getText()); // ← antes del click
        scrollIntoView(element);
        new Actions(driver).moveToElement(element).click().perform(); // ← click real
    }

    /**
     * Types text into a web element found by locator, clearing it first.
     * @param locator By locator
     * @param text    Text to type
     */
    public void type(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Gets the text of a web element found by locator.
     * @param locator By locator
     * @return Text of the element
     */
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
    /**
     * Gets the text of a given web element.
     * @param element WebElement
     * @return Text of the element
     */
    public String getText(WebElement element) {
        return element.getText();
    }

    /**
     * Checks if a web element found by locator is displayed.
     * @param locator By locator
     * @return true if displayed, false otherwise
     */
    public boolean IsDisplayed(By locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Waits for a web element to be present in the DOM.
     * @param locator By locator
     */
    public void waitForElementToBePresent(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Waits for a web element found by locator to be clickable.
     *
     * @param locator By locator
     */
    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Waits for a given web element to be clickable.
     *
     * @param element WebElement
     */
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForNewWindow(){
        wait.until((ExpectedCondition <Boolean>)
                d -> d!=null && d.getWindowHandles().size()>1);
    }

    //Wait for the element go away
    public void waitForElementGoAway(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e){
            if( IsDisplayed(locator))
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }
    }

    /**
     * Submits a form using a web element found by locator.
     *
     * @param locator By locator
     */
    public void Submit(By locator) {
        WebElement element = findElement(locator);
        element.submit();
    }

    /**
     * Scrolls to a web element found by locator.
     *
     * @param locator By locator
     */
    public void scrollIntoView(By locator) {
        waitForElementToBeClickable(locator);
        WebElement element = findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }
    /**
     * Scrolls to a given web element.
     *
     * @param element WebElement
     */
    public void scrollIntoView(WebElement element) {
        waitForElementToBeClickable(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    // Method who use JavaScriptExecutor

    //Scroll to the bottom of the page
    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

//Scroll to the bottom of the page

    public void scrollToTop(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0)");
    }

    public void uploadFile(By locator, String filePath){
        WebElement uploadElement = findElement(locator);
        uploadElement.sendKeys(filePath);
    }

    public void switchToNewWindow(String OriginalHandle){
        //Waiting for a new window open
        waitForNewWindow();
        //Saving all windows handles
        Set<String> allWindows = driver.getWindowHandles();
// iterating through all the Windows handle
        for (String handle : allWindows){
            System.out.println("Handle" + handle);
            //If handle different the original window handle we switch to that new window
            if (!handle.equals(OriginalHandle))
                driver.switchTo().window(handle);
        }
    }
    // Select a checkbox if not already selected
    public void selectCheckbox(By locator) {
        try {
            waitForElementToBeClickable(locator);
            WebElement checkbox = driver.findElement(locator);
            scrollIntoView(checkbox);
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to select checkbox: " + e.getMessage(), e);
        }
    }

    public void waitForAlertToBePresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //Method to working with the alerts
//Selenium have a class alert that permit to interact with the alert
    //Accept the alert
    public void acceptAlert(){
        waitForAlertToBePresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    //Dismiss the alert
    public void dismissAlert(){
        waitForAlertToBePresent();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //Send text to the alert
    public void sendKeysToAlert(String msg){
        waitForAlertToBePresent();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(msg);
        alert.accept();
    }

    //To get the text from the alert
    public String getAlertText(){
        waitForAlertToBePresent();
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public boolean isElementVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void triggerAlert (By locator){
        scrollIntoViewAndClickAlert(locator);
    }

    public void ClickAcceptAlert(By locator){
        triggerAlert(locator);
        acceptAlert();
    }

    public void ClickDismissAlert(By locator){
        triggerAlert(locator);
        dismissAlert();
    }


}

