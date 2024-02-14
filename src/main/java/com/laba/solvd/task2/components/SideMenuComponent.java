package com.laba.solvd.task2.components;

import com.laba.solvd.task2.pages.HelpCenterPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SideMenuComponent extends AbstractUIObject {
    @FindBy(xpath = ".//*[contains(@class,'side-menu__logo')]")
    private ExtendedWebElement logo;
    @FindBy(xpath = ".//*[contains(text(),'Довідковий центр')]")
    private ExtendedWebElement helpCenterItem;

    public SideMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HelpCenterPage openHelpCenterPage() {
        helpCenterItem.click();
        return new HelpCenterPage(getDriver());
    }

    public boolean isLogoPresent() {
        return logo.isPresent(3);
    }
}
