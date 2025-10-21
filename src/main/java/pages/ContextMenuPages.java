package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContextMenuPages extends BasePage{

    private final Logger logger = LoggerFactory.getLogger(ContextMenuPages.class);
    private By contextMenu_locator = By.id("hot-spot");


public void verifyContextMenuDisplayed(){
    Actions actions = new Actions(driver);
    WebElement hotSpot = driver.findElement(contextMenu_locator);
    actions.contextClick(hotSpot).perform();
    }

}
