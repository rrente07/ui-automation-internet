package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecurelogginPage extends BasePage{

    private By secureText_Locator = By.id("flash");
    private By logoutBtn_Locator = By.cssSelector(".button.secondary.radius");
    private By welcomeSecureAreaText_Locator = By.className("subheader");

    public String getSecureText(){
        return getText(secureText_Locator);
    }

    public String getSecureAreaText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeSecureAreaText_Locator)).getText();

    }

    public String getWelcomeSecureAreText(){
        return getText(welcomeSecureAreaText_Locator);
    }

    public boolean IsbLogoutBtnVisible(){
        waitForElementToBeClickable(logoutBtn_Locator);
        return IsDisplayed(logoutBtn_Locator);

    }



}
