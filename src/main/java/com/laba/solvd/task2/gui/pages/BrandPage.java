package com.laba.solvd.task2.gui.pages;

import com.laba.solvd.task2.gui.components.ProductCard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrandPage extends ResultSearchPage{
    @FindBy(xpath="//*[@class='catalog-grid ng-star-inserted']")
    private List<ProductCard> productCards;
    public BrandPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchResultTitle);
    }
    public List<ProductCard> getProductCards() {
        return productCards;
    }
}
