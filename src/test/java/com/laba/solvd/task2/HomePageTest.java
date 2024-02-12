package com.laba.solvd.task2;

import com.laba.solvd.task1.PostTests;
import com.laba.solvd.task2.gui.components.MainCatalogItem;
import com.laba.solvd.task2.gui.components.ProductCard;
import com.laba.solvd.task2.gui.pages.BrandPage;
import com.laba.solvd.task2.gui.pages.CatalogItemPage;
import com.laba.solvd.task2.gui.pages.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HomePageTest extends AbstractTest {
    private static final Logger LOGGER = Logger.getLogger(HomePageTest.class);
    @Test
    public void verifyHomePageReturningTest() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened.");

        //choose any catalog item and open item's page
        List<MainCatalogItem> catalogItems = homePage.getCatalogItems();
        int catalogItemNumber = new Random().nextInt(17);
        //String catalogItemName = catalogItems.get(catalogItemNumber).getCatalogItemName();
        CatalogItemPage catalogItemPage = catalogItems.get(catalogItemNumber).openCatalogItemPage();
        Assert.assertTrue(catalogItemPage.isPageOpened(),"Catalog item's page is not opened");
        //Assert.assertEquals(catalogItemPage.getItemName(),catalogItemName);

        //return to the home page clicking on the logo on the header
        catalogItemPage.getHeader().homePageOpen();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened.");
    }
}
