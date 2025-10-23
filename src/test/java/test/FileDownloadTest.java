package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Entry_AdPage;
import pages.FileDownloadPage;
import pages.HomePage;
import utils.Utility;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileDownloadTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(FileDownloadTest.class);


    static HomePage homePage;
    static FileDownloadPage fileDownloadPage;

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        fileDownloadPage = new FileDownloadPage();
        homePage = new HomePage(driver);
    }

}
