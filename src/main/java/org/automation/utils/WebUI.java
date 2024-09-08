package org.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.drivers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class WebUI {
    private static WebDriver driver = DriverManager.getDriver();
    private static ConfigReader configReader = new ConfigReader();
    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(configReader.getTimeout()));
    private static final Logger logger = LogManager.getLogger(WebUI.class);

    public static void openBrowser(){
        driver.get(configReader.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configReader.getTimeout()));
    }

    public static void waitForSecond(int second){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }

    public static void waitForLoaderNotVisible(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
    }

    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public static void waitForPageLoad(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configReader.getTimeout()));
    }

    public static void click(By by){
        waitForElementPresent(by);
        waitForElementClickable(by);
        WebElement element = driver.findElement(by);
        if(element.isEnabled()){
            element.click();
            waitForPageLoad();
        }
    }

    public static void takeScreenshot(String className, String methodName) {
        if (driver != null) {
            // Take a screenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Create a folder based on the class name
            String folderPath = "screenshots/" + className;
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//            String screenShotPath = folderPath + "/" + result.getMethod().getMethodName() + ".png";
            String screenShotPath = folderPath + "/" + methodName + "_" + timestamp + ".png";

            try {
                Files.copy(srcFile.toPath(), Path.of(screenShotPath));
                logger.info("Screenshot saved to : " + screenShotPath);
            } catch (IOException e) {
                logger.error("Failed to take screenshot: " + e.getMessage());
            }
        }
    }

    public static void clickUsingJs(By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].click();", element);
        waitForPageLoad();
    }

    public static void sendKeys(By by, String input){
        WebElement element = driver.findElement(by);
        element.sendKeys(input);
        waitForPageLoad();
    }

    public static void check(By by){
        WebElement element = driver.findElement(by);
        element.click();
        waitForPageLoad();
    }

    public static void clearText(By by){
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        element.click();
        actions
                .moveToElement(element)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
        waitForPageLoad();
    }

    public static boolean isButtonEnable(By by){
        waitForElementClickable(by);
        WebElement element = driver.findElement(by);
        return element.isEnabled();
    }

    public static boolean isElementVisible(By by){
        waitForElementVisible(by);
        WebElement element = driver.findElement(by);
        return element.isDisplayed();
    }

    public static void waitForElementVisible(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementPresent(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static String getText(By by){
        waitForElementVisible(by);
        WebElement element = driver.findElement(by);
        return element.getText();
    }

    public static String getAttribute(By by,String attributeName){
        waitForElementVisible(by);
        WebElement element = driver.findElement(by);
        return element.getAttribute(attributeName);
    }

    public static String getCssValue(By by, String propertyName){
        waitForElementVisible(by);
        WebElement element = driver.findElement(by);
        return element.getCssValue(propertyName);
    }

    public static void maximize(){
        driver.manage().window().maximize();
    }

    public static void fullScreen(){
        driver.manage().window().fullscreen();
    }

    public static void minimize(){
        driver.manage().window().minimize();
    }

}
