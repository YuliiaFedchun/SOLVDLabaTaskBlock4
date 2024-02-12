package com.laba.solvd.task2.gui.components;

import com.laba.solvd.task2.gui.pages.PromoPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PromoCard extends AbstractUIObject {
    @FindBy(xpath = ".//*[@class='promo-tile__heading']")
    private ExtendedWebElement promoName;
    @FindBy(xpath = ".//*[@class='promo-tile ng-star-inserted']")
    private ExtendedWebElement promoUnit;

    public PromoCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getPromoName() {
        return promoName.getText();
    }

    public PromoPage openPromoPage() {
        promoUnit.click();
        return new PromoPage(getDriver());
    }
}
