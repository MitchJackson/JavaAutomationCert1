package challenge6;

import PageObjects.CopartHome_Page;
import SeleniumUtilities.SeleniumUtilities;
import TestBase.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ErrorHandling extends TestBase {
    CopartHome_Page copart;
    SeleniumUtilities utils;

    @BeforeMethod
    public void startTest() throws Exception{
        copart = new CopartHome_Page(driver);
    }

    @Test()
    public void NissanSearchErrorCatch() throws Exception {
        try{
            driver.get(CopartURL);
            copart.Search("Nissan");
            utils.FindAndClick(driver, copart.ModelSideFilter_Drawer);
            utils.SendKeys(driver, copart.ModelSideFilterSearch_Input, "skyline");
            utils.FindAndClick(driver, copart.ModelSideFilter_Checkbox("Skylinex"));
        } catch(Exception e){
            TakesScreenshot scrShot = ((TakesScreenshot)driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File("/JavaAutomation/test.png");
            FileUtils.copyFile(SrcFile, DestFile);
        }

    }
}
