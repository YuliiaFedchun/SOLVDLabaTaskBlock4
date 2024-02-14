package com.laba.solvd.task2.components;

import com.laba.solvd.task2.pages.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogComponent extends AbstractUIObject {
    @FindBy(xpath = ".//*[contains(@class,'menu-categories__link')]")
    private List<ExtendedWebElement> categories;

    @FindBy(xpath = ".//a[contains(text(),'%s')]")
    private ExtendedWebElement category;

    @FindBy(xpath = ".//li[contains(@class,'main-brand')]//a[@title='%s']")
    private ExtendedWebElement categoryBrandLogo;

    public CatalogComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void chooseCategory(String categoryName) {
        String dynamicXpath = String.format(".//a[contains(text(),'%s')]", categoryName);
        findExtendedWebElement(By.xpath(dynamicXpath)).hover();
    }

    public ProductPage openBrandCategoryPage(String categoryName, String brandName) {
        chooseCategory(categoryName);
        String dynamicXpath = String.format(".//li[contains(@class,'main-brand')]//a[@title='%s']", brandName);
        findExtendedWebElement(By.xpath(dynamicXpath)).click();
        return new ProductPage(getDriver());
    }

    public boolean isCategoriesUnitPresent() {
        return !categories.isEmpty();
    }
}
