package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {

    @Test
    public void verifyPageTitle(){
        //test --> ExtentTest object
        //we must add to every test at the beginning
        test=report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        test.info("Login as store manager");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        //if assertion passed. it will set test status in report to passed
        test.pass("Page title Dashboard was verified");

    }

    /**
     * Enter wrong credentials and verify warning message
     *
     */

    @Test
    public void verifyWarningMessage(){
        test= report.createTest("Verify warning message");
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessage(), "Invalid user name or password.");
        //take a screenshot
        BrowserUtils.getScreenshot("warning_message");
        test.pass("Warning message is displayed");
    }
}
