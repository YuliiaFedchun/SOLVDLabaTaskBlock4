package com.laba.solvd.task3.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

public class HomePage extends AbstractPage implements IMobileUtils {

    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(xpath = "//*[@resource-id='collectionItemCatalog']")
    private ExtendedWebElement catalogButton;

    @FindBy(xpath = "//*[@resource-id='catalogItemText' and @text='%s']")
    private ExtendedWebElement catalogItemName;

    @FindBy(xpath = "//*[@resource-id='add_productTab']")
    private ExtendedWebElement addNewProductButton;

    @FindBy(xpath = "//android.widget.HorizontalScrollView/*[%d]")
    private ExtendedWebElement vipProductCard;

    @FindBy(xpath = "//*[@resource-id='profileTab']")
    private ExtendedWebElement profileButton;

    @FindBy(xpath = "//*[contains(@resource-id,'fragmentContainer')]/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]")
    private ExtendedWebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return catalogButton.isPresent();
    }

    public CategoryPage openCatalogCategory(String categoryName) {
        LOGGER.info(catalogItemName.format(categoryName).isPresent(3));
        if (!catalogItemName.format(categoryName).isPresent(3)) {
            ExtendedWebElement lastCatalogItem = findExtendedWebElement(By.xpath("(//*[@resource-id='catalogBoxItem'])[2]/*"));
            int startX = lastCatalogItem.getLocation().getX();
            int y = lastCatalogItem.getLocation().getY();
            int endX = catalogButton.getLocation().getX();
            int swipeCount = 0;
            while (!catalogItemName.format(categoryName).isPresent(3) && (swipeCount < 3)) {
                swipe(startX, y, endX, y, 1500);
                swipeCount++;
            }
        }
        catalogItemName.format(categoryName).click();
        return new CategoryPage(getDriver());
    }

    public NewProductPage openAddNewProductForm() {
        addNewProductButton.click();
        return new NewProductPage(getDriver());
    }

    public ProductPage openVIPProductPage(int productCardNumber) {
        if (vipProductCard.format(productCardNumber).isPresent()) {
            vipProductCard.format(productCardNumber).click();
            return new ProductPage(getDriver());
        } else {
            LOGGER.warn("Product card is not found!");
        }
        return null;
    }

    public ProfilePage openProfilePage() {
        profileButton.click();
        return new ProfilePage(getDriver());
    }

    public SearchPage openSearchPage() {
        searchButton.click();
        return new SearchPage(getDriver());
    }
}
