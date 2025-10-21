package pages;

import org.openqa.selenium.By;

public class AlertsPage extends BasePage {

public By MessageAlertText_Locator = By.id("result");
public By getJsAlerts_Btn_Locator = By.xpath("//button[contains(text(),'Click for JS Alert')]");
public By getJsAlertsToConfirm_Btn_Locator = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
public By getJsAlertsToPrompt_Btn_Locator = By.xpath("//button[contains(text(),'Click for JS Prompt')]");


// Accepts a simple JavaScript alert after waiting for the button to be present
    public void clickBtnAlertJS(){
        waitForElementToBePresent(getJsAlerts_Btn_Locator);
        clickAcceptAlert(getJsAlerts_Btn_Locator);
    }
// Accepts a JS confirmation alert (OK/Cancel type)
    public void clickBtnAlertJSConfirm(){
        waitForElementToBePresent(getJsAlertsToConfirm_Btn_Locator);
        clickAcceptAlert(getJsAlertsToConfirm_Btn_Locator);
    }

    // Accepts a JS confirmation alert (OK/Cancel type)
    public void clickBtnAlertJSPrompt(){
        waitForElementToBePresent(getJsAlertsToPrompt_Btn_Locator);
        clickAcceptAlert(getJsAlertsToPrompt_Btn_Locator);
    }

// Dismisses a JS confirmation alert
    public void clickDismissAlertJSConfirm(){
        clickDismissAlert(getJsAlertsToConfirm_Btn_Locator);

    }

// Accepts a JS prompt alert
    public void triggerPromptAlertOnly(){
        waitForElementToBePresent(getJsAlertsToPrompt_Btn_Locator);
        triggerAlert(getJsAlertsToPrompt_Btn_Locator);
    }

// Dismisses a JS prompt alert
    public void clickDismissAlertJSPrompt(){
        waitForElementToBePresent(getJsAlertsToPrompt_Btn_Locator);
        clickDismissAlert(getJsAlertsToPrompt_Btn_Locator);
    }

    public String getMessageAlertText(){
        return getText(MessageAlertText_Locator);
}

    public boolean isElementVisibleAlert(){
        return isElementVisible(MessageAlertText_Locator);

    }


}
