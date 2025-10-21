package test;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DynamicContentPage;
import pages.HomePage;

import java.util.List;

public class DynamicContentTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(DynamicContentTest.class);

    static HomePage homePage;
    static DynamicContentPage dynamicContentPage;

    @BeforeAll
    static void setUp() {
        dynamicContentPage = new DynamicContentPage();
        homePage = new HomePage(driver);
    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }


    //Verify that the content actually changes

    @Test
    @DisplayName("Verify DynamicImages")
    public void verifyImageLoading(){

    homePage.clickOnDynamicContent();
    List<String> srcBefore = dynamicContentPage.getSrc();
        System.out.println("Print: " + srcBefore);
    driver.get(driver.getCurrentUrl());
    List<String> srcAfter = dynamicContentPage.getSrc();
        System.out.println("Print: " + srcAfter);
    boolean changed = !srcBefore.equals(srcAfter);

    System.out.println("Changed: " + changed);

    Assertions.assertTrue(changed, "The images do no change after the refresh");
}

//Verify there are 3 blocks of contents

    @Test
    @DisplayName("Verify Content")
    public void verifyContent() {
homePage.clickOnDynamicContent();
int size = dynamicContentPage.getCountBlock();
        System.out.println("The size is: " +size);
Assertions.assertTrue(size>0,  "No se encontró ninguna fila de contenido" );
    }

    //Verify the integrity of the images
    @Test
    @DisplayName("Verify Images Integrity")
public void verifyImagesIntegrity(){
        homePage.clickOnDynamicContent();
        // Obtain the list of src of images using the method
        List<String> srcList = dynamicContentPage.getSrc();

        //Go through the list and verify the integrity
        for (String src : srcList){
        //Verify is not empty or null
            Assertions.assertNotNull(src, "The src of the images is null");
            Assertions.assertFalse(src.isEmpty(), "The src of the image is empty");

            //Verify it contain the "jpg"
            Assertions.assertTrue(src.endsWith(".jpg"), "The src of te image contain '.jpg':" + src);
            System.out.println("Image OK: " + src);
        }


}
    @Test
    @DisplayName("Verify the integrity of the text")
    public void VerifyTextIntegrity(){
        homePage.clickOnDynamicContent();
        //Obtain the list of text

        List<String> texts = dynamicContentPage.getTextBlock();

        for (String text : texts ){
            //the are present and not empty
            Assertions.assertNotNull(text, "The text is not null");
            Assertions.assertFalse(text.trim().isEmpty(), "The text is empty");

            //Verify the length of text
            Assertions.assertTrue(text.length()>100, "the text is to short: " + text );
            System.out.println("Text OK:" + text);

        }


    }

}
