package com.laba.solvd.task2.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SideMenuPage extends AbstractPage {
    @FindBy(xpath = "//*[contains(@class,'side-menu__logo')]")
    private ExtendedWebElement logo;
    @FindBy(xpath = "//*[text()=' Довідковий центр ']")
    private ExtendedWebElement helpCenterItem;

    public SideMenuPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    public HelpCenterPage openHelpCenterPage() {
        helpCenterItem.click();
        return new HelpCenterPage(getDriver());
    }
}
