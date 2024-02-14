package com.laba.solvd.task2.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HelpCenterPage extends AbstractPage {
    @FindBy(xpath = "//*[contains(text(),'Як ми можемо допомогти?')]")
    private ExtendedWebElement searchSectionTitle;

    public HelpCenterPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchSectionTitle);
    }
}
