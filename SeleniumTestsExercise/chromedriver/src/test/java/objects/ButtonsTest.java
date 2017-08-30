package objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static junit.framework.TestCase.assertTrue;
@SuppressWarnings("Duplicates")
public class ButtonsTest {


    private WebDriver driver;
    public void ButtonTest()throws Exception{}

    @Before
    public void setUp() throws Exception {
        String exePath = "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
    }

    @Test
    public void testLoginRealUser() throws Exception {
        User realUser = new User("user@phptravels.com", "demouser");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
        driver.get("http:////phptravels.net/login");
        Thread.sleep(2000);
        WebElement email=driver.findElement(By.name("username"));
        email.sendKeys(new CharSequence[]{realUser.getEmail()});
        Thread.sleep(2000);
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys(new CharSequence[]{realUser.getPassword()});
        Thread.sleep(2000);
        WebElement button=driver.findElement(By.className("btn"));
        button.click();
        Thread.sleep(2000);
        String url=driver.getCurrentUrl();
        assertTrue(url.equals("http://www.phptravels.net/account/"));//done
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
