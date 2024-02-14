package com.laba.solvd.task2.components;

import com.laba.solvd.task2.pages.HelpCenterPage;
import com.laba.solvd.task2.pages.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractUIObject {
    @FindBy(xpath = "//*[@placeholder='Я шукаю...']")
    private ExtendedWebElement searchInputField;

    @FindBy(xpath = "//*[contains(text(),'Знайти')]")
    private ExtendedWebElement searchButton;

    @FindBy(css = "#fat-menu")
    private ExtendedWebElement catalogButton;

    @FindBy(xpath = "//*[@class='header__logo']")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//button[@aria-label='Відкрити меню']")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//*[contains(@class,'side-menu drawer-content')]")
    private SideMenuComponent sideMenu;

    @FindBy(xpath = "//ul[contains(@class,'menu-categories')]")
    private CatalogComponent catalog;

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void openHomePage() {
        logo.click();
    }

    public ProductPage searchInfo(String info) {
        searchInputField.type(info);
        searchButton.click();
        return new ProductPage(getDriver());
    }

    public void openSideMenu() {
        menuButton.click();
    }

    public boolean isSideMenuOpened() {
        return sideMenu.isLogoPresent();
    }

    public HelpCenterPage openHelpCenterPage() {
        return sideMenu.openHelpCenterPage();
    }

    public void openCatalog() {
        catalogButton.click();
    }

    public boolean isCatalogOpened() {
        return catalog.isCategoriesUnitPresent();
    }

    public ProductPage openBrandPageThroughCatalog(String categoryName, String brandName) {
        return catalog.openBrandCategoryPage(categoryName, brandName);
    }
}
