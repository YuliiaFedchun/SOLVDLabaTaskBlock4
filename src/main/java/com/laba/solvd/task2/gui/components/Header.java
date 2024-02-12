package com.laba.solvd.task2.gui.components;

import com.laba.solvd.task2.gui.pages.BrandPage;
import com.laba.solvd.task2.gui.pages.SideMenuPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {
    @FindBy(xpath = "//*[@placeholder='Я шукаю...']")
    private ExtendedWebElement searchInputField;
    @FindBy(xpath = "//*[contains(text(),'Знайти')]")
    private ExtendedWebElement searchButton;
    @FindBy(css = "#fat-menu")
    private ExtendedWebElement catalogButton;
    @FindBy(css = "header__logo")
    private ExtendedWebElement logo;
    @FindBy(xpath = "//*[contains(@class,'header__button')]")
    private ExtendedWebElement menuButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void openHomePage() {
        logo.click();
    }

    public BrandPage searchBrand(String info) {
        searchInputField.type(info);
        searchButton.click();
        return new BrandPage(getDriver());
    }

    public SideMenuPage openSideMenu() {
        menuButton.click();
        return new SideMenuPage(getDriver());
    }
}
