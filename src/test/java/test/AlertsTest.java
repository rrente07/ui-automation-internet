    package test;

    import lombok.extern.java.Log;
    import org.junit.jupiter.api.*;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import pages.AlertsPage;
    import pages.HomePage;

    public class AlertsTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(AlertsTest.class);


        static HomePage homePage;
        static AlertsPage alertsPage;


        @BeforeAll
        static void setUp() {
            alertsPage = new AlertsPage();
            homePage = new HomePage(driver);
        }

        @BeforeEach
        void setUpEach() {
            driver.get("https://the-internet.herokuapp.com/");
            homePage = new HomePage(driver);
        }


        @Test
        @DisplayName("Verify that we click on the button JavaScript Alerts and display Click for JS Alert")
        public void testAcceptAlert(){
                alertsPage = homePage.ClickOnAlertsJS();
                logger.info("Current URL: " + driver.getCurrentUrl());
                logger.info("Trying to accept alert...");
                alertsPage.ClickBtnAlertJS(); // that include wait and acceptation
            boolean isPresent = alertsPage.isElementVisibleAlert();
            Assertions.assertTrue(isPresent, "Result message not visible");
            String alertText = alertsPage.getMessageAlertText();
            Assertions.assertEquals("You successfully clicked an alert", alertText, "Failed");
            }


        @Test
        @DisplayName("Verify that we click on the button JavaScript Alerts and display Click for JS Confirm")
        public void testAcceptAlertJSConfirm(){
            alertsPage = homePage.ClickOnAlertsJS();
            logger.info("Current URL: " + driver.getCurrentUrl());
            logger.info("Trying to accept alert to Confirm...");
            alertsPage.ClickBtnAlertJSConfirm(); // ya incluye espera y aceptación
            boolean isPresent = alertsPage.isElementVisibleAlert();
            Assertions.assertTrue(isPresent, "Result message not visible");
            String alertText = alertsPage.getMessageAlertText();
            Assertions.assertEquals("You clicked: Ok", alertText, "Failed");
        }


        @Test
        @DisplayName("Verify that we click on the button JavaScript Alerts and dismiss Click for JS Confirm")
        public void testDismissAlert(){
            alertsPage = homePage.ClickOnAlertsJS();
            logger.info("Current URL: " + driver.getCurrentUrl());
            logger.info("Trying to accept alert to Confirm...");
            alertsPage.ClickDismissAlertJSConfirm(); // ya incluye espera y aceptación
            boolean isPresent = alertsPage.isElementVisibleAlert();
            Assertions.assertTrue(isPresent, "Result message not visible");
            String alertText = alertsPage.getMessageAlertText();
            Assertions.assertEquals("You clicked: Cancel", alertText, "Failed");
            System.out.println("Result message after dismiss: " + alertText);

        }


        @Test
        @DisplayName("Verify that we click on the button JavaScript Alerts and display Click for JS Prompt")
        public void testAcceptAlertPrompt()
        {
            alertsPage = homePage.ClickOnAlertsJS();
            logger.info("Current URL: " + driver.getCurrentUrl());
            logger.info("Trying to Click for JS Prompt...");

            alertsPage.triggerPromptAlertOnly();
            String message = "test";
            homePage.sendKeysToAlert(message);

            boolean isPresent = alertsPage.isElementVisibleAlert();
            Assertions.assertTrue(isPresent, "Result message not visible");

            String alertText = alertsPage.getMessageAlertText();
            Assertions.assertEquals("You entered: " + message,alertText , "Failed");
            System.out.println("Result when we entered the test into the alert: " + message);

        }
    }
