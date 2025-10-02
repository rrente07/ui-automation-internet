package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage extends BasePage {

    public HoversPage() {
    }



    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");

    public FigureCaption hoverOverFigure (int index){
        WebElement figure = driver.findElements(figureBox).get(index-1);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
return new FigureCaption(figure.findElement(boxCaption));
        }

        public class FigureCaption{
            private WebElement caption;
            private By header = By.tagName("h5");
            private By link = By.tagName("a");

            public FigureCaption (WebElement caption){
                this.caption = caption;
        }

        public boolean isCaptionDisplayed(){
                return caption.isDisplayed();
        }

        public String getTitle(){
                return caption.findElement(header).getText();
        }

    public String getLinkText(){
                return caption.findElement(link).getText();
    }

    }


}
