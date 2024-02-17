package com.laba.solvd.task3.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@resource-id,'productDetailsChatBuyButton')]")
    private ExtendedWebElement buyButton;

    @FindBy(xpath = "//*[contains(@resource-id,'toolbar')]/android.widget.ImageButton")
    private ExtendedWebElement returnButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return buyButton.isPresent();
    }

    public HomePage returnToHomePage() {
        returnButton.click();
        return new HomePage(getDriver());
    }
}
