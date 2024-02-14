package com.laba.solvd.task2;

import com.laba.solvd.task2.pages.CatalogItemPage;
import com.laba.solvd.task2.pages.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.Random;

public class HomePageTest extends AbstractTest {
    private static final Logger LOGGER = Logger.getLogger(HomePageTest.class);

    @Test
    public void verifyHomePageReturningTest() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //choose any catalog item and open item's page
        int catalogItemNumber = new Random().nextInt(homePage.getCatalogItems().size());
        CatalogItemPage catalogItemPage = homePage.openCatalogItemPage(catalogItemNumber);
        LOGGER.info(String.format("Page of the '%s' category is opened", catalogItemPage.getItemName()));
        Assert.assertTrue(catalogItemPage.isPageOpened(), "Catalog item's page is not opened!");

        //return to the home page clicking on the logo on the header
        catalogItemPage.getHeader().openHomePage();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
    }
}
