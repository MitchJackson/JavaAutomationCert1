package challenge3;

import PageObjects.CopartHome_Page;
import SeleniumUtilities.SeleniumUtilities;
import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Loops extends TestBase {
    CopartHome_Page copart;
    SeleniumUtilities utils;

    @BeforeMethod
    public void startTest() throws Exception{
        copart = new CopartHome_Page(driver);
    }

    @Test()
    public void LoopThroughElements() throws Exception{
        driver.get(CopartURL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(copart.MostPopularMakesModels_Links));
        List<WebElement> mostPopular = driver.findElements(copart.MostPopularMakesModels_Links);

        for (WebElement el : mostPopular){
            System.out.println(el.getText() + " - " + el.getAttribute("href"));
        }
    }
}
