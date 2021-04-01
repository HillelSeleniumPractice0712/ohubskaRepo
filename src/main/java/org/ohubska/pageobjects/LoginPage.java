package org.ohubska.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//div[@class='page-title']/h1")
    private WebElement pageTitle;

    @FindBy(xpath = "//input[@class='email']")
    private WebElement emailInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    private WebElement loginButton;

    public LoginPage() {
        super();
    }

    public LoginPage waitTillPageIsLoaded(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    public LoginPage enterEmail(String email){
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    private void enterCredentials(String email, String password ){
        enterEmail(email).enterPassword(password).clickLoginButton();
    }

    public LoggedInPage successfulLogin ( String email, String password){
        enterCredentials(email,password);
        return new LoggedInPage();
    }

   }
