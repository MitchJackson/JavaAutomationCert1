package challenge5;

import PageObjects.CopartHome_Page;
import SeleniumUtilities.SeleniumUtilities;
import TestBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class IfElseSwitch extends TestBase {
    CopartHome_Page copart;
    SeleniumUtilities utils;

    @BeforeMethod
    public void startTest() throws Exception{
        copart = new CopartHome_Page(driver);
    }

    @Test()
    public void PorscheModelTypesAndDamage() throws Exception{
        driver.get(CopartURL);
        copart.Search("porsche");

        wait.until(ExpectedConditions.visibilityOfElementLocated(copart.MakeColumn));

        utils.FindAndClick(driver, copart.NumberOfEntries_Select);
        utils.FindAndClick(driver, copart.NumberOfEntries100_Option);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List<WebElement> damage = new ArrayList<WebElement>();
        List<WebElement> models = new ArrayList<WebElement>();
        while(models.size() < 100){
            models = driver.findElements(copart.ModelColumn);
            damage = driver.findElements(copart.DamageColumn);
        }

        List<String> modelTextArr = new ArrayList<String>();
        for (WebElement el : models){
            String elText = el.getText();
            modelTextArr.add(elText);
        }
        Collections.sort(modelTextArr);



        System.out.println("Porsche models: ");
        Set<String> st = new HashSet<>(modelTextArr);
        for (String s : st){
            System.out.println(s + ": " + Collections.frequency(modelTextArr, s));
        }

        int rearEndCount = 0;
        int frontEndCount = 0;
        int dentScratchCount = 0;
        int undercarriageCount = 0;
        int miscCount = 0;
        for(WebElement el : damage){
            String text = el.getText();

            switch(text){
                case "REAR END":
                    rearEndCount++;
                    break;
                case "FRONT END":
                    frontEndCount++;
                    break;
                case "MINOR DENT/SCRATCHES":
                    dentScratchCount++;
                    break;
                case "UNDERCARRIAGE":
                    undercarriageCount++;
                    break;
                default:
                    miscCount++;
                    break;
            }
        }

        System.out.println("");
        System.out.println("Rear end damage: " + rearEndCount);
        System.out.println("Front end damage: " + frontEndCount);
        System.out.println("Minor dent and scratch damage: " + dentScratchCount);
        System.out.println("Undercarriage damage: " + undercarriageCount);
        System.out.println("Misc damage: " + miscCount);
    }
}
