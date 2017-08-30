import objects.Flight;
import objects.KeyActions;
import objects.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

@SuppressWarnings("Duplicates")

public class TestHotels extends KeyActions {

    private WebDriver driver;
    public TestHotels() throws Exception{}

    public void hitTab(int hits){

        for(int i=0;i<hits;i++){
            Actions action = new Actions(driver);
            action.sendKeys(Keys.TAB).build().perform();
        }}

    @Before
    public void setUp() throws Exception {
        String exePath = "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
    }

    @Test
    public void searchHotel() throws Exception {
        Flight flight = new Flight();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
        driver.get("http://phptravels.net/");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a[href*='hotels']")).click();
        Thread.sleep(3000);
        WebElement hotels = driver.findElement(By.className("select2-chosen"));
        hotels.click();
        Thread.sleep(1000);
        WebElement hotelText = driver.findElement(By.className("select2-input"));
        hotelText.sendKeys("Dubai");
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);
        hitTab(5);
        Thread.sleep(1000);
        action.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        String current = driver.getCurrentUrl();
        assertTrue(current.equals("http://www.phptravels.net/hotels/search/united-arab-emirates/dubai/6?txtSearch=Dubai+%2C+United+Arab+Emirates&checkin=30%2F08%2F2017&checkout=31%2F08%2F2017&adults=2&child=0&searching=6&modType=location"));



    }

    @After
    public void tearDown() throws Exception {
        try {
            driver.close();
            driver.quit();
        }
        catch (Exception ignored)
        {
        }
    }
}
