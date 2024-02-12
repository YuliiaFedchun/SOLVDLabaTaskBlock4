package com.laba.solvd.task2.gui.pages;

import com.laba.solvd.task2.gui.components.PromoCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllPromoPage extends BasePage {
    @FindBy(xpath = "//*[text()='Акції']")
    private ExtendedWebElement title;
    @FindBy(xpath = "//*[@class='promo-grid ng-star-inserted']")
    private List<PromoCard> promoCards;

    public AllPromoPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    public List<PromoCard> getPromoCards() {
        return promoCards;
    }
}
