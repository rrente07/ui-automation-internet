package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.SecurelogginPage;

public class AuthenticationTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationTest.class);


    static HomePage homePage;
    static AuthenticationPage authenticationPage;
    static SecurelogginPage securelogginPage;
    String expectPassword = "SuperSecretPassword!";
    String expectUsername = "tomsmith";

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        authenticationPage = new AuthenticationPage();
        securelogginPage = new SecurelogginPage();
        }

    @Test
    public void verifyAuthenticationIsCorrect() {
        var AuthenticationPage =homePage.clickOnAuthentication();
        authenticationPage.typePassword();
        authenticationPage.typeUsername();
        String currentPassword = authenticationPage.getPassword();
        logger.info("The current password is: "+ currentPassword );
        String currentUsername = authenticationPage.getUsername();
        logger.info("The current username is: "+ currentUsername );
        Assertions.assertEquals(expectPassword, currentPassword, "The password is correct");

}

    @Test
    public void loginCorrectTest() {
        var AuthenticationPage =homePage.clickOnAuthentication();
        authenticationPage.typePassword();
        authenticationPage.typeUsername();
        authenticationPage.clickOnLoginBtn();
        String currentSecureText = securelogginPage.getSecureText();
        String expectedSecureText = "You logged into a secure area!";
        Assertions.assertTrue(currentSecureText.contains(expectedSecureText), "Your are not login into the page");
    }


    @Test
    public void loginCorrectSecureAreaTest() {
        var AuthenticationPage =homePage.clickOnAuthentication();
        authenticationPage.typePassword();
        authenticationPage.typeUsername();
        authenticationPage.clickOnLoginBtn();
        String currentSecureText = securelogginPage.getSecureAreaText();
        logger.info("The current text is: " + currentSecureText);
        String expectedSecureText = "Welcome to the Secure Area. When you are done click logout below.";
        logger.info("The current text is: " + expectedSecureText);
        Assertions.assertTrue(currentSecureText.contains(expectedSecureText), "Your are not login into the page");
    }




}
