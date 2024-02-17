package com.laba.solvd.task3.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends AbstractPage implements IMobileUtils {

    @FindBy(xpath = "//*[contains(@resource-id,'titleText')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "(//*[contains(@resource-id,'brandNameText')])[%d]")
    private ExtendedWebElement productCardName;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isPresent();
    }

    public boolean areProductCardsTitleContainsText(String text) {
        List<String> productCardsNames = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            productCardsNames.add(productCardName.format(1).getAttribute("text"));
            productCardsNames.add(productCardName.format(2).getAttribute("text"));
            swipeUp(2, 1500);
        }
        for (String productCardName : productCardsNames) {
            if (!productCardName.toLowerCase().contains(text.toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}
