package pages;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;


public class DropdownPage extends BasePage{

    public DropdownPage() {
    }

    private By DropdownPage_Locator = By.id("dropdown");


public void selectFromDropDown(String option){
    Select dropdownElement = findDropDownElement();
    dropdownElement.selectByVisibleText(option);
}


public List<String> getSelectedOption(){
    List<WebElement> dropElement = findDropDownElement().getAllSelectedOptions();
    return dropElement.stream().map(e->e.getText()).collect(Collectors.toList());
}

private Select findDropDownElement(){
    return new Select(driver.findElement(DropdownPage_Locator));
}


}

