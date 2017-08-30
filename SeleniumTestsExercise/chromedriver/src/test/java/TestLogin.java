import objects.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import static junit.framework.TestCase.assertTrue;

@SuppressWarnings("Duplicates")

public class TestLogin {

    private WebDriver driver;


    public TestLogin() throws IOException {
    }

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
        driver.get("http://phptravels.net/login");
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

    @Test
    public void testLoginInvalidUser() throws Exception {
        User nonExistentUser = new User("stefan@phptravels.com", "123456");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
        driver.get("http:////phptravels.net/login");
        Thread.sleep(2000);
        WebElement email=driver.findElement(By.name("username"));
        email.sendKeys(new CharSequence[]{nonExistentUser.getEmail()});
        Thread.sleep(2000);
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys(new CharSequence[]{nonExistentUser.getPassword()});
        Thread.sleep(2000);
        WebElement button=driver.findElement(By.className("btn"));
        button.click();
        Thread.sleep(2000);
        String url=driver.getCurrentUrl();
        assertTrue(url.equals("http://www.phptravels.net/login"));//done


    }


    @Test
    public void testLoginAndLogout() throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
        driver.get("http://phptravels.net/login");
        Thread.sleep(2000);
        WebElement email=driver.findElement(By.name("username"));
        email.sendKeys("user@phptravels.com");
        Thread.sleep(2000);
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("demouser");
        Thread.sleep(2000);
        WebElement button=driver.findElement(By.className("btn"));
        button.click();
        Thread.sleep(2000);
        String url=driver.getCurrentUrl();
        Thread.sleep(2000);
        WebElement profile=driver.findElement(By.className("pull-right"));
        profile.click();
        Thread.sleep(2000);
        WebElement logout = driver.findElement(By.xpath("//a[@href='http://www.phptravels.net/account/logout/']"));
        logout.click();
        Thread.sleep(3000);
        url=driver.getCurrentUrl();
        assertTrue(url.equals("http://www.phptravels.net/login"));

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
