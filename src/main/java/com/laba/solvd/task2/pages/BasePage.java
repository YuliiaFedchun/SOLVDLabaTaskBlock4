package com.laba.solvd.task2.pages;

import com.laba.solvd.task2.components.HeaderComponent;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BasePage extends AbstractPage {
    @FindBy(xpath = "//*[@class='header']")
    private HeaderComponent header;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent getHeader() {
        return header;
    }
}
