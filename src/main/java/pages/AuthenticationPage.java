package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationPage extends BasePage{

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationPage.class);

    private By usarnameInput_Locator = By.id("username");
    private By passwrordInput_Locator = By.id("password");
    private By loginBtn_Locator = By.className("radius");


String password = "SuperSecretPassword!";
String username = "tomsmith";

    public void typeUsername(){
        waitForElementToBePresent(usarnameInput_Locator);
        type(usarnameInput_Locator, username);
    }

    public void typePassword(){
        waitForElementToBePresent(passwrordInput_Locator);
        type(passwrordInput_Locator, password);
    }

    public String getPassword(){
         return getTextValue(passwrordInput_Locator);
    }
    public String getUsername(){
        return getTextValue(usarnameInput_Locator);
    }

    public void clickOnLoginBtn(){
        waitForElementToBeClickable(loginBtn_Locator);
        click(loginBtn_Locator);
    }

}
