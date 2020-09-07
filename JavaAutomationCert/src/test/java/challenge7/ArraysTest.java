package challenge7;

import PageObjects.CopartHome_Page;
import SeleniumUtilities.SeleniumUtilities;
import TestBase.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest extends TestBase {
    CopartHome_Page copart;
    SeleniumUtilities utils;

    @BeforeMethod
    public void startTest() throws Exception{
        copart = new CopartHome_Page(driver);
    }

    @Test()
    public void NissanSearchErrorCatch() throws Exception {
        driver.get(CopartURL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(copart.MostPopularMakesModels_Links));
        List<WebElement> mostPopular = driver.findElements(copart.MostPopularMakesModels_Links);


        List<String> text = new ArrayList<>();
        List<String> hrefs = new ArrayList<>();
        for (WebElement el : mostPopular){
            text.add(el.getText());
            hrefs.add(el.getAttribute("href"));
        }

        for (int i = 0; i < text.size(); i++){
            String linkUrl = hrefs.get(i);
            driver.get(linkUrl);
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains(linkUrl), text.get(i) +
                    " link is supposed to send the user to " + linkUrl +
                    " but instead sent them to " + currentUrl);
        }
    }
}
