package objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyActions {
    public WebDriver driver;
        public void hitTheTab(int hits){

        Actions hitTab = new Actions(driver);
        for(int i=0;i<hits;i++){

            hitTab.sendKeys(Keys.TAB).build().perform();
        }


    }
}
