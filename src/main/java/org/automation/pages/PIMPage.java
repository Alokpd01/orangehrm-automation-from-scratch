package org.automation.pages;

import org.automation.utils.WebUI;
import org.openqa.selenium.By;

public class PIMPage {

    String btnCustom = "//button[normalize-space()='btnName']";
    String searchInputBoxCustom = "//label[normalize-space()=\"searchLabelName\"]/ancestor::div[contains(@class, 'oxd-input-group')]//input";
    String dropDownForSearchBoxCustom = "//label[@class='oxd-label' and normalize-space()='searchLabelName']/ancestor::div[contains(@class, 'oxd-input-group')]//div[@class='oxd-select-text-input']";
    String dropDownOptionCustom = "//div[@role='listbox']//*[text()='inputValue']";
    String inputNameForEmployeeCustom = "//input[@name='nameField']";
    String checkBoxEmployeeStatus = "//label[normalize-space()='employeeStatus']/child::input/ancestor::label";
    String divEmployeeList = "//div[contains(@class, 'orangehrm-employee-list')]//div[text()='value']";
    By checkBoxCreateLoginDetail = By.xpath("//input[@type='checkbox']/following-sibling::span");
    By btnEditEmployee = By.xpath("//i[contains(@class, 'bi-pencil')]/parent::button");
    By btnDeleteEmployee = By.xpath("//i[contains(@class, 'bi-trash')]/parent::button");
    By checkBoxEmployeeFromTable = By.xpath("//div[@class='oxd-table-card']/descendant::i[contains(@class, 'bi-check')]/parent::span/preceding-sibling::input");
    By spanErrorMessage = By.xpath("//span[contains(@class, 'oxd-input-field-error-message')]");
    By btnSavePersonalDetails = By.xpath("//h6[normalize-space()='Personal Details']/ancestor::div[contains(@class, 'orangehrm-vertical-padding')]//button[normalize-space()='Save']");
    By btnSaveCustomField = By.xpath("//div[@class='orangehrm-custom-fields']//button[normalize-space()='Save']");
    By inputSelectAll = By.xpath("//div[@class='oxd-table-header']//input");
    public PIMPage clickOnAdd(){
        if(WebUI.isButtonEnable(By.xpath(btnCustom.replace("btnName","Add")))){
            WebUI.click(By.xpath(btnCustom.replace("btnName","Add")));
        }
        WebUI.waitForPageLoad();
        WebUI.waitForSecond(1);
        WebUI.waitForElementVisible(By.xpath(inputNameForEmployeeCustom.replace("nameField","firstName")));
        return this;
    }

    public PIMPage clickOnEmployeeList(){
        WebUI.click(By.xpath("//a[normalize-space()='Employee List']"));
        WebUI.waitForSecond(3);
        WebUI.waitForPageLoad();
        return this;
    }

