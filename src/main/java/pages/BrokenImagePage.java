package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenImagePage extends BasePage{

    public By BrokenImage_Locator = By.cssSelector("div.example img");


    private final Logger logger = LoggerFactory.getLogger(BrokenImagePage.class);

    public List<String> validateBrokenImages() {
        List<WebElement> images = driver.findElements(BrokenImage_Locator);
        List<String> brokenSources = new ArrayList<>();

        for (WebElement image : images) {
            String src = image.getAttribute("src");

            try {

                URL imageUrl = new URL(src);
                HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();

                int responseCode = connection.getResponseCode();

                if (responseCode >= 400) {
                    logger.warn("Image broken (HTTP {}): {}", responseCode, imageUrl);
                    brokenSources.add(imageUrl.toString());
                } else {
                    logger.info("Image broken (HTTP {}): {}", responseCode, imageUrl);
                }
            } catch (Exception e) {
                logger.error("Error in the image verification: {} → {}", src, e.getMessage());
                brokenSources.add(src); // If we cannot verify it, I consider it broken as well.
            }
        }

        return brokenSources;
    }


}
