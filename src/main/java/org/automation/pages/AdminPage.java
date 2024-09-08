package org.automation.pages;

import org.automation.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminPage {
    By adminPageName = By.className("oxd-topbar-header-breadcrumb");
    By btnAdd = By.xpath("//button[text()=' Add ']");
    By btnSearch = By.xpath("//button[text()=' Search ']");
    By btnReset = By.xpath("//button[text()=' Reset ']");
    By inputCheckBox = By.xpath("//input[@type='checkbox' and @value='0' or @value='true']");
    By btnDeleteSelected = By.xpath("//button[text()=' Delete Selected ']");
    By btnYesDelete = By.xpath("//button[text()=' Yes, Delete ']");
    By btnNoCancel = By.xpath("//button[text()=' No, Cancel ']");
    By btnDeleteUser = By.xpath("//i[contains(@class, 'bi-trash')]/parent::button");
    By btnEditUser = By.xpath("//i[contains(@class, 'bi-pencil')]/parent::button");
    By inputUsername = By.xpath("//div[@class='oxd-table-filter']//input[not(@placeholder)]");
    By inputEmployeeName = By.xpath("//div[@class='oxd-table-filter']//input[@placeholder]");
    By inputUserRole = By.xpath("(//div[@class='oxd-table-filter']//div[@class='oxd-select-text-input'])[1]");
    By inputStatus = By.xpath("(//div[@class='oxd-table-filter']//div[@class='oxd-select-text-input'])[2]");
    String dropDownBoxForAddUserXpath = "//form//label[text()='inputName']/ancestor::div[contains(@class, 'oxd-input-group')]//div[contains(@class, 'oxd-select-text-input')]";
    String dropDownOptionForAddUserXpath = "//div[@role='listbox']//*[text()='inputValue']";
    String inputBoxForAddUserXpath = "//form//label[text()='inputBoxName']/ancestor::div[contains(@class, 'oxd-input-group')]//input";
    public AdminPage clickOnAdd(){
        WebUI.click(btnAdd);
        WebUI.waitForPageLoad();
        return this;
    }

    public AdminPage clickOnDeleteSelected(){
        WebUI.click(btnDeleteSelected);
        WebUI.waitForPageLoad();
        return this;
    }

    public AdminPage clickOnDeleteIcon(){
        WebUI.click(btnDeleteUser);
        WebUI.waitForPageLoad();
        return this;
    }

    public AdminPage clickOnEditIcon(){
        WebUI.click(btnEditUser);
        WebUI.waitForPageLoad();
        return this;
    }

    public AdminPage clickOnYesDelete(){
        WebUI.click(btnYesDelete);
        WebUI.waitForPageLoad();
        return this;
    }

    public AdminPage clickOnNoCancel(){
        WebUI.click(btnNoCancel);
        WebUI.waitForPageLoad();
        return this;
    }

    public AdminPage clickOnSearch(){
        WebUI.click(btnSearch);
        return this;
    }

    public AdminPage clickOnReset(){
        WebUI.click(btnReset);
        return this;
    }

    public AdminPage setUserRole(String role){
        WebUI.click(By.xpath(dropDownBoxForAddUserXpath.replace("inputName","User Role")));
        WebUI.waitForPageLoad();
        if(!role.isEmpty()){
            WebUI.click(By.xpath(dropDownOptionForAddUserXpath.replace("inputValue", role)));
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public AdminPage setStatus(String status){
        WebUI.click(By.xpath(dropDownBoxForAddUserXpath.replace("inputName","Status")));
        WebUI.waitForPageLoad();
        if(!status.isEmpty()){
            WebUI.click(By.xpath(dropDownOptionForAddUserXpath.replace("inputValue", status)));
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public AdminPage setEmployeeName(String name){
        WebUI.click(By.xpath(inputBoxForAddUserXpath.replace("inputBoxName", "Employee Name")));
        WebUI.sendKeys(By.xpath(inputBoxForAddUserXpath.replace("inputBoxName", "Employee Name")), name);
        WebUI.waitForPageLoad();
        WebUI.waitForElementVisible(By.xpath(dropDownOptionForAddUserXpath.replace("inputValue",name)));
        WebUI.click(By.xpath(dropDownOptionForAddUserXpath.replace("inputValue",name)));
        WebUI.waitForPageLoad();
        return this;
    }

    public AdminPage setUserName(String name){
        WebUI.click(By.xpath(inputBoxForAddUserXpath.replace("inputBoxName", "Username")));
        WebUI.sendKeys(By.xpath(inputBoxForAddUserXpath.replace("inputBoxName", "Username")), name);
        WebUI.waitForPageLoad();
        return this;
    }

    public AdminPage setPassword(String password){
        WebUI.click(By.xpath(inputBoxForAddUserXpath.replace("inputBoxName", "Password")));
        WebUI.sendKeys(By.xpath(inputBoxForAddUserXpath.replace("inputBoxName", "Password")), password);
        WebUI.waitForPageLoad();
        return this;
    }

    public AdminPage setConfirmPassword(String password){
        WebUI.click(By.xpath(inputBoxForAddUserXpath.replace("inputBoxName", "Confirm Password")));
        WebUI.sendKeys(By.xpath(inputBoxForAddUserXpath.replace("inputBoxName", "Confirm Password")), password);
        WebUI.waitForPageLoad();
        return this;
    }

    public AdminPage clickOnSaveForAddUser(){
        WebUI.click(By.xpath("//button[text()=' Save ']"));
        return this;
    }

    public AdminPage clickOnCancelForNotAddUser(){
        WebUI.click(By.xpath("//button[text()=' Cancel ']"));
        return this;
    }

    public AdminPage searchUserViaUsername(String username){
        WebUI.click(inputUsername);
        WebUI.sendKeys(inputUsername, username);
        return this;
    }

    public AdminPage searchUserViaRole(String role){
        WebUI.click(inputUserRole);
        WebUI.sendKeys(inputUserRole, role);
        return this;
    }

    public AdminPage searchUserViaEmployeeName(String name){
        WebUI.click(inputEmployeeName);
        WebUI.sendKeys(inputEmployeeName, name);
        return this;
    }

    public AdminPage searchUserViaStatus(String status){
        WebUI.click(inputStatus);
        WebUI.sendKeys(inputStatus, status);
        return this;
    }

    public AdminPage clickOnChangePasswordCheckBox(){
        WebUI.check(inputCheckBox);
        return this;
    }

    public AdminPage validateUserPresent(String val){
        if(!WebUI.isElementVisible(By.xpath("//div[text()='value']".replace("value", val)))){
            Assert.fail("User not present, Search value : " + val);
        }
        return this;
    }
}
