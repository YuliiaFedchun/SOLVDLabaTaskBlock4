package com.laba.solvd.task2.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(xpath = "//*[contains(@class,'top-wrap--skeleton')]")
    private ExtendedWebElement mainBanner;
    @FindBy(xpath = "//*[@class='menu-categories__link']")
    private List<ExtendedWebElement> catalogItems;

    @FindBy(xpath = "//*[contains(@class, 'main-slider')]//*[contains(text(),' Всі акції')]")
    private ExtendedWebElement allPromoButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(mainBanner);
    }

    public List<ExtendedWebElement> getCatalogItems() {
        return catalogItems;
    }

    public AllPromoPage openPromoPage() {
        allPromoButton.click();
        return new AllPromoPage(getDriver());
    }

    public CatalogItemPage openCatalogItemPage(int catalogItemNumber) {
        catalogItems.get(catalogItemNumber).click();
        return new CatalogItemPage(getDriver());
    }

}
