package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeoLocationPage extends BasePage{

    private static final Logger logger = LoggerFactory.getLogger(GeoLocationPage.class);
    By buttonWhere_locator = By.xpath("//div[@id = 'content']//button");
    By latitude_locator = By.xpath("//div[@id = 'content']//div[@id='lat-value']");
    By longitude_locator = By.xpath("//div[@id = 'content']//div[@id='long-value']");


    public void ClickOnBtnWhere(){
        click(buttonWhere_locator);
    }


    public String getLatitudeText(){
        waitForElementToBePresent(latitude_locator);
        return getText(latitude_locator);
    }

    public String getLongitudeText(){
        waitForElementToBePresent(longitude_locator);
        return getText(longitude_locator);
    }









}
