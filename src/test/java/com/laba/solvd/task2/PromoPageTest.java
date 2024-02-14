package com.laba.solvd.task2;

import com.laba.solvd.task2.pages.AllPromoPage;
import com.laba.solvd.task2.pages.HomePage;
import com.laba.solvd.task2.pages.PromoPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.Random;

public class PromoPageTest extends AbstractTest {
    private static final Logger LOGGER = Logger.getLogger(PromoPageTest.class);

    @Test
    public void verifyPromoOpeningTest() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //open page with all promos
        AllPromoPage allPromoPage = homePage.openPromoPage();
        Assert.assertTrue(allPromoPage.isPageOpened(), "All promo page is not opened!");

        //open any promo page and check that it's correct
        int promoCardNumber = new Random().nextInt(allPromoPage.getPromoCards().size());
        PromoPage promoPage = allPromoPage.openPromoPage(promoCardNumber);
        Assert.assertTrue(promoPage.isPageOpened(), "Promo page is not opened!");
        LOGGER.info(String.format("The page of the promo '%s' is opened", promoPage.getPromoName()));
    }
}
