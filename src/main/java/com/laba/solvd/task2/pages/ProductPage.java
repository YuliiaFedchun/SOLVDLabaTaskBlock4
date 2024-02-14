package com.laba.solvd.task2.pages;

import com.laba.solvd.task2.components.ProductCardComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//ul[contains(@class,'catalog-grid')]")
    private ExtendedWebElement productCardsUnit;

    @FindBy(xpath = "//*[contains(@class,'catalog-grid__cell')]")
    private List<ProductCardComponent> productCards;

    public ProductPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(productCardsUnit);
    }

    public List<ProductCardComponent> getProductCards() {
        return productCards;
    }
}
