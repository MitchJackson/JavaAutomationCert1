package PageObjects;

import SeleniumUtilities.SeleniumUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CopartHome_Page {
    private WebDriver _driver;
    SeleniumUtilities utils;

    public CopartHome_Page(WebDriver driver){
        _driver = driver;
    }

    //home page
    public By SearchBar = By.cssSelector("#input-search");
    public By SearchBtn = By.xpath("//form[@id=\"search-form\"]//button[contains(text(),\"Search\")]");
    public By MostPopularMakesModels_Links = By.xpath("//h4[text()=\"Makes/Models\"]/../../following-sibling::div//ul/li/a");

    //search results page
    public By MakeColumn = By.xpath("//table[@id=\"serverSideDataTable\"]//td[5]");
    public By ModelColumn = By.xpath("//table[@id=\"serverSideDataTable\"]//td[6]");
    public By DamageColumn = By.xpath("//table[@id=\"serverSideDataTable\"]//td[12]");
    public By NumberOfEntries_Select = By.xpath("//div[contains(@class,\"top\")]//select[@name=\"serverSideDataTable_length\"]");
    public By NumberOfEntries100_Option = By.xpath("//div[contains(@class,\"top\")]//select[@name=\"serverSideDataTable_length\"]/option[text()=\"100\"]");
    public By ModelSideFilter_Drawer = By.xpath("//h4[@class=\"panel-title\"]/a[text()=\"Model\"]");
    public By ModelSideFilterSearch_Input = By.xpath("//a[text()=\"Model\"]/ancestor::h4/following-sibling::div//input[@type=\"text\"]");
    public By ModelSideFilter_Checkbox(String model){ return By.xpath("//abbr[contains(text(),\"" + model + "\")]/preceding-sibling::input");}

    public void Search(String searchText){
        utils.SendKeys(_driver, SearchBar, searchText);
        utils.FindAndClick(_driver, SearchBtn);
    }
}
