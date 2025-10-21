package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicControlPage extends BasePage{

    private final Logger logger = LoggerFactory.getLogger(DynamicControlPage.class);
    private By checkbox_locator = By.xpath("//form[@id = 'checkbox-example']//input[@id = 'checkbox']");
    private By BtnAddRemove_locator = By.xpath("//form[@id = 'checkbox-example']//button[@type = 'button']");
    private By inputText_locator = By.xpath("//form[@id = 'input-example']//input[@type = 'text']");
    private By BtnDisableEnable_locator = By.xpath("//form[@id = 'input-example']//button[@type = 'button']");
    private By messageGoneBack_locator = By.xpath("//form[@id = 'checkbox-example']//p[@id = 'message']");
    private By messageEnable_locator = By.xpath("//form[@id = 'input-example']//p[@id = 'message']");

    public void WaitForAddRemoveBtn(){
         // Wait for button appear or dissapear
        wait.until(driver -> driver.findElements(BtnAddRemove_locator).size() == 1);
       }

    public void clickAddRemoveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(BtnAddRemove_locator)).click();
    }
      public String getDynamicMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageGoneBack_locator));
       WebElement element = findElement(messageGoneBack_locator);
       return element.getText();
      }

    public boolean checkboxIsPresent(){
    return !findElementsNow(checkbox_locator).isEmpty();

}
}


