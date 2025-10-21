package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckboxesPages extends BasePage{

    private final Logger logger = LoggerFactory.getLogger(CheckboxesPages.class);

private By firstCheckbox_Locator = By.xpath("//form//input[normalize-space(following-sibling::text())='checkbox 1']");
private By secondCheckbox_Locator = By.xpath("//form//input[normalize-space(following-sibling::text())='checkbox 2']");


  public boolean verifyCheckbox1IsUncheckedByDefault() {
      return verifyCheckboxIsUncheckedByDefault(firstCheckbox_Locator);
    }

    public boolean verifyCheckbox2IsUncheckedByDefault() {
        return verifyCheckboxIsUncheckedByDefault(secondCheckbox_Locator);
    }


    public boolean verifyCheckbox1IsCheckedByDefault() {
        return verifyCheckboxIsCheckedByDefault(firstCheckbox_Locator);
    }

    public boolean verifyCheckbox2CheckedByDefault() {
        return verifyCheckboxIsCheckedByDefault(secondCheckbox_Locator);
    }

    public boolean checking1(){
       return markCheckbox(firstCheckbox_Locator);
    }

    public boolean checking2(){
        return markCheckbox(secondCheckbox_Locator);
    }
}





