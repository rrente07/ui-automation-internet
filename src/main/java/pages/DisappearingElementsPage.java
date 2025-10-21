package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisappearingElementsPage extends BasePage{

    private final Logger logger = LoggerFactory.getLogger(DisappearingElementsPage.class);

    private By Homepagelink_Locator = By.xpath("//div[@class='example']//a[normalize-space(text())='Home']");
    private By Aboutlink_Locator = By.xpath("//div[@class='example']//a[normalize-space(text())='About']");
    private By ContactUslink_Locator = By.xpath("//div[@class='example']//a[normalize-space(text())='Contact Us']");
    private By Portfoliolink_Locator = By.xpath("//div[@class='example']//a[normalize-space(text())='Portfolio']");
    private By Gallerylink_Locator = By.xpath("//div[@class='example']//a[normalize-space(text())='Gallery']");


    /**
     * Clicks in the link Click On Home Link
     */
    public void clickHomeLink() {
        waitForElementToBePresent(Homepagelink_Locator);
        driver.findElement(Homepagelink_Locator).click();
    }

    /**
     * Clicks in the link Click On About Link
     */
    public void clickAboutLink() {
        waitForElementToBePresent(Aboutlink_Locator);
        driver.findElement(Aboutlink_Locator).click();
    }

    /**
     * Clicks in the link Click On Contact Us Link
     */
    public void clickContactUsLink() {
        waitForElementToBePresent(ContactUslink_Locator);
        driver.findElement(ContactUslink_Locator).click();
    }

    /**
     * Clicks in the link Click On Portfolio Link
     */
    public void clickPortfolioLink() {
        waitForElementToBePresent(Portfoliolink_Locator);
        driver.findElement(Portfoliolink_Locator).click();
    }

    /**
     * Clicks in the link Click On Gallery Link
     */
    public void clickGalleryLink() {
        waitForElementToBePresent(Gallerylink_Locator);
        driver.findElement(Gallerylink_Locator).click();
    }

    public boolean clickLinkHomeIfPresent(){
    return clickLinkIfPresent(Homepagelink_Locator, "Home");
    }

    public boolean clickLinkAboutIfPresent(){
        return clickLinkIfPresent(Aboutlink_Locator, "About");
    }

    public boolean clickLinkContactUsIfPresent(){
        return clickLinkIfPresent(ContactUslink_Locator, "Contact Us");
    }

    public boolean clickLinkPortfolioIfPresent(){
        return clickLinkIfPresent(Portfoliolink_Locator, "Portfolio");
    }

    public boolean clickLinkGalleryIfPresent(){
        return clickLinkIfPresent(Gallerylink_Locator, "Gallery");

    }



}
