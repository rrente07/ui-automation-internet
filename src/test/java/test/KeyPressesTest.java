package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyPressesTest extends BaseTest {

        private static final Logger logger = LoggerFactory.getLogger(KeyPressesTest.class);
        static HomePage homePage;
        static KeyPressesPage keyPressesPage;

        @BeforeAll
        static void setUp() {
        homePage = new HomePage(driver);
        keyPressesPage = new KeyPressesPage();
        }

   @Test
    public void testKeyPresses1() {
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses(); //
       String inputText = "K";
        keyPressesPage.insertKeyPressesInput(inputText);
        String caption = keyPressesPage.getKeyPressesText();
        String expected = keyPressesPage.getExpectedKeyPressText(inputText);
        assertEquals(expected, caption, "Caption title incorrect");
        System.out.println(expected);
        System.out.println(caption);
    }
    }



