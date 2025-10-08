package test;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.ChallengingDOMPage;
import pages.CheckboxesPages;
import pages.HomePage;

public class CheckboxesTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(CheckboxesTest.class);

    static HomePage homePage;
    static CheckboxesPages CheckboxesPages;

    @BeforeAll
    static void setUp() {
        CheckboxesPages = new CheckboxesPages();
        homePage = new HomePage(driver);
    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }


    @Test
    @DisplayName("Verify Checkboxes")
    public void checkBox1IsChecking() {
        CheckboxesPages = homePage.ClickOnCheckBox();
        CheckboxesPages.checking1();
        boolean check1 = CheckboxesPages.verifyCheckbox1IsCheckedByDefault();
        logger.info("The checkbox1 is checked:" + check1);
        Assertions.assertTrue(check1, "C“The checkbox1 is not checked.”");
    }



    @Test
    @DisplayName("Verify Checkboxes")
    public void Checkbox2IsChecking() {
        CheckboxesPages = homePage.ClickOnCheckBox();
        CheckboxesPages.checking2();
        boolean check2 = CheckboxesPages.verifyCheckbox2CheckedByDefault();
        logger.info("The checkbox2 is checked"  + check2);
        Assertions.assertTrue(check2, "The checkbox2 is not checked");
    }
}
