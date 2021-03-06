package org.ohubska.tests;

import org.apache.commons.io.FileUtils;
import org.ohubska.constants.Constants;
import org.ohubska.driver.WebDriverHolder;
import org.ohubska.listeners.TestListener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.uncommons.reportng.HTMLReporter;

import java.io.File;
import java.io.IOException;

@Listeners({TestListener.class, HTMLReporter.class})
public class BaseTestClass {

    @BeforeSuite
    public void beforeSuit() throws IOException {
        reCreateScreenshotsFolder();
    }

    @AfterClass
    public void afterSuite() {
        if (WebDriverHolder.getDriver() != null) {
            WebDriverHolder.getDriver().quit();
        }
    }

    public void goToUrl(String url){
        WebDriverHolder.getDriver().get(url);
    }

    public void reCreateScreenshotsFolder() throws IOException {
        File downloadFolder = new File(Constants.SCREENSHOT_FOLDER);
        if(downloadFolder.exists()){
            FileUtils.forceDelete(downloadFolder);
        }
        FileUtils.forceMkdir(downloadFolder);
    }
}
