package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Dynamic_LoadingPage1 extends BasePage{

    private final Logger logger = LoggerFactory.getLogger(Dynamic_LoadingPage1.class);


private By StartBtn_Locator = By.xpath("//div[@id='start']//button[normalize-space(text())='Start']");
private By HelloWorldText_Locator = By.xpath("//div[@id='finish']//h4[normalize-space(text())='Hello World!']");


public void clickOnStartBtn(){
    click(StartBtn_Locator);
}

public String getTextLoading (){
    By finishLocator = HelloWorldText_Locator;

    // Wait for elemento to be present
    wait.until(driver -> {
        WebElement element = driver.findElement(finishLocator);
        String text = element.getText();
        return text != null && !text.trim().isEmpty();
    });

    return getText(finishLocator);
}



}
