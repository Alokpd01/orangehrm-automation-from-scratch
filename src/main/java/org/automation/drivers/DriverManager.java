package org.automation.drivers;

import org.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver(){
        ConfigReader configReader = new ConfigReader();
        String browser = configReader.getBrowser();
        if(driver == null){
            switch (browser.toLowerCase()){
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                case "edge":
                    driver = new EdgeDriver();
                default:
                    throw new IllegalArgumentException("Browser type not supported: " + browser);
            }
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }
}
