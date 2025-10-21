package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicLoadingPage extends BasePage{

    private final Logger logger = LoggerFactory.getLogger(DynamicLoadingPage.class);
    private By DynamicLoading1_Locator = By.xpath("//div[@id='content']//div[@class='example']//a[contains(@href,'/dynamic_loading/1')]");
    private By DynamicLoading2_Locator = By.xpath("//div[@id='content']//div[@class='example']//a[contains(@href,'/dynamic_loading/2')]");

    public void clickOnDynamicLoading1(){
        click(DynamicLoading1_Locator);
    }

    public void clickOnDynamicLoading2(){
        click(DynamicLoading2_Locator);
    }


}
