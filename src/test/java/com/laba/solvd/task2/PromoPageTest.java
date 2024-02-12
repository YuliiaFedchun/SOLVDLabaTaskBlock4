package com.laba.solvd.task2;

import com.laba.solvd.task2.gui.components.PromoCard;
import com.laba.solvd.task2.gui.pages.AllPromoPage;
import com.laba.solvd.task2.gui.pages.HomePage;
import com.laba.solvd.task2.gui.pages.PromoPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.List;
import java.util.Random;

public class PromoPageTest extends AbstractTest {
    private static final Logger LOGGER = Logger.getLogger(PromoPageTest.class);

    @Test
    public void verifyPromoOpeningTest() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");

        //open page with all promos
        AllPromoPage allPromoPage = homePage.openPromoPage();
        Assert.assertTrue(allPromoPage.isPageOpened(), "All promo page is not opened.");

        //open any promo page and check that it's correct
        List<PromoCard> promoCards = allPromoPage.getPromoCards();
        int promoCardNumber = new Random().nextInt(promoCards.size());
        PromoCard promoCard = promoCards.get(promoCardNumber);
        LOGGER.info(promoCard.getPromoName());
        PromoPage promoPage = promoCard.openPromoPage();
        Assert.assertTrue(promoPage.isPageOpened(), "Promo page is not opened.");
        //Assert.assertEquals(promoPage.getPromoName(),promoCard.getPromoName());
        LOGGER.info(promoPage.getPromoName());
    }
}
