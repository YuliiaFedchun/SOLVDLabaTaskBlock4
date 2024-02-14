package com.laba.solvd.task2;

import com.laba.solvd.task2.components.ProductCardComponent;
import com.laba.solvd.task2.pages.HomePage;
import com.laba.solvd.task2.pages.ProductPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPageTests extends AbstractTest {
    private static final Logger LOGGER = Logger.getLogger(ProductPageTests.class);
    private static final String CATEGORY_NAME = "Побутова техніка";
    private static final String BRAND_NAME = "Samsung";

    @Test
    public void verifyProductPageOpeningThroughSearchLineTest() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //type ifo in the search line and open result search page
        ProductPage productPage = homePage.getHeader().searchInfo(BRAND_NAME);
        Assert.assertTrue(productPage.isPageOpened(), "Result search page is not opened!");

        //check that all product cards contains brand name
        Assert.assertTrue(isProductPageCorrect(productPage, BRAND_NAME), "Result product page is not correct!");
    }

    @Test
    public void verifyProductPageOpeningThroughCatalogTest() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //open catalog
        homePage.getHeader().openCatalog();
        Assert.assertTrue(homePage.getHeader().isCatalogOpened(), "Catalog is not opened!");

        //hover the mouse on any item of the catalog
        //choose any brand logo in the bottom of the catalog
        //open corresponding product page
        //check page correctness
        ProductPage productPage = homePage.getHeader().openBrandPageThroughCatalog(CATEGORY_NAME, BRAND_NAME);
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened!");
        Assert.assertTrue(isProductPageCorrect(productPage, BRAND_NAME), "Result product page is not correct!");
    }

    private boolean isProductPageCorrect(ProductPage productPage, String brandName) {
        List<ProductCardComponent> productCards = productPage.getProductCards();
        List<String> productCardsTitle = productCards.stream()
                .map(ProductCardComponent::getGoodTitle)
                .collect(Collectors.toList());
        LOGGER.info(productCardsTitle);
        for (String productCardTitle : productCardsTitle) {
            if (!productCardTitle.toLowerCase().contains(brandName.toLowerCase())) {
                return false;
            }
        }
        return true;

    }
}
