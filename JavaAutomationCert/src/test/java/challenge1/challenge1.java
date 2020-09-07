package challenge1;

import org.testng.Assert;
import org.testng.annotations.*;
import TestBase.TestBase;

public class challenge1 extends TestBase {
    @Test ()
    public void goToGoogle() throws Exception{
        driver.get("https://www.google.com");
    }

    @Test()
    public void verifyGoogleTitle() throws Exception{
        Assert.assertEquals(driver.getTitle(), "Google");
    }
}
