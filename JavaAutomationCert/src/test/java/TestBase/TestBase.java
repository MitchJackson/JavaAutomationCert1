package TestBase;

import PageObjects.CopartHome_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;
    public WebDriverWait wait;
    public String CopartURL = "https://www.copart.com/";

    @BeforeSuite
    public void startSuite() throws Exception{
        System.setProperty("webdriver.chrome.driver", "./bin/chromedriver.exe");
    }

    @BeforeClass
    public void startClass() throws Exception{
        driver =  new ChromeDriver();

        Duration timeout = Duration.ofSeconds(5);
        Duration polling = Duration.ofMillis(500);
        wait = new WebDriverWait(driver, 15);
    }

    @AfterClass
    public void stopClass(){
        driver.quit();
    }

    @AfterSuite
    public void stopSuite() throws Exception {
        System.out.println("All done!!!");
    }
}
