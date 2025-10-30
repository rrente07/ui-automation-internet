package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static config.Configuration.DOWNLOAD_PATH;

public class FileDownloadPage extends BasePage{

    private static final Logger logger = LoggerFactory.getLogger(FileDownloadPage.class);
    private By file1_Locator = By.xpath("//div[@class='example']//a[contains(@href,'download/ghost2.jpg')]");
    private By file2_Locator = By.xpath("//div[@class='example']//a[contains(@href,'download/tmpyzvf6u7j.txt')]");
    private By file3_Locator = By.xpath("//div[@class='example']//a[contains(@href,'download/avatar-woman-indian.svg')]");

    public void clickOnDownloadFile1(){
        clickOnDownloadFile(file1_Locator);
  }

  public void clickOnDownloadFile2(){
        clickOnDownloadFile(file2_Locator);
    }

    public void clickOnDownloadFile3(){

        clickOnDownloadFile(file3_Locator);
    }

    public boolean isFileDownloaded1() {
         return isFileDownloaded(DOWNLOAD_PATH, "ghost2.jpg");
    }

    public boolean isFileDownloaded2() {
        return isFileDownloaded(DOWNLOAD_PATH, "tmpyzvf6u7j.txt");
    }

    public boolean isFileDownloaded3() {
        return isFileDownloaded(DOWNLOAD_PATH, "avatar-woman-indian.svg");
    }

    /**
     * Espera robustamente hasta que el archivo exista y se haya terminado de descargar.
     */
    // Función auxiliar para esperar la descarga
    public boolean waitForDownload(Path filePath, int timeoutSeconds) throws InterruptedException {
        int waited = 0;
        while (waited < timeoutSeconds) {
            if (Files.exists(filePath) && !filePath.toString().endsWith(".crdownload")) {
                return true;
            }
            Thread.sleep(1000);
            waited++;
        }
        return false;
    }
}