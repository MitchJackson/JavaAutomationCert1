package challenge2;

import PageObjects.CopartHome_Page;
import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import SeleniumUtilities.SeleniumUtilities;
import java.time.Duration;

public class PorscheAssert extends TestBase {
    CopartHome_Page copart;
    SeleniumUtilities utils;

    @BeforeMethod
    public void startTest() throws Exception{
        copart = new CopartHome_Page(driver);
    }

    @Test()
    public void AssertPorscheExists() throws Exception{
        driver.get(CopartURL);
        copart.Search("exotics");

        wait.until(ExpectedConditions.visibilityOfElementLocated(copart.MakeColumn));
        var makes = driver.findElements(copart.MakeColumn);
        Boolean porscheFound = false;
        for (WebElement el : makes){
            String elText = el.getText();
            if (elText.toLowerCase().equals("porsche")){
                porscheFound = true;
                break;
            }
        }

        Assert.assertTrue(porscheFound, "Porsche is not found after searching 'exotics'.");
    }
}
