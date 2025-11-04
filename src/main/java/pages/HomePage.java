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
    private By CheckBoxPage_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/checkboxes')]");
    private By ContextMenuPage_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/context_menu')]");
    private By DessapearPage_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/disappearing_elements')]");
    private By DragAndDrop_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/drag_and_drop')]");
    private By DynamicContent_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/dynamic_content')]");
    private By DynamicControl_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/dynamic_controls')]");
    private By DynamicLoading_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/dynamic_loading')]");
    private By EntryAd_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/entry_ad')]");
    private By ExitIntent_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/exit_intent')]");
    private By fileDownload_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/download')]");
    private By fileAuthenticator_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/login')]");
    private By fileFrame_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/nested_frames')]");
    private By geolocation_Locator = By.xpath("//div[@id='content']//a[contains(@href,'/geolocation')]");

    /**
     * Clicks in the link DropDown Page
     */
    public DropdownPage clickOnDropDown() {
        waitForElementToBePresent(dropdown_home_Locator);
        driver.findElement(dropdown_home_Locator).click();
        return new DropdownPage();
    }
    /**
     * Clicks in the link Hover Page
     */
    public HoversPage clickOnHover() {
        waitForElementToBePresent(hoverOver_home_Locator);
        driver.findElement(hoverOver_home_Locator).click();
        return new HoversPage();
    }
    /**
     * Clicks in the link KeyPresses
     */
    public KeyPressesPage clickKeyPresses() {
        waitForElementToBePresent(key_presses_home_Locator);
        driver.findElement(key_presses_home_Locator).click();
        System.out.println("Current URL: " + driver.getCurrentUrl());
        return new KeyPressesPage();
    }
    /**
     * Clicks in the link AlertsJS
     */
    public AlertsPage clickOnAlertsJS() {
        waitForElementToBePresent(jsAlerts_home_Locator);
        driver.findElement(jsAlerts_home_Locator).click();
        return new AlertsPage();
    }
    /**
     * Clicks in the link Click Add and Remove Elements
     */
    public AddRemoveElementsPage clickOnAddRemoveElements() {
        waitForElementToBePresent(AddRemoveElements_home_Locator);
        driver.findElement(AddRemoveElements_home_Locator).click();
        return new AddRemoveElementsPage();
    }
    /**
     * Clicks in the link Click Remove Image
     */
    public BrokenImagePage clickOnBrokenImage() {
        waitForElementToBePresent(ImageBroken_home_Locator);
        driver.findElement(ImageBroken_home_Locator).click();
        return new BrokenImagePage();
    }
    /**
     * Clicks in the link Click Challenging DOM
     */
    public ChallengingDOMPage clickOnChallengingDOM() {
        waitForElementToBePresent(ChalllengDom_Locator);
        driver.findElement(ChalllengDom_Locator).click();
        return new ChallengingDOMPage();
    }

    /**
     * Clicks in the link Click Checkbox
     */
    public CheckboxesPages clickOnCheckBox() {
        waitForElementToBePresent(CheckBoxPage_Locator);
        driver.findElement(CheckBoxPage_Locator).click();
        return new CheckboxesPages();
    }

    /**
     * Clicks in the link Click On ContextMenu
     */
    public ContextMenuPages clickOnContextMenu() {
        waitForElementToBePresent(ContextMenuPage_Locator);
        driver.findElement(ContextMenuPage_Locator).click();
        return new ContextMenuPages();
    }
    /**
     * Clicks in the link Click On DisappearingElementsPage
     */
    public DisappearingElementsPage clickOnDisappearingElements() {
        waitForElementToBePresent(DessapearPage_Locator);
        driver.findElement(DessapearPage_Locator).click();
        return new DisappearingElementsPage();
    }
    /**
     * Clicks in the link Click On DragAndDropPage
     */
    public AddDragAndDropPage clickOnAddDragAndDrop() {
        waitForElementToBePresent(DragAndDrop_Locator);
        driver.findElement(DragAndDrop_Locator).click();
        return new AddDragAndDropPage();
    }

    /**
     * Clicks in the link Click On DynamicContent
     */
    public DynamicContentPage clickOnDynamicContent() {
        waitForElementToBePresent(DynamicContent_Locator);
        driver.findElement(DynamicContent_Locator).click();
        return new DynamicContentPage();
    }


    /**
     * Clicks in the link Click On DynamicControl
     */
    public DynamicControlPage clickOnDynamicControl() {
        waitForElementToBePresent(DynamicControl_Locator);
        driver.findElement(DynamicControl_Locator).click();
        return new DynamicControlPage();
    }


    /**
     * Clicks in the link Click On DynamicLoading
     */
    public DynamicLoadingPage clickOnDynamicLoading() {
        waitForElementToBePresent(DynamicLoading_Locator);
        driver.findElement(DynamicLoading_Locator).click();
        return new DynamicLoadingPage();
    }


    /**
     * Clicks in the link Click On Entry Ad
     */
    public Entry_AdPage clickOnEntryAd() {
        waitForElementToBePresent(EntryAd_Locator);
        driver.findElement(EntryAd_Locator).click();
        return new Entry_AdPage();
    }


    /**
     * Clicks in the link Click On Exit Intent
     */
    public ExitIntentPage clickOnExitIntent() {
        waitForElementToBePresent(ExitIntent_Locator);
        driver.findElement(ExitIntent_Locator).click();
        return new ExitIntentPage();
    }

    /**
     * Clicks in the link Click On Download
     */
    public FileDownloadPage clickOnDownload() {
        waitForElementToBePresent(fileDownload_Locator);
        driver.findElement(fileDownload_Locator).click();
        return new FileDownloadPage();
    }

    /**
     * Clicks in the link Click On Form Authentication
     */
    public AuthenticationPage clickOnAuthentication() {
        waitForElementToBePresent(fileAuthenticator_Locator);
        driver.findElement(fileAuthenticator_Locator).click();
        return new AuthenticationPage();
    }


    /**
     * Clicks in the link Click On Frame Link
     */
    public FramesPage clickOnFrameLink() {
        waitForElementToBePresent(fileFrame_Locator);
        driver.findElement(fileFrame_Locator).click();
        return new FramesPage();

 }

    /**
     * Clicks in the link Click On Geolocation Link
     */
    public GeoLocationPage clickOnGeolocation() {
        waitForElementToBePresent(geolocation_Locator);
        driver.findElement(geolocation_Locator).click();
        return new GeoLocationPage();

    }







}

