package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DropdownPage;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoverTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(HoverTest.class);
    static HomePage homePage;
    static DropdownPage dropdownPage;

    @BeforeAll
    static void setUp() {
        homePage = new HomePage(driver);
    }

@Test
@DisplayName("Verify Hover Over")
    public void testHoverUser1(){
    var hoverPage = homePage.ClickOnHover();
    var caption = hoverPage.hoverOverFigure(2);
assertTrue(caption.isCaptionDisplayed(), "Caption not Displayed");
assertEquals( "name: user2", caption.getTitle(), "Caption title incorrect");
    assertEquals(caption.getLinkText(), "View profile", "Caption link text incorrect");

}

}
