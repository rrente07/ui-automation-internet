    package test;

    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.Test;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import pages.AlertsPage;
    import pages.HomePage;

    public class AlertsTest extends BaseTest{


        private static final Logger logger = LoggerFactory.getLogger(DropdownTest.class);
        static HomePage homePage;
        static AlertsPage alertsPage;


        @BeforeAll
        static void setUp() {
            alertsPage = new AlertsPage();
            homePage = new HomePage(driver);

        }

        @Test
        public void testAcceptAlert(){
                alertsPage = homePage.ClickOnAlertsJS();
                System.out.println("Current URL: " + driver.getCurrentUrl());
                System.out.println("Trying to accept alert...");
                alertsPage.ClickAcceptAlertJS(); // ya incluye espera y aceptación
            boolean isPresent = alertsPage.isElementVisibleAlert();
            Assertions.assertTrue(isPresent, "Result message not visible");
            String alertText = alertsPage.getMessageAlertText();
            Assertions.assertEquals("You successfully clicked an alert", alertText, "Failed");
            }

        @Test
        public void testAcceptAlertJSConfirm(){
            alertsPage = homePage.ClickOnAlertsJSConfirm();
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Trying to accept alert to Confirm...");
            alertsPage.ClickAcceptAlertJSConfirm(); // ya incluye espera y aceptación
            boolean isPresent = alertsPage.isElementVisibleAlert();
            Assertions.assertTrue(isPresent, "Result message not visible");
            String alertText = alertsPage.getMessageAlertText();
            Assertions.assertEquals("You clicked: Ok", alertText, "Failed");
        }

        @Test
        public void testDismissAlert(){
            alertsPage = homePage.ClickOnAlertsJSConfirm();
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Trying to accept alert to Confirm...");
            alertsPage.ClickDismissAlertJSConfirm(); // ya incluye espera y aceptación
            boolean isPresent = alertsPage.isElementVisibleAlert();
            Assertions.assertTrue(isPresent, "Result message not visible");
            String alertText = alertsPage.getMessageAlertText();
            Assertions.assertEquals("You clicked: Cancel", alertText, "Failed");
            System.out.println("Result message after dismiss: " + alertText);

        }

    }
