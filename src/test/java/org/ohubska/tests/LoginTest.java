package org.ohubska.tests;

import org.ohubska.constants.Constants;
import org.ohubska.driver.WebDriverHolder;
import org.ohubska.pageobjects.BasePage;
import org.ohubska.pageobjects.LoggedInPage;
import org.ohubska.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestClass{

    BasePage basePage;
    LoginPage loginPage;
    LoggedInPage loggedInPage;
    WebElement login;

    @BeforeMethod
    public void beforeClass(){
        goToUrl(Constants.BASE_URL);
        basePage= new BasePage();
        login = WebDriverHolder.getDriver().findElement(By.xpath("//a[@class='ico-login']"));
        login.click();
    }

    @Test
    public void successfullLogin(){
        loginPage = new LoginPage().waitTillPageIsLoaded();
        loggedInPage=loginPage.successfulLogin(Constants.EMAIL,Constants.PASSWORD).waitTillPageIsLoaded();
        Assert.assertEquals(loggedInPage.getTextOfFirstHeaderLink(),"My account");
        }

}
