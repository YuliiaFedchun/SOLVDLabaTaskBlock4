package com.laba.solvd.task2.gui.components;

import com.laba.solvd.task2.gui.pages.CatalogItemPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainCatalogItem extends AbstractUIObject {
    @FindBy(xpath = ".//*[@class='main-categories__icon']")
    private ExtendedWebElement catalogItemIcon;
    @FindBy(xpath = ".//*[contains(@class, 'main-categories__link')]")
    private ExtendedWebElement catalogItemButton;

    public MainCatalogItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CatalogItemPage openCatalogItemPage() {
        catalogItemButton.click();
        return new CatalogItemPage(getDriver());
    }

    public String getCatalogItemName() {
        return catalogItemButton.getText();
    }
}
