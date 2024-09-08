package org.automation.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.drivers.DriverManager;
import org.automation.pages.LoginOrangeHrm;
import org.automation.utils.BaseUtil;
import org.automation.utils.WebUI;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testcase_001_Login extends BaseUtil {

    //Defining objects
    private LoginOrangeHrm loginOrangeHrm = new LoginOrangeHrm();
    private static final Logger logger = LogManager.getLogger(Testcase_001_Login.class);

    @BeforeSuite
    public void login(){
        setup();
        loginOrangeHrm
                .setUsername()
                .setPassword()
                .clickLoginBtn();
    }

    @Test(priority = 1)
    public void validateUserLoggedIn(){
        String actualUrl = WebUI.getCurrentUrl();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        if(actualUrl.equalsIgnoreCase(expectedUrl)){
            logger.info("Test Execution Status: User logged into OrangeHrm portal.");
        }
    }

    @AfterSuite
    public void logout(){
        if(DriverManager.getDriver() != null){
            try{
                WebUI.waitForPageLoad();
                loginOrangeHrm
                        .clickOnDropDownForLogout()
                        .clickOnLogout();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            finally {
                WebUI.closeBrowser();
                logger.info("Test Execution Status: User logged out from the OrangeHrm portal and clear the driver.");
            }
        }
    }

}
