package org.automation.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.dataprovider.PIMPageDataProvider;
import org.automation.pages.DashboardPage;
import org.automation.pages.PIMPage;
import org.automation.utils.WebUI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase_003_PIM {

    //Defining object
    DashboardPage dashboardPage = new DashboardPage();
    PIMPage pimPage = new PIMPage();
    private static final Logger logger = LogManager.getLogger(Testcase_003_PIM.class);

    @Test(priority = 1, dataProvider = "addEmployee", dataProviderClass = PIMPageDataProvider.class)
    public void  addEmployee(String description, String fName,String mName, String lName, String employeeId, String isCreateLogin, String username, String status, String password, String confirmPass, String isSave, String isCancel, String isSearch, String errorMessage){

        dashboardPage
                .moveToPage("PIM");
        WebUI.waitForPageLoad();
        logger.info("Test case name: " + description);
        logger.info("Test Data: " +
                "\n Name : " + (fName + mName + lName) +
                "\n EmployeeID: " + employeeId +
                "\n isCreateLogin: " + Boolean.parseBoolean(isCreateLogin.toLowerCase()) +
                "\n Username: " + username +
                "\n Status: " + status +
                "\n Password: " + password +
                "\n Confirm password: " + confirmPass +
                "\n isSave: " + Boolean.parseBoolean(isSave.toLowerCase()) +
                "\n isCancel: " + Boolean.parseBoolean(isCancel.toLowerCase()) +
                "\n isSearch: " + Boolean.parseBoolean(isSearch.toLowerCase()) +
                "\n Error message: " + errorMessage);
        logger.info("Test Execution Status: User move to PIM page.");

        pimPage
                .clickOnAdd()
                .setFirstName(fName)
                .setMiddleName(mName)
                .setLastName(lName)
                .setEmployeeId(employeeId)
                .createLoginCred(Boolean.parseBoolean(isCreateLogin))
                .setUsername(username)
                .setPassword(password)
                .setConfirmPassword(confirmPass)
                .setStatus(status)
                .clickOnSaveForEmployee(Boolean.parseBoolean(isSave));

        WebUI.waitForSecond(4);
        if(Boolean.parseBoolean(isCancel)){
            WebUI.waitForSecond(3);
            String actualErrorMessage = pimPage.getErrorMessage();
            if(!actualErrorMessage.equalsIgnoreCase(errorMessage)){
                WebUI.takeScreenshot(this.getClass().getSimpleName(), "addEmployee");
                Assert.fail("Error message not matched! , actual error message : " + actualErrorMessage + " , expected error message : " + errorMessage);
            }
            pimPage.clickOnCancelForEmployee();
            WebUI.waitForSecond(2);
        }

        if(Boolean.parseBoolean(isSave) && Boolean.parseBoolean((isSearch))){
            String fullName = fName + " " + mName;
            boolean isEmployeeVisible = pimPage
                                            .clickOnEmployeeList()
                                            .searchEmployee(fullName, employeeId)
                                            .validateEmployeeVisible(fullName, employeeId);

            System.out.println("Value of isEmployeeVisible: " + isEmployeeVisible);
            if(!isEmployeeVisible){
                WebUI.takeScreenshot(this.getClass().getSimpleName(), "addEmployee");
                Assert.fail("Employee add failed");
            } else {
                logger.info("Test Execution Status: User successfully added the employee from PIM page.");
                logger.info("Test Execution Status: User successfully validated newly added employee is visible on employee table.");
            }

            pimPage.resetSearch();
            WebUI.waitForPageLoad();
        }
    }

    @Test(priority = 2, dataProvider = "editEmployee", dataProviderClass = PIMPageDataProvider.class)
    public void editEmployee(String description, String existingName, String fName, String mName, String lName, String employeeId, String otherId, String dlNumber, String licenseExpiryDate, String nationality, String maritalStatus, String dob, String gender, String bloodType, String testField, String isSearch, String errorMessage){

        dashboardPage
                .moveToPage("PIM");
        WebUI.waitForPageLoad();

        logger.info("Test case name: " + description);
        logger.info("Test Data: " +
                "\n Existing Name: " + existingName +
                "\n Name : " + (fName + mName + lName) +
                "\n EmployeeID: " + employeeId +
                "\n OtherId: " + otherId +
                "\n Driving License Number: " + dlNumber +
                "\n License Expiry Date: " + licenseExpiryDate +
                "\n Nationality: " + nationality +
                "\n Marital Status: " + maritalStatus +
                "\n Date Of Birth: " + dob +
                "\n Gender: " + gender +
                "\n Blood Type: " + bloodType +
                "\n Test Field: " + testField +
                "\n isSearch: " + Boolean.parseBoolean(isSearch.toLowerCase()) +
                "\n Error message: " + errorMessage);
        logger.info("Test Execution Status: User move to PIM page.");

        logger.info("Test Execution Status: Searching existing employee for edit purpose");
        String fullName = fName + " " + mName;
        pimPage
                .clickOnEmployeeList()
                .searchEmployee(existingName, null);
        WebUI.waitForPageLoad();
        WebUI.waitForLoaderNotVisible();
        WebUI.waitForSecond(30);

        pimPage.clickOnEdit();
        WebUI.waitForPageLoad();
        WebUI.waitForLoaderNotVisible();

        pimPage
                .editFirstName(fName)
                .editMiddleName(mName)
                .editLastName(lName)
                .editEmployeeId(employeeId)
                .editOtherId(otherId)
                .editDriverLicenseNumber(dlNumber)
                .editLicenseExpiryDate(licenseExpiryDate)
                .editNationality(nationality)
                .editMaritalStatus(maritalStatus)
                .editDateOfBirth(dob)
                .editGender(gender)
                .editBloodType(bloodType)
                .editTestField(testField)
                .clickOnSaveForPersonalDetails()
                .clickOnSaveForCustomDetails();

        //Validating error message
        if(!errorMessage.equalsIgnoreCase("No Error")){
            String actualErrorMessage = pimPage.getErrorMessage();
            if (!actualErrorMessage.equalsIgnoreCase(errorMessage)){
                logger.info("Error message not match, actual error message: " + actualErrorMessage + " , expected error message: " + errorMessage);
                Assert.fail("Error message not match, actual error message: " + actualErrorMessage + " , expected error message: " + errorMessage);
            }
        }

        //Move to EmployeeList tab
        pimPage.clickOnEmployeeList();
        WebUI.waitForPageLoad();
        WebUI.waitForSecond(10);

        //Search employee
        if(Boolean.parseBoolean(isSearch)){
            boolean isEmployeeVisible = pimPage
                            .searchEmployee(fullName, employeeId)
                            .validateEmployeeVisible(fullName, employeeId);

            if(isEmployeeVisible){
                logger.info("Test Execution Status: Employee detail edited successfully.");
            }else {
                Assert.fail("Employee not visible after edited");
            }

            pimPage.resetSearch();
            WebUI.waitForPageLoad();
        }
    }

    @Test(priority = 3, dataProvider = "deleteEmployee", dataProviderClass = PIMPageDataProvider.class)
    public void deleteEmployee(String description, String existingName, String employeeId, String deleteType, String isSearch){
        dashboardPage
                .moveToPage("PIM");
        WebUI.waitForPageLoad();

        logger.info("Test case name: " + description);
        logger.info("Test Data: " +
                "\n Existing Name: " + existingName +
                "\n EmployeeID: " + employeeId +
                "\n EmployeeID: " + deleteType +
                "\n isSearch: " + Boolean.parseBoolean(isSearch.toLowerCase()));
        logger.info("Test Execution Status: User move to PIM page.");

        logger.info("Test Execution Status: Searching employee for delete purpose");
        if(!deleteType.equalsIgnoreCase("All")){
            pimPage
                    .clickOnEmployeeList()
                    .searchEmployee(existingName, employeeId);
            WebUI.waitForPageLoad();
            WebUI.waitForLoaderNotVisible();
        }

        if(deleteType.equalsIgnoreCase("normal")){
            pimPage
                    .clickOnDelete()
                    .clickOnYesDeleteFromDialog();
        }else if(deleteType.equalsIgnoreCase("selected")){
            pimPage
                    .clickOnDeleteSelected()
                    .clickOnYesDeleteFromDialog();
        } else {
            pimPage
                    .deleteAllEmployeeData()
                    .clickOnYesDeleteFromDialog();
        }

        if(Boolean.parseBoolean(isSearch)){
            boolean isEmployeeVisibleAfterDelete = pimPage
                    .searchEmployee(existingName, employeeId)
                    .validateEmployeeNotVisibleAfterDelete();

            if(isEmployeeVisibleAfterDelete){
                logger.info("Employee deleted successfully.");
            }else {
                Assert.fail("Employee not deleted. Employee name: " + existingName);
            }

            pimPage.resetSearch();
            WebUI.waitForPageLoad();
        }
    }
}
