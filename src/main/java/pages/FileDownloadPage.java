package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileDownloadPage extends BasePage{

    private static final Logger logger = LoggerFactory.getLogger(FileDownloadPage.class);
    private By file1_Locator = By.xpath("//div[@class='example']//a[contains(@href,'/вурхез.jpg')]");
    private By file2_Locator = By.xpath("//div[@class='example']//a[contains(@href,'/some-file.txt')]");
    private By file3_Locator = By.xpath("//div[@class='example']//a[contains(@href,'/random_data.txt')]");

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
        String downloadPath = "src/test/resources/downloads";
       return isFileDownloaded(downloadPath, "some-file.txt");
    }

    public boolean isFileDownloaded2() {
        String downloadPath = "src/test/resources/downloads";
        return isFileDownloaded(downloadPath, "random_data.txt");
    }

    public boolean isFileDownloaded3() {
        String downloadPath = "src/test/resources/downloads";
        return isFileDownloaded(downloadPath, "вурхез.jpg");
    }
}