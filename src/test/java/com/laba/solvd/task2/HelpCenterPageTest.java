package com.laba.solvd.task2;

import com.laba.solvd.task2.pages.HelpCenterPage;
import com.laba.solvd.task2.pages.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelpCenterPageTest extends AbstractTest {
    @Test
    public void verifyHelpCenterPageOpeningTest() {
        //open home page
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //open side menu
        homePage.getHeader().openSideMenu();
        Assert.assertTrue(homePage.getHeader().isSideMenuOpened(), "Side menu is not opened!");

        //open help center page
        HelpCenterPage helpCenterPage = homePage.getHeader().openHelpCenterPage();
        Assert.assertTrue(helpCenterPage.isPageOpened(), "Help center page is not opened!");

    }
}
