package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    SoftAssert softAssert;

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void setUp(){

        homePage = new HomePage();
        loginPage = new LoginPage();
        softAssert = new SoftAssert();
    }


    @Test(groups = {"smoke","regression"})
    public void verifyUserNavigateToLoginPageSuccessfully(){

        homePage.clickOnLoginTab();

        String expectedWelcomeSignInText = "Welcome, Please Sign In!";
        String actualWelcomeSignInText = loginPage.getWelcomeLoginText();
        softAssert.assertEquals(expectedWelcomeSignInText,actualWelcomeSignInText);

        softAssert.assertAll();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {

        homePage.clickOnLoginTab();

        String expectedWelcomeSignInText = "Welcome, Please Sign In!";
        String actualWelcomeSignInText = loginPage.getWelcomeLoginText();
        softAssert.assertEquals(expectedWelcomeSignInText,actualWelcomeSignInText);

        Thread.sleep(1000);
        loginPage.enterEmail("dip129@ymail.com");
        Thread.sleep(1000);
        loginPage.enterPassword("123456");
        Thread.sleep(1000);
        loginPage.clickOnLoginButton();

        softAssert.assertAll();

    }


    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNotLoginSuccessfullyWithInvalidCredentials() throws InterruptedException {

        homePage.clickOnLoginTab();

        String expectedWelcomeSignInText = "Welcome, Please Sign In!";
        String actualWelcomeSignInText = loginPage.getWelcomeLoginText();
        softAssert.assertEquals(expectedWelcomeSignInText,actualWelcomeSignInText);

        Thread.sleep(1000);
        loginPage.enterEmail("d129@ymail.com");
        Thread.sleep(1000);
        loginPage.enterPassword("123456");
        Thread.sleep(1000);
        loginPage.clickOnLoginButton();

        Thread.sleep(1000);
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.";
        String actualErrorMessage = loginPage.getErrorMessage();
        softAssert.assertEquals(expectedErrorMessage,actualErrorMessage);

        softAssert.assertAll();
    }





}
