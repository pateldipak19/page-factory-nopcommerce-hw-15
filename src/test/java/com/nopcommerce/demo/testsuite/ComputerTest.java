package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.NotebooksPage;
import com.nopcommerce.demo.pages.SoftwarePage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ComputerTest extends TestBase {

    SoftAssert softAssert;
    HomePage homePage;
    DesktopPage desktopPage;
    NotebooksPage notebooksPage;
    SoftwarePage softwarePage;

    @BeforeMethod(groups = {"smoke", "sanity", "regression"})
    public void setUp() {

        softAssert = new SoftAssert();
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        notebooksPage = new NotebooksPage();
        softwarePage = new SoftwarePage();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserAbleToNavigateToComputersSubMenuProductDesktopPageSuccessfully() throws InterruptedException {

        homePage.mouseHoverOnComputerTab();
        Thread.sleep(500);
        homePage.clickOnDesktopFromComputerDropDown();

        String expectedDesktopPageNavigationText = "Desktops";
        String actualDesktopPageNavigationText = desktopPage.getDesktopPageNavigationText();
        softAssert.assertEquals(expectedDesktopPageNavigationText, actualDesktopPageNavigationText);

        softAssert.assertAll();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserAbleToNavigateToComputersSubMenuProductNotebooksPageSuccessfully() throws InterruptedException {

        homePage.mouseHoverOnComputerTab();
        Thread.sleep(1000);
        homePage.clickNotebooksFromComputerDropDown();

        String expectedNotebooksPageNavigationText = "Notebooks";
        String actualNotebooksPageNavigationText = notebooksPage.getNotebooksPageNavigationText();
        softAssert.assertEquals(expectedNotebooksPageNavigationText, actualNotebooksPageNavigationText);

        softAssert.assertAll();

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserAbleToNavigateToComputersSubMenuProductSoftwarePageSuccessfully() throws InterruptedException {

        homePage.mouseHoverOnComputerTab();
        Thread.sleep(1000);
        homePage.clickOnSoftwareFromComputerDropDown();

        String expectedSoftwarePageNavigationText = "Software";
        String actualSoftwarePageNavigationText = softwarePage.getSoftwarePageNavigationText();
        softAssert.assertEquals(expectedSoftwarePageNavigationText, actualSoftwarePageNavigationText);

        softAssert.assertAll();

    }
}
