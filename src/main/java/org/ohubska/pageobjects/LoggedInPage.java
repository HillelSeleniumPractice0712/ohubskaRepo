package org.ohubska.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoggedInPage extends BasePage{

    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement myAccount;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logout;

    public LoggedInPage() {
        super();
    }

    public LoggedInPage waitTillPageIsLoaded(){
        wait.until(ExpectedConditions.visibilityOf(myAccount));
        return this;
    }

    public BasePage logout(){
        logout.click();
        return new BasePage();
    }
}
