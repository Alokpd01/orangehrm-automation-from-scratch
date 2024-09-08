package org.automation.pages;

import org.automation.utils.ConfigReader;
import org.automation.utils.WebUI;
import org.openqa.selenium.By;

public class LoginOrangeHrm {
    private ConfigReader configReader;

    public LoginOrangeHrm(){
        configReader = new ConfigReader();
    }

    public LoginOrangeHrm setUsername(){
        WebUI.sendKeys(By.name("username"),configReader.getUsername());
        return this;
    }

    public LoginOrangeHrm setPassword() {
        WebUI.sendKeys(By.name("password"),configReader.getPassword());
        return this;
    }

    public LoginOrangeHrm clickLoginBtn(){
        if(WebUI.isButtonEnable(By.tagName("button"))){
            WebUI.click(By.tagName("button"));
        }
        return this;
    }

    public LoginOrangeHrm clickOnDropDownForLogout(){
        WebUI.waitForPageLoad();
        WebUI.waitForElementVisible(By.className("oxd-userdropdown-name"));
        if(WebUI.isElementVisible(By.className("oxd-userdropdown-name"))){
            WebUI.click(By.className("oxd-userdropdown-name"));
        }
        return this;
    }

    public LoginOrangeHrm clickOnLogout(){
        WebUI.waitForPageLoad();
        WebUI.click(By.xpath("//a[normalize-space(text())='Logout']"));
        return this;
    }
}
