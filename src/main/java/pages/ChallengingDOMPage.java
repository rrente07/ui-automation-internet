package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChallengingDOMPage extends BasePage{

    private final Logger logger = LoggerFactory.getLogger(ChallengingDOMPage.class);

    private By foo_Btn_Locator = By.xpath("//div[@class='large-2 columns']//a[contains(@class,'button') and text()='foo']");
    private By bar_Btn_Locator = By.xpath("//div[@class='large-2 columns']//a[contains(@class,'button alert') and text()='bar']");
    private By foo2_Btn_Locator = By.xpath("//div[@class='large-2 columns']//a[contains(@class,'button success')]");
    private By table_Locator = By.xpath("//div[@class='large-10 columns']//table");
    private By canvas_btn_Locator = By.id("canvas");


    public File getCanvasScreenshot(){
        return getCanvasScreenshot(canvas_btn_Locator, "hola");

    }

    // Auxiliary method to compare image pixel by pixel
    public boolean compareImages(File fileA, File fileB) throws IOException {
        BufferedImage imgA = ImageIO.read(fileA);
        BufferedImage imgB = ImageIO.read(fileB);

        // if the dimensions are different, they are different
        if (imgA.getWidth() != imgB.getWidth() || imgA.getHeight() != imgB.getHeight()) {
            return false;
        }

        // Compare pixel by pixel
        for (int x = 0; x < imgA.getWidth(); x++) {
            for (int y = 0; y < imgA.getHeight(); y++) {
                if (imgA.getRGB(x, y) != imgB.getRGB(x, y)) {
                    return false;
                }
            }
        }
        return true; // they are the same
    }

    public void ClickOnBtnFoo(){
       WebElement element = driver.findElement(By.id("foo2_Btn_Locator"));
        element.click();
    }

}







