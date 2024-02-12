package com.laba.solvd.task2;

import com.laba.solvd.task2.gui.components.ProductCard;
import com.laba.solvd.task2.gui.pages.BrandPage;
import com.laba.solvd.task2.gui.pages.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class BrandPageTest extends AbstractTest {
    @Test
    public void verifyBrandPageOpeningThroughSearchLineTest() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");

        //type ifo in the search line and open result search page
        String searchInfo = "lenovo";
        BrandPage brandPage = homePage.getHeader().searchBrand(searchInfo);
        Assert.assertTrue(brandPage.isPageOpened(), "Result search page is not opened.");

        //check that all product cards contains brand name
        List<ProductCard> productCards = brandPage.getProductCards();
        List<String> productCardsTitle = productCards.stream()
                .map(ProductCard::getGoodTitle)
                .collect(Collectors.toList());
        boolean isProductCardsCorrect = true;
        for (String productCardTitle : productCardsTitle) {
            isProductCardsCorrect = isProductCardsCorrect &&
                    productCardTitle.toLowerCase().contains(searchInfo.toLowerCase());
        }
        Assert.assertTrue(isProductCardsCorrect, "Result brand page is not correct.");
    }
}
