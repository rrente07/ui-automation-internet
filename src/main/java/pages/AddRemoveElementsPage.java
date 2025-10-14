    package pages;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedCondition;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

    import java.util.List;

    public class AddRemoveElementsPage extends BasePage {

       private final Logger logger = LoggerFactory.getLogger(AddRemoveElementsPage.class);

        public By addElement_Btn_Locator = By.xpath("//button[contains(text(),'Add Element')]");
        public By delete_Btn_Locator = By.className("added-manually");

        public void clickAddElement(){
            click(addElement_Btn_Locator);
        }
        public void clickDeleteElement(){
            click(delete_Btn_Locator);
        }
        public boolean isVisibleDeleteBtn(){
            return isElementVisible(delete_Btn_Locator);
        }
       public boolean  isHidDeleteBtn(){
            return IsDisplayed(delete_Btn_Locator);
        }
        public int countDeleteButtons() {
            return driver.findElements(delete_Btn_Locator).size();
        }
        public void addMultipleDeleteButtons(int count) {
            for (int i = 0; i < count; i++) {
                clickAddElement();
                }
        }
        public int removeDeleteButtons(int count) {
            int deleted = 0;
            List<WebElement> buttons = findElements(delete_Btn_Locator);

            while (!buttons.isEmpty() && deleted < count) {
                try {
                    WebElement button = buttons.get(0); // siempre el primero
                    button.click();
                    wait.until(ExpectedConditions.stalenessOf(button)); // espera que desaparezca
                    deleted++;
                    buttons = findElements(delete_Btn_Locator); // actualiza la lista
                } catch (Exception e) {
                    logger.error("Error al eliminar el botón número {}: {}", deleted + 1, e.getMessage());
                    break;
                }
            }

            if (deleted < count) {
                logger.warn("Solo se pudieron eliminar {} botones. Se solicitaron {}.", deleted, count);
            } else {
                logger.info("Se eliminaron {} botones correctamente.", count);
            }
            return deleted;
        }

        public int SizeTemp(){
            List<WebElement> temp = findElements(delete_Btn_Locator);
            return temp.size();
        }
    }

