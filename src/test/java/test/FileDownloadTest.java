package test;

import config.BrowserType;
import config.Configuration;
import config.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Entry_AdPage;
import pages.FileDownloadPage;
import pages.HomePage;
import utils.Utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import static config.Configuration.DOWNLOAD_PATH;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Utility.clearDownloadFolder;
import static utils.Utility.waitForNewFile;

public class FileDownloadTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(FileDownloadTest.class);


    static HomePage homePage;
    static FileDownloadPage fileDownloadPage;

    static Utility utility;

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        fileDownloadPage = new FileDownloadPage();
        Utility utility = new Utility();
        clearDownloadFolder(DOWNLOAD_PATH);
    }

    @Test
    public void testDownload() throws Exception {
        int count = 0;
        var fileDownloadPage =homePage.clickOnDownload();

        // Wait for the links
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> links = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#content a"))
        );

        assertFalse(links.isEmpty(), "No se encontraron enlaces de descarga");

        // Download al the pages
        for (WebElement link : links) {
            String fileName = link.getText().trim();
            Path downloadedFile = Paths.get(Configuration.DOWNLOAD_PATH, fileName);


            // Delete the files
            if (Files.exists(downloadedFile)) {
                Files.delete(downloadedFile);
            }

            // Click to download
            link.click();

            // Wait for download
            boolean downloaded = fileDownloadPage.waitForDownload(downloadedFile, 15);
            if (downloaded){
                count ++;
            }
            assertTrue(downloaded, "El archivo no se descargó: " + fileName);

        }
        logger.info("The count of links downloading was:" + count);
    }

         @AfterEach
        public void tearDown() {
            clearDownloadFolder(DOWNLOAD_PATH);
        }
    }







