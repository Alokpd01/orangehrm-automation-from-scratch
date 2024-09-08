package org.automation.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.pages.AdminPage;
import org.automation.pages.DashboardPage;
import org.automation.utils.WebUI;
import org.testng.annotations.Test;

public class Testcase_002_Admin {

    //Defining objects
    DashboardPage dashboardPage = new DashboardPage();
    AdminPage adminPage = new AdminPage();
    private static final Logger logger = LogManager.getLogger(Testcase_002_Admin.class);

    @Test
    public void addUser(){
        dashboardPage.moveToPage("Admin");
        WebUI.waitForPageLoad();
        logger.info("Test Execution Status: User moved to Admin page.");

        adminPage
                .clickOnAdd()
                .setUserName("TestName")
                .setUserRole("ESS")
                .setEmployeeName("Jhon Kor Doe")
                .setStatus("Disabled")
                .setPassword("Pass123456")
                .setConfirmPassword("Pass123456")
                .clickOnSaveForAddUser();

        WebUI.waitForPageLoad();
        logger.info("Test Execution Status: User successfully added the new user.");

        adminPage
                .searchUserViaUsername("TestName")
                .clickOnSearch()
                .validateUserPresent("TestName")
                .clickOnReset();

        WebUI.waitForPageLoad();
        logger.info("Test Execution Status: User successfully validated newly added user is visible on User table.");
    }
}
