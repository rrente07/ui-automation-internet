package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// define the locator that we see in the view and the method who help to validate all of this
    public class HomePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(pages.HomePage.class);


    /**
     * Represents the Home Page and provides methods to interact with its elements.
     */
    public HomePage(WebDriver driver) {
        super();
    }
    // Pages
    private By dropdown_home_Locator = By.xpath("//div[@id='content']//a[contains(@href,'dropdown')]");
    private By hoverOver_home_Locator = By.xpath("//div[@id='content']//a[contains(@href,'hovers')]");
    private By key_presses_home_Locator = By.xpath("//div[@id='content']//a[contains(@href,'key_presses')]");
    private By jsAlerts_home_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/javascript_alerts')]");
    private By AddRemoveElements_home_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/add_remove_elements/')]");
    private By ImageBroken_home_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/broken_images')]");
    private By ChalllengDom_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/challenging_dom')]");

   /**
     * Clicks in the link DropDown Page
     */
    public DropdownPage ClickOnDropDown() {
        waitForElementToBePresent(dropdown_home_Locator);
        driver.findElement(dropdown_home_Locator).click();
        return new DropdownPage();
    }
    /**
     * Clicks in the link Hover Page
     */
    public HoversPage ClickOnHover() {
        waitForElementToBePresent(hoverOver_home_Locator);
        driver.findElement(hoverOver_home_Locator).click();
        return new HoversPage();
    }
    /**
     * Clicks in the link KeyPresses
     */
    public KeyPressesPage ClickKeyPresses() {
        waitForElementToBePresent(key_presses_home_Locator);
        driver.findElement(key_presses_home_Locator).click();
        System.out.println("Current URL: " + driver.getCurrentUrl());
        return new KeyPressesPage();
    }
    /**
     * Clicks in the link AlertsJS
     */
    public AlertsPage ClickOnAlertsJS() {
        waitForElementToBePresent(jsAlerts_home_Locator);
        driver.findElement(jsAlerts_home_Locator).click();
        return new AlertsPage();
    }

    /**
     * Clicks in the link Click Add and Remove Elements
     */
    public AddRemoveElementsPage ClickOnAddRemoveElements() {
        waitForElementToBePresent(AddRemoveElements_home_Locator);
        driver.findElement(AddRemoveElements_home_Locator).click();
        return new AddRemoveElementsPage();
    }

    /**
     * Clicks in the link Click Remove Image
     */
    public BrokenImagePage ClickOnBrokenImage() {
        waitForElementToBePresent(ImageBroken_home_Locator);
        driver.findElement(ImageBroken_home_Locator).click();
        return new BrokenImagePage();
    }


    /**
     * Clicks in the link Click Challenging DOM
     */
    public ChallengingDOMPage ClickOnChallengingDOM() {
        waitForElementToBePresent(ChalllengDom_Locator);
        driver.findElement(ChalllengDom_Locator).click();
        return new ChallengingDOMPage();
    }


}

