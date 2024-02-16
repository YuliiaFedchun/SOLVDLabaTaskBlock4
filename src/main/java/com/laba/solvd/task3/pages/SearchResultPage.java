package com.laba.solvd.task3.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AbstractPage implements IMobileUtils {

    @FindBy(xpath = "//*[contains(@resource-id,'titleText')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[contains(@resource-id,'feedProductBg')]")
    private List<ExtendedWebElement> productCards;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    public boolean areProductCardsTitleContainsText(String text) {
        for (int i = 1; i <= 4; i++) {
            String xpath = String.format("(//*[contains(@resource-id,'brandNameText')])[%d]", i % 2 + 1);
            String brandName = findExtendedWebElement(By.xpath(xpath)).getAttribute("text");
            if (!brandName.toLowerCase().contains(text.toLowerCase())) {
                return false;
            }
            if (i % 2 == 0) {
                swipeUp(3, 8000);
            }
        }
        return true;
    }
}
