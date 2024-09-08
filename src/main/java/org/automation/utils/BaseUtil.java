package org.automation.utils;


public class BaseUtil {
    protected ConfigReader configReader;

    public void setup(){
        configReader = new ConfigReader();
        WebUI.openBrowser();
        WebUI.waitForPageLoad();

        if(configReader.getScreen().equalsIgnoreCase("maximize")){
            WebUI.maximize();
        } else if (configReader.getScreen().equalsIgnoreCase("minimize")) {
            WebUI.minimize();
        } else{
            WebUI.fullScreen();
        }
    }

    public void close(){
        WebUI.closeBrowser();
    }
}
