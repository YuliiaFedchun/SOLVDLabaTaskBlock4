package com.laba.solvd.task2.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {
    @FindBy(xpath = ".//*[@class='goods-tile__heading']")
    private ExtendedWebElement goodTitleButton;

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getGoodTitle() {
        return goodTitleButton.getAttribute("title");
    }
}
