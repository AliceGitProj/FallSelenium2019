package com.automation.tests.officeHours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesPractice {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver= DriverFactory.createADriver("chrome");
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void test(){
        System.out.println("HAHAHA");
    }
}
