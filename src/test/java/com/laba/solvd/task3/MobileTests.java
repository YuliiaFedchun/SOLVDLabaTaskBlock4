package com.laba.solvd.task3;

import com.laba.solvd.task3.pages.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class MobileTests extends AbstractTest implements IMobileUtils {

    public static final String PACKAGE_NAME = "shafa.odejda.obuv.aksessuary";

    private final String searchBrandName = "ikea";

    private final String categoryName = "Краса і здоров'я";

    @BeforeTest
    public void openApplication() {
        startApp(PACKAGE_NAME);
    }

    @Test
    public void openCategoryPage() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //open category item and check is it correct
        CategoryPage categoryPage = homePage.openCatalogCategory(categoryName);
        Assert.assertTrue(categoryPage.isPageOpened(), "Category page is not opened!");
        Assert.assertEquals(categoryPage.getCategoryName(), categoryName);
    }

    @Test
    public void openBrandPageThroughSearch() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //open search page
        SearchPage searchPage = homePage.openSearchPage();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened!");
        Assert.assertTrue(searchPage.isKeyboardShown(), "Keyboard is not shown!");

        //input brand name, press "Search" button
        //open brand page
        SearchResultPage searchResultPage = searchPage.searchInfo(searchBrandName);
        Assert.assertTrue(searchResultPage.isPageOpened(), "Brand page is not opened!");
        Assert.assertTrue(searchResultPage.areProductCardsTitleContainsText(searchBrandName), "Brand page is not correct!");

    }

    @Test
    public void fillingAddingProductFormWithEmptyData() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //open form for adding a product
        NewProductPage newProductPage = homePage.openAddNewProductForm();
        Assert.assertTrue(newProductPage.isPageOpened(), "Page with form for new product is not opened!");

        //click on the next step button with empty data
        newProductPage.submitData();
        Assert.assertTrue(newProductPage.isIncorrectDataWarningPresent(), "Warning message is not appeared!");
    }

    @Test
    public void returnToHomePageFromProductPage() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //choose one of a viewable product card from the VIP block
        //open corresponding product page
        ProductPage productPage = homePage.openVIPProductPage(new Random().nextInt(3));
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened!");

        //click on the return arrow on the header and return to the home page
        homePage = productPage.returnToHomePage();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
    }

    @Test
    public void infoPageOpeningThroughUserProfile() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //open user profile
        ProfilePage profilePage = homePage.openProfilePage();
        Assert.assertTrue(profilePage.isPageOpened(), "Profile page is not opened!");

        //open info page
        InfoPage infoPage = profilePage.openInfoPage();
        Assert.assertTrue(infoPage.isPageOpened(), "Info page is not opened!");
    }
}
