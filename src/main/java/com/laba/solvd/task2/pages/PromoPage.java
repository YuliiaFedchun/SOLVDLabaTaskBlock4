package com.laba.solvd.task2.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PromoPage extends BasePage {
    @FindBy(xpath = "//*[@class='breadcrumbs__link']")
    private ExtendedWebElement sectionTitle;
    @FindBy(xpath = "//*[contains(@class,'promo-hero__heading')]")
    private ExtendedWebElement promoName;

    public PromoPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(sectionTitle);
    }

    public String getPromoName() {
        return promoName.getText();
    }
}
