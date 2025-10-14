package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddDragAndDropPage extends BasePage{

    private final Logger logger = LoggerFactory.getLogger(AddDragAndDropPage.class);

    private By DrogAndDropColumnAPage_Locator = By.id("column-a");
    private By DrogAndDropColumnBPage_Locator = By.id("column-b");


    public void clickOnDragAndDropColumnA(){
        click(DrogAndDropColumnAPage_Locator);
    }

    public void clickOnDragAndDropColumnB(){
        click(DrogAndDropColumnBPage_Locator);
    }

        public WebElement findElementDragDropColumnA(){
        return findElement(DrogAndDropColumnAPage_Locator);
             }



    public WebElement findElementDragDropColumnB(){
        return findElement(DrogAndDropColumnBPage_Locator);
    }

    public String getTextDragAndDropColumnB(){
        WebElement element = findElement(DrogAndDropColumnBPage_Locator);
        String textColumnB = element.getText();
        return textColumnB;
    }

}
