package com.laba.solvd.task3.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends AbstractPage {
    @FindBy(xpath = "//*[contains(@resource-id,'id/titleText')]")
    private ExtendedWebElement title;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getCategoryName() {
        return title.getText();
    }

    @Override
    public boolean isPageOpened() {
        return title.isPresent();
    }
}
