package org.ohubska.listeners;

import org.apache.commons.io.FileUtils;
import org.ohubska.constants.Constants;
import org.ohubska.driver.WebDriverHolder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart( ITestResult iTestResult ) {

    }

    @Override
    public void onTestSuccess( ITestResult iTestResult ) {

    }

    @Override
    public void onTestFailure( ITestResult iTestResult ) {
        if (!iTestResult.isSuccess()) {
            File screenshot = ((TakesScreenshot) WebDriverHolder.getDriver()).getScreenshotAs(OutputType.FILE);
            File destination = new File(Constants.SCREENSHOT_FOLDER,
                    iTestResult.getName()+"_"+new Date().getTime()+".png");
            try {
                FileUtils.copyFile(screenshot,destination);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped( ITestResult iTestResult ) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage( ITestResult iTestResult ) {

    }

    @Override
    public void onStart( ITestContext iTestContext ) {

    }

    @Override
    public void onFinish( ITestContext iTestContext ) {

    }
}
