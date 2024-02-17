package com.laba.solvd.task3.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage implements IMobileUtils {

    @FindBy(xpath = "//*[@resource-id='userNickNameText']")
    private ExtendedWebElement nickNameField;

    @FindBy(xpath = "//*[@resource-id='howItWorksItem']")
    private ExtendedWebElement aboutShafaItem;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return nickNameField.isPresent();
    }

    public InfoPage openInfoPage() {
        swipeUp(4, 1500);
        aboutShafaItem.click();
        return new InfoPage(getDriver());
    }
}
