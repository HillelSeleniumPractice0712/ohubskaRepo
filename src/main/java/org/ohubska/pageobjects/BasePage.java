package org.ohubska.pageobjects;

import org.ohubska.driver.WebDriverHolder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriverWait wait;

    @FindBy(id = "customerCurrency")
    protected WebElement customerCurrency;

    @FindBy(xpath = "//div[@class='header-links']")
    protected WebElement headerLinks;

    @FindBy(xpath = "//div[@class='header-links']//a[1]")
    protected WebElement firstHeaderLinks;

    @FindBy(id = "small-searchterms")
    protected WebElement searchInput;

    @FindBy(xpath = "//button[contains(@class,'search-box-button')]")
    protected WebElement searchButton;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']")
    protected WebElement headerMenu;


    public BasePage() {
        wait =new WebDriverWait(WebDriverHolder.getDriver(),20);
        PageFactory.initElements(WebDriverHolder.getDriver(),this);
    }

    public BasePage waitTillPageIsLoaded(){
        return this;
    }

    public String getTextOfFirstHeaderLink(){
        return firstHeaderLinks.getText();
    }
}
