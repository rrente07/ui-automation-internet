package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AuthenticationPage;
import pages.GeoLocationPage;
import pages.HomePage;
import pages.SecurelogginPage;

public class GeoLocationTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(GeoLocationTest.class);
    static HomePage homePage;
    static GeoLocationPage geoLocationPage;
   String expectLatitude = "26.1226496";
    String expectLongitude = "-80.19968";

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        geoLocationPage = new GeoLocationPage();

    }
    @Test
    public void VerifyLatitudeIsCorrect() {
    var AuthenticationPage =homePage.clickOnGeolocation();
        geoLocationPage.ClickOnBtnWhere();
        String currentLatitude = geoLocationPage.getLatitudeText();

        logger.info("The current password is: "+ currentLatitude );
        Assertions.assertEquals(currentLatitude, expectLatitude, "The geolocation is incorrect");
        String currentLongitude = geoLocationPage.getLongitudeText();
        logger.info("The current username is: "+ currentLongitude );
        Assertions.assertEquals(currentLongitude, expectLongitude, "The longitude is incorrect");
}}
