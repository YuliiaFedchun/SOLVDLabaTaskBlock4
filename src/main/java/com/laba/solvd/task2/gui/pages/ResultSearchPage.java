package com.laba.solvd.task2.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ResultSearchPage extends BasePage{
    @FindBy(xpath="//*[contains(@class,'search-heading')]")
    protected ExtendedWebElement searchResultTitle;
    public ResultSearchPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchResultTitle);
    }
}
