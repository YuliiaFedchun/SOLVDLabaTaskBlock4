package com.laba.solvd.task2.gui.pages;

import com.laba.solvd.task2.gui.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BasePage extends AbstractPage {
    @FindBy(xpath="//*[@class='header']")
    private Header header;

    public BasePage(WebDriver driver) {
        super(driver);
    }
    public Header getHeader() {
        return header;
    }
}
