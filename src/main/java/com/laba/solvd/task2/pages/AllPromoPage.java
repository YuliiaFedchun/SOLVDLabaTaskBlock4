package com.laba.solvd.task2.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllPromoPage extends BasePage {
    @FindBy(xpath = "//*[text()='Акції']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[contains(@class, 'promo-grid')]//a")
    private List<ExtendedWebElement> promoCards;

    public AllPromoPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    public List<ExtendedWebElement> getPromoCards() {
        return promoCards;
    }

    public PromoPage openPromoPage(int promoCardNumber) {
        promoCards.get(promoCardNumber).click();
        return new PromoPage(getDriver());
    }
}
