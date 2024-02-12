package com.laba.solvd.task2.gui.pages;

import com.laba.solvd.task2.gui.components.MainCatalogItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(xpath = "//*[contains(@class,'top-wrap--skeleton')]")
    private ExtendedWebElement mainBanner;
    @FindBy(xpath = "//*[contains(@class, 'main-categories__item')]")
    private List<MainCatalogItem> catalogItems;

    @FindBy(xpath = "//*[contains(@class, 'main-slider')]//*[text()=' Всі акції ']")
    private ExtendedWebElement allPromoButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(mainBanner);
    }

    public List<MainCatalogItem> getCatalogItems() {
        return catalogItems;
    }

    public AllPromoPage openPromoPage() {
        allPromoButton.click();
        return new AllPromoPage(getDriver());
    }
}
