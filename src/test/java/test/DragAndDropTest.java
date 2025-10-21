package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AddDragAndDropPage;
import pages.HomePage;

import java.time.Duration;

public class DragAndDropTest extends BaseTest{

    private final Logger logger = LoggerFactory.getLogger(DragAndDropTest.class);

    static HomePage homePage;
    static AddDragAndDropPage addDragAndDropPage;

    @BeforeAll
    static void setUp() {
        addDragAndDropPage = new AddDragAndDropPage();
        homePage = new HomePage(driver);
    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("VerifyDragAndDrop")
    public void VerifyHomeLinkTest(){

        //Navigate to DragAndDrop Page
        addDragAndDropPage = homePage.clickOnAddDragAndDrop();

        //Attempt to click the DragAndDropColumnA link if it is present
        WebElement DragDropColumnA = addDragAndDropPage.findElementDragDropColumnA();
        WebElement DragDropColumnB = addDragAndDropPage.findElementDragDropColumnB();

        //Capture header text before drag
        String headerA_before = DragDropColumnA.findElement(By.tagName("header")).getText();
        String headerB_before = DragDropColumnB.findElement(By.tagName("header")).getText();

        // Perform drag and drop using Actions
        Actions actions = new Actions(driver);
        actions.dragAndDrop(DragDropColumnA, DragDropColumnB).perform();

        // Wait for DOM update
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.textToBePresentInElement(DragDropColumnA.findElement(By.tagName("header")), headerB_before));

        //Capture the header after the drag and drop
        // Capture header text after drag
        String headerA_after = DragDropColumnA.findElement(By.tagName("header")).getText();
        String headerB_after = DragDropColumnB.findElement(By.tagName("header")).getText();

        //Verify the Change
        Assertions.assertEquals(headerB_before, headerA_after, "Column A should now contain what was in Column B");
        Assertions.assertEquals(headerA_before, headerB_after, "Column B should now contain what was in Column A");

        logger.info("Header before the drag:");
        logger.info("Column A: " + headerA_before);
        logger.info("Column B: " + headerB_before);

        logger.info("Header after the drag:");
        logger.info("Column A: " + headerA_after);
        logger.info("Column B: " + headerB_after);
    }
    }




