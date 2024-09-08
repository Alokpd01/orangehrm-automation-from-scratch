package org.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.drivers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomTestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(CustomTestListener.class);
    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result){
        logger.info("Test Started : " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        logger.info("Test Passed : " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed : " + result.getMethod().getMethodName());

        if (driver != null) {
            // Take a screenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Get the test class name
            String className = result.getTestClass().getRealClass().getSimpleName();
            System.out.println("Class name: " + className);

            // Create a folder based on the class name
            String folderPath = "screenshots/" + className;
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();  // Create the directory if it doesn't exist
            }

            // Create a path for the screenshot file
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String screenShotPath = folderPath + "/" + result.getMethod().getMethodName() + "_" + timestamp + ".png";


            try {
                // Copy the screenshot to the destination
                Files.copy(srcFile.toPath(), Path.of(screenShotPath));
                logger.info("Screenshot saved to : " + screenShotPath);
            } catch (IOException e) {
                logger.error("Failed to take screenshot: " + e.getMessage());
            }
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started: " + context.getName());
        driver = DriverManager.getDriver();
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Finished: " + context.getName());
    }

}
