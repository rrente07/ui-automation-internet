package pages;

import org.openqa.selenium.By;

public class KeyPressesPage extends BasePage{

    public KeyPressesPage() {
    }


    private final By KeyPressInput_Locator = By.id("target");
    private final By KeyPressText_Locator = By.id("result");


            public void insertKeyPressesInput(String text){

                type(KeyPressInput_Locator, text);

}
            public String getKeyPressesText(){
            return getText(KeyPressText_Locator);
    }


    public String getExpectedKeyPressText(String input) {
        char lastChar = input.charAt(input.length() - 1);
         return "You entered: " + Character.toUpperCase(lastChar);
    }


}
