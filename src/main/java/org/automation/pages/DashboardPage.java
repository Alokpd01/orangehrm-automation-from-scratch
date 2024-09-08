package org.automation.pages;

import org.automation.utils.WebUI;
import org.openqa.selenium.By;

public class DashboardPage {

    By pageName = By.tagName("h6");
    By inputSearchFieldForPageSwitch = By.tagName("input");

    public String getPageName(){
        return WebUI.getText(pageName);
    }
    public DashboardPage moveToPage(String pageName){
        WebUI.click(inputSearchFieldForPageSwitch);
        WebUI.sendKeys(inputSearchFieldForPageSwitch, pageName);
        WebUI.waitForPageLoad();

        String newPageXpath = "//span[text()='" +pageName + "']";
        WebUI.waitForElementVisible(By.xpath(newPageXpath));
        WebUI.click(By.xpath(newPageXpath));
        WebUI.waitForPageLoad();

        return this;
    }

}
