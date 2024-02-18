package com.laba.solvd.task3.pages;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage implements IMobileUtils, IAndroidUtils {

    @FindBy(xpath = "//*[contains(@resource-id,'searchEditText')]")
    private ExtendedWebElement searchLine;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return searchLine.isPresent();
    }

    public SearchResultPage searchInfo(String info) {
        searchLine.type(info);
        pressSearchKey();
        return new SearchResultPage(getDriver());
    }
}
