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

    @FindBy(xpath = "(//*[@resource-id='catalogBoxItem'])[%d]")
    private ExtendedWebElement catalogCategoryButton;

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
        setUiLoadedMarker(catalogButton);
    }

    public CategoryPage openCatalogCategory(String categoryName) {
        String dynamicXpath = String.format("//*[@resource-id='catalogItemText' and @text='%s']", categoryName);
        if (swipe(findExtendedWebElement(By.xpath(dynamicXpath)), Direction.LEFT)) {
            findExtendedWebElement(By.xpath(dynamicXpath)).click();
        }
        return new CategoryPage(getDriver());
    }

    public String getCategoryName(int categoryNumber) {
        String dynamicXpath = String.format("(//*[@resource-id='catalogBoxItem'])[%d]", categoryNumber);
        if (categoryNumber > 2) {
            //swipe(findExtendedWebElement(By.xpath(dynamicXpath)),categoryNumber / 7 + 1);
            swipe(catalogButton, Direction.LEFT, 3, 5000);
        }
        ExtendedWebElement category = findExtendedWebElement(By.xpath(dynamicXpath));
        return category
                .findExtendedWebElement(By.xpath("//*[@class='android.widget.TextView']"))
                .getAttribute("text");
    }

    public NewProductPage openAddNewProductForm() {
        addNewProductButton.click();
        return new NewProductPage(getDriver());
    }

    public ProductPage openVIPProductPage(int productCardNumber) {
        String dynamicXpath = String.format("//android.widget.HorizontalScrollView/*[%d]", productCardNumber);
        ExtendedWebElement productCard = findExtendedWebElement(By.xpath(dynamicXpath));
        if (productCard.isPresent()) {
            productCard.click();
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
