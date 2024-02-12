package com.laba.solvd.task2.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogItemPage extends BasePage {
    @FindBy(xpath = "//*[contains(@class, 'portal__heading')]")
    private ExtendedWebElement title;

    public CatalogItemPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    public String getItemName() {
        return title.getText();
    }
}
