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
   private By dropdown_Locator = By.xpath("//div[@id='content']//a[contains(@href,'dropdown')]");


    /**
     * Clicks in the link DropDown
     */
    public DropdownPage ClickOnDropDown() {
        waitForElementToBePresent(dropdown_Locator);
        driver.findElement(dropdown_Locator).click();

        return new DropdownPage();

    }}

