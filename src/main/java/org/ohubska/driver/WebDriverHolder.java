package org.ohubska.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverHolder {
    private WebDriver driver;
    private static WebDriverHolder instance = null;

    public static WebDriverHolder getInstance() {
        if (instance == null) {
            instance = new WebDriverHolder();
        }
        return instance;
    }

    private WebDriverHolder() {
        driver = WebDriverFactory.initDriver();
    }

    public static WebDriver getDriver(){
        return getInstance().driver;
    }
}
