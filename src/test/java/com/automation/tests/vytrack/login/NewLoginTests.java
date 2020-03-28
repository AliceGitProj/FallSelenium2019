package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.TestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends TestBase {

    @Test
    public void verifyPageTitle(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        String title = Driver.getDriver().getTitle();
        //Assert.assertEquals(title,"Dashboard");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");

    }
}
