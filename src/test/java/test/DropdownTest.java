package test;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DropdownPage;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropdownTest extends BaseTest{


    private static final Logger logger = LoggerFactory.getLogger(DropdownTest.class);
    static HomePage homePage;
    static DropdownPage dropdownPage;


    @BeforeAll
    static void setUp() {
        dropdownPage = new DropdownPage();
        homePage = new HomePage(driver);
    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }


    @Test
    public void SelectOptionTest(){
var dropDownPage = homePage.clickOnDropDown();
assertTrue(driver.getCurrentUrl().contains("/dropdown"), "Did not navigate to dropdown page");
String option1 = "Option 1";
dropDownPage.selectFromDropDown(option1);
var selectOptions = dropDownPage.getSelectedOption();
assertEquals(selectOptions.size(), 1, "Incorrect");
assertTrue(selectOptions.contains(option1), "Option not selected");
}





}
