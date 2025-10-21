package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentPage extends BasePage{

    private final Logger logger = LoggerFactory.getLogger(DynamicContentPage.class);

private By imageAvatar_Locator = By.xpath("//img[contains(@src, 'Avatar')]");
private By textblock_Locator =  By.xpath("//div[@id='content']//div[@class='large-10 columns']");

    //Returns the list of URLs of the images found
public  List<String> getSrc() {
   List<WebElement> imagesBefore = driver.findElements(imageAvatar_Locator);
   List<String> srcList = new ArrayList<>();
   for (WebElement img : imagesBefore) {
       srcList.add(img.getAttribute("src"));
             }
    return srcList;
}

//Returns the text of the blocks
public int getCountBlock(){
    List<WebElement> blockCount = driver.findElements(textblock_Locator);
    return blockCount.size();
}

//Returns the text
    public List<String> getTextBlock() {
        List<WebElement> textBlocks  = driver.findElements(textblock_Locator);
        List<String> textList = new ArrayList<>();

        for (WebElement block : textBlocks) {
            textList.add(block.getText());
        }
        return textList;
    }

}

