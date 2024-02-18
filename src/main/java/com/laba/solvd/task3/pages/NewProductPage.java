package com.laba.solvd.task3.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NewProductPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@resource-id,'toolbar')]")
    private ExtendedWebElement addingProductTitle;

    @FindBy(xpath = "//*[contains(@resource-id,'nextStepButton')]")
    private ExtendedWebElement nextStepButton;

    @FindBy(xpath = "//*[@text='Назва товару повинна містити як мінімум 3 символи']")
    private ExtendedWebElement incorrectProductNameWarning;

    public NewProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return addingProductTitle.isPresent();
    }

    public void submitData() {
        nextStepButton.click();
    }

    public boolean isIncorrectDataWarningPresent() {
        return incorrectProductNameWarning.isPresent();
    }
}
