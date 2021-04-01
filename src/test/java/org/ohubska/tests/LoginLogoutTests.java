package org.ohubska.tests;

import org.ohubska.constants.Constants;
import org.ohubska.driver.WebDriverHolder;
import org.ohubska.pageobjects.BasePage;
import org.ohubska.pageobjects.LoggedInPage;
import org.ohubska.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginLogoutTests extends BaseTestClass{

    BasePage basePage;
    LoginPage loginPage;
    LoggedInPage loggedInPage;
    String email = "qahubska@gmail.com";
    String password = "Password12345@";

    @BeforeClass
    public void beforeClass() {
        goToUrl(Constants.BASE_URL);
        basePage= new BasePage();
        }

    @Test(priority = 1)
    public void successfullLogin(){
        loginPage = basePage.pressLoginLink().waitTillPageIsLoaded();
        loggedInPage=loginPage.successfulLogin(email,password).waitTillPageIsLoaded();
        Assert.assertEquals(loggedInPage.getTextOfFirstHeaderLink(),"My account");
        }

    @Test(priority = 2)
    public void logoutTest(){
        basePage=loggedInPage.logout();
        Assert.assertEquals(basePage.getTextOfFirstHeaderLink(),"Register");
    }

}
