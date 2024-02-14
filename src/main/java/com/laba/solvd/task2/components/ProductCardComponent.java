package com.laba.solvd.task2.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCardComponent extends AbstractUIObject {
    @FindBy(xpath = ".//*[@class='goods-tile__heading']")
    private ExtendedWebElement goodTitle;

    public ProductCardComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getGoodTitle() {
        return goodTitle.getAttribute("title");
    }
}
