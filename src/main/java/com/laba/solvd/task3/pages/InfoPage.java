package com.laba.solvd.task3.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InfoPage extends AbstractPage {

    @FindBy(xpath = "//*[@text='Shafa.ua']")
    private ExtendedWebElement logo;

    public InfoPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }
}
