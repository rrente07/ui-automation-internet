package pages;

import org.openqa.selenium.By;

public class AlertsPage extends BasePage {

public By MessageAlertText_Locator = By.id("result");
public By getJsAlerts_Btn_Locator = By.xpath("//button[contains(text(),'Click for JS Alert')]");
public By getJsAlertsToConfirm_Btn_Locator = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
public By getJsAlertsToPrompt_Btn_Locator = By.xpath("//button[contains(text(),'Click for JS Prompt')]");


// Accepts a simple JavaScript alert after waiting for the button to be present
    public void ClickBtnAlertJS(){
        waitForElementToBePresent(getJsAlerts_Btn_Locator);
        ClickAcceptAlert(getJsAlerts_Btn_Locator);
    }
// Accepts a JS confirmation alert (OK/Cancel type)
    public void ClickBtnAlertJSConfirm(){
        waitForElementToBePresent(getJsAlertsToConfirm_Btn_Locator);
        ClickAcceptAlert(getJsAlertsToConfirm_Btn_Locator);
    }

    // Accepts a JS confirmation alert (OK/Cancel type)
    public void ClickBtnAlertJSPrompt(){
        waitForElementToBePresent(getJsAlertsToPrompt_Btn_Locator);
        ClickAcceptAlert(getJsAlertsToPrompt_Btn_Locator);
    }

// Dismisses a JS confirmation alert
    public void ClickDismissAlertJSConfirm(){
        ClickDismissAlert(getJsAlertsToConfirm_Btn_Locator);

    }

// Accepts a JS prompt alert
    public void triggerPromptAlertOnly(){
        waitForElementToBePresent(getJsAlertsToPrompt_Btn_Locator);
        triggerAlert(getJsAlertsToPrompt_Btn_Locator);
    }

// Dismisses a JS prompt alert
    public void ClickDismissAlertJSPrompt(){
        waitForElementToBePresent(getJsAlertsToPrompt_Btn_Locator);
        ClickDismissAlert(getJsAlertsToPrompt_Btn_Locator);
    }

    public String getMessageAlertText(){
        return getText(MessageAlertText_Locator);
}

    public boolean isElementVisibleAlert(){
        return isElementVisible(MessageAlertText_Locator);

    }


}