    public PIMPage setValueToInputFieldWithoutLabel(String fieldName, String value){
        if(value != null){
            WebUI.clearText(By.xpath(inputNameForEmployeeCustom.replace("nameField",fieldName)));
            WebUI.click(By.xpath(inputNameForEmployeeCustom.replace("nameField",fieldName)));
            WebUI.sendKeys(By.xpath(inputNameForEmployeeCustom.replace("nameField", fieldName)),value);
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage setValueToInputFieldWithLabel(String labelName, String value){
        if(value != null){
            WebUI.clearText(By.xpath(searchInputBoxCustom.replace("searchLabelName", labelName)));
            WebUI.click(By.xpath(searchInputBoxCustom.replace("searchLabelName", labelName)));
            WebUI.sendKeys(By.xpath(searchInputBoxCustom.replace("searchLabelName", labelName)), value);
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage setValueFromDropDown(String dropDownFieldName, String value){
        if(value != null){
            WebUI.click(By.xpath(dropDownForSearchBoxCustom.replace("searchLabelName", dropDownFieldName)));
            WebUI.waitForPageLoad();
            WebUI.click(By.xpath(dropDownOptionCustom.replace("inputValue", value)));
        }
        return this;
    }

    public PIMPage setFirstName(String fName){
        if(fName != null){
            WebUI.clearText(By.xpath(inputNameForEmployeeCustom.replace("nameField","firstName")));
            WebUI.click(By.xpath(inputNameForEmployeeCustom.replace("nameField","firstName")));
            WebUI.sendKeys(By.xpath(inputNameForEmployeeCustom.replace("nameField","firstName")),fName);
            WebUI.waitForPageLoad();
        }
        return this;
    }
    public PIMPage setMiddleName(String mName){
        if(mName != null){
            WebUI.clearText(By.xpath(inputNameForEmployeeCustom.replace("nameField","middleName")));
            WebUI.click(By.xpath(inputNameForEmployeeCustom.replace("nameField","middleName")));
            WebUI.sendKeys(By.xpath(inputNameForEmployeeCustom.replace("nameField","middleName")),mName);
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage setLastName(String lName){
        if(lName != null){
            WebUI.clearText(By.xpath(inputNameForEmployeeCustom.replace("nameField","lastName")));
            WebUI.click(By.xpath(inputNameForEmployeeCustom.replace("nameField","lastName")));
            WebUI.sendKeys(By.xpath(inputNameForEmployeeCustom.replace("nameField","lastName")),lName);
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage setEmployeeId(String empId){
        WebUI.clearText(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Employee Id")));
        if(empId != null){
            WebUI.click(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Employee Id")));
            WebUI.sendKeys(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Employee Id")),empId);
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage createLoginCred(boolean isCreate){
        if(isCreate == true){
            WebUI.click(checkBoxCreateLoginDetail);
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage setUsername(String userName){
        if(userName != null){
            WebUI.clearText(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Username")));
            WebUI.click(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Username")));
            WebUI.sendKeys(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Username")), userName);
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage setStatus(String status){
        if(status != null){
            WebUI.check(By.xpath(checkBoxEmployeeStatus.replace("employeeStatus", status)));
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage setPassword(String password){
        if(password != null){
            WebUI.clearText(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Password")));
            WebUI.click(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Password")));
            WebUI.sendKeys(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Password")), password);
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage setConfirmPassword(String password){
        if(password != null){
            WebUI.clearText(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Confirm Password")));
            WebUI.click(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Confirm Password")));
            WebUI.sendKeys(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Confirm Password")), password);
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage clickOnSaveForEmployee(boolean isSave){
        WebUI.click(By.xpath(btnCustom.replace("btnName", "Save")));
        if(isSave){
            WebUI.waitForElementVisible(By.xpath(btnCustom.replace("btnName", "Add")));
        }
        WebUI.waitForSecond(3);
        WebUI.waitForPageLoad();
        return this;
    }

    public PIMPage clickOnCancelForEmployee(){
        WebUI.click(By.xpath(btnCustom.replace("btnName", "Cancel")));
        WebUI.waitForSecond(5);
        WebUI.waitForPageLoad();
        return this;
    }

    public PIMPage searchEmployee(String fullName, String empId){
        searchEmployeeViaName(fullName);
        searchEmployeeViaId(empId);
        return this;
    }

    public boolean validateEmployeeVisible(String fullName, String empId){
        boolean isEmployeeVisible = false;

        if(fullName != null){
            isEmployeeVisible = validateEmployeeInTable(fullName);
        }

        if(empId != null){
            isEmployeeVisible = validateEmployeeInTable(empId);
        }

        return isEmployeeVisible;
    }

    public String getErrorMessage(){
        WebUI.waitForSecond(2);
        String msg = WebUI.getText(spanErrorMessage);
        return msg;
    }

    public PIMPage searchEmployeeViaName(String name){
        if(name != null){
            WebUI.clearText(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Employee Name")));
            WebUI.click(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Employee Name")));
            WebUI.sendKeys(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Employee Name")), name);
            WebUI.click(By.xpath(btnCustom.replace("btnName", "Search")));
            WebUI.waitForSecond(10);
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage searchEmployeeViaId(String empId){
        if(empId != null){
            WebUI.clearText(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Employee Id")));
            WebUI.click(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Employee Id")));
            WebUI.sendKeys(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Employee Id")), empId);
            WebUI.click(By.xpath(btnCustom.replace("btnName", "Search")));
            WebUI.waitForSecond(3);
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage searchEmployeeViaSupervisor(String supervisor){
        if(supervisor != null){
            WebUI.clearText(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Supervisor Name")));
            WebUI.click(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Supervisor Name")));
            WebUI.sendKeys(By.xpath(searchInputBoxCustom.replace("searchLabelName", "Supervisor Name")), supervisor);
            WebUI.click(By.xpath(btnCustom.replace("btnName", "Search")));
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage searchEmployeeViaStatus(String status){
        if(status != null){
            WebUI.click(By.xpath(dropDownForSearchBoxCustom.replace("searchLabelName", "Employment Status")));
            WebUI.waitForPageLoad();
            WebUI.click(By.xpath(dropDownOptionCustom.replace("inputValue", status)));
            WebUI.click(By.xpath(btnCustom.replace("btnName", "Search")));
            WebUI.waitForPageLoad();
        }
        return this;
    }
    public PIMPage searchEmployeeViaInclude(String include){
        if(include != null){
            WebUI.click(By.xpath(dropDownForSearchBoxCustom.replace("searchLabelName", "Include")));
            WebUI.waitForPageLoad();
            WebUI.click(By.xpath(dropDownOptionCustom.replace("inputValue", include)));
            WebUI.click(By.xpath(btnCustom.replace("btnName", "Search")));
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage searchEmployeeViaJob(String job){
        if(job != null){
            WebUI.click(By.xpath(dropDownForSearchBoxCustom.replace("searchLabelName", "Job Title")));
            WebUI.waitForPageLoad();
            WebUI.click(By.xpath(dropDownOptionCustom.replace("inputValue", job)));
            WebUI.click(By.xpath(btnCustom.replace("btnName", "Search")));
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage searchEmployeeViaUnit(String unit){
        if(unit != null){
            WebUI.click(By.xpath(dropDownForSearchBoxCustom.replace("searchLabelName", "Sub Unit")));
            WebUI.waitForPageLoad();
            WebUI.click(By.xpath(dropDownOptionCustom.replace("inputValue", unit)));
            WebUI.click(By.xpath(btnCustom.replace("btnName", "Search")));
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage clickOnEdit(){
        WebUI.click(btnEditEmployee);
        WebUI.waitForPageLoad();
        return this;
    }

    public PIMPage editFirstName(String fName){
        setValueToInputFieldWithoutLabel("firstName", fName);
        return this;
    }

    public PIMPage editMiddleName(String mName){
        setValueToInputFieldWithoutLabel("middleName", mName);
        return this;
    }

    public PIMPage editLastName(String lName){
        setValueToInputFieldWithoutLabel("lastName", lName);
        return this;
    }

    public PIMPage editEmployeeId(String empId){
        setValueToInputFieldWithLabel("Employee Id", empId);
        return this;
    }

    public PIMPage editOtherId(String othId){
        setValueToInputFieldWithLabel("Other Id", othId);
        return this;
    }

    public PIMPage editDriverLicenseNumber(String driverLicNum){
        setValueToInputFieldWithLabel("Driver's License Number", driverLicNum);
        return this;
    }

    public PIMPage editLicenseExpiryDate(String licExpiryDate){
        setValueToInputFieldWithLabel("License Expiry Date", licExpiryDate);
        return this;
    }

    public PIMPage editDateOfBirth(String dob){
        setValueToInputFieldWithLabel("Date of Birth", dob);
        return this;
    }

    public PIMPage editNationality(String nationality){
        setValueFromDropDown("Nationality", nationality);
        return this;
    }

    public PIMPage editMaritalStatus(String maritalStatus){
        setValueFromDropDown("Marital Status", maritalStatus);
        return this;
    }

    public PIMPage editBloodType(String bloodType){
        setValueFromDropDown("Blood Type", bloodType);
        return this;
    }

    public PIMPage editGender(String gender){
        if(gender != null){
            WebUI.check(By.xpath(checkBoxEmployeeStatus.replace("employeeStatus", gender)));
            WebUI.waitForPageLoad();
        }
        return this;
    }

    public PIMPage editTestField(String testField){
        setValueToInputFieldWithLabel("Test_Field", testField);
        return this;
    }

    public PIMPage clickOnSaveForPersonalDetails(){
        WebUI.click(btnSavePersonalDetails);
        WebUI.waitForPageLoad();
        WebUI.waitForSecond(10);
        return this;
    }

    public PIMPage clickOnSaveForCustomDetails(){
        WebUI.click(btnSaveCustomField);
        WebUI.waitForPageLoad();
        WebUI.waitForSecond(10);
        return this;
    }

    public PIMPage clickOnDelete(){
        WebUI.click(btnDeleteEmployee);
        WebUI.waitForPageLoad();
        return this;
    }

    public PIMPage clickOnDeleteSelected(){
        WebUI.waitForPageLoad();
        WebUI.clickUsingJs(checkBoxEmployeeFromTable);
        WebUI.waitForPageLoad();
        WebUI.click(By.xpath(btnCustom.replace("btnName", "Delete Selected")));
        WebUI.waitForPageLoad();
        return this;
    }

    public PIMPage clickOnYesDeleteFromDialog(){
        WebUI.waitForElementVisible(By.xpath(btnCustom.replace("btnName", "Yes, Delete")));
        WebUI.click(By.xpath(btnCustom.replace("btnName", "Yes, Delete")));
        WebUI.waitForLoaderNotVisible();
        return this;
    }

    public PIMPage deleteAllEmployeeData(){
        WebUI.waitForPageLoad();
        WebUI.clickUsingJs(inputSelectAll);
        WebUI.waitForPageLoad();
        WebUI.click(By.xpath(btnCustom.replace("btnName", "Delete Selected")));
        WebUI.waitForPageLoad();
        return this;
    }

    public PIMPage resetSearch(){
        WebUI.click(By.xpath(btnCustom.replace("btnName", "Reset")));
        WebUI.waitForPageLoad();
        return this;
    }

    public boolean validateEmployeeInTable(String value){
        WebUI.waitForPageLoad();
        return WebUI.isElementVisible(By.xpath(divEmployeeList.replace("value", value)));
    }

    public boolean validateEmployeeNotVisibleAfterDelete(){
        WebUI.waitForPageLoad();
        return WebUI.isElementVisible(By.xpath("//span[normalize-space()='No Records Found']"));
    }

}
