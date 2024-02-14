package com.laba.solvd.task2.components;

import com.laba.solvd.task2.pages.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class CatalogComponent extends AbstractUIObject {
    @FindBy(xpath = ".//*[contains(@class,'menu-categories__link')]")
    private List<ExtendedWebElement> categories;
    @FindBy(xpath = ".//li[contains(@class,'menu-categories__item')]" +
            "//*[@class='menu__main-cats']//ul[contains(@class,'menu__main-brands')]" +
            "//*[contains(@class,'brand-link')]")
    private List<ExtendedWebElement> categoryBrandsLogos;

    public CatalogComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void chooseCategory(String categoryName) {
        Optional<ExtendedWebElement> categoryItem = categories.stream()
                .filter(e -> e.getText().equals(categoryName))
                .findFirst();
        categoryItem.ifPresent(ExtendedWebElement::hover);
    }

    public ProductPage openBrandCategoryPage(String categoryName, String brandName) {
        chooseCategory(categoryName);
        Optional<ExtendedWebElement> brandLogo = categoryBrandsLogos.stream()
                .filter(e -> e.getAttribute("title").equalsIgnoreCase(brandName))
                .findFirst();
        brandLogo.ifPresent(ExtendedWebElement::click);
        return new ProductPage(getDriver());
    }

    public boolean isCategoriesUnitPresent() {
        return categories.get(0).isPresent(3);
    }
}
