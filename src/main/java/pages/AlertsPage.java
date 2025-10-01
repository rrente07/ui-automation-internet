package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AlertsPage extends BasePage {

public By trigger_JS_AlertButton_Locator = By.xpath("//button[contains(text(),'Click for JS Alert')]");
public By MessageAlertText_Locator = By.id("result");
public By getJsAlerts_Btn_Locator = By.xpath("//button[contains(text(),'Click for JS Alert')]");
public By getJsAlertsToConfirm_Btn_Locator = By.xpath("//button[contains(text(),'Click for JS Confirm')]");

    public void ClickAcceptAlertJS(){
        ClickAcceptAlert(getJsAlerts_Btn_Locator);
    }

    public void ClickAcceptAlertJSConfirm(){
        ClickAcceptAlert(getJsAlertsToConfirm_Btn_Locator);
    }


    public void ClickDismissAlertJSConfirm(){

        ClickDismissAlert(getJsAlertsToConfirm_Btn_Locator);

    }



    public String getMessageAlertText(){
        return getText(MessageAlertText_Locator);
}


    public boolean isElementVisibleAlert(){
        return isElementVisible(MessageAlertText_Locator);

    }


}
