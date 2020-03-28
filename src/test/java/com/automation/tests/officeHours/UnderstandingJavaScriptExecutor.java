package com.automation.tests.officeHours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UnderstandingJavaScriptExecutor {
    @Test(description = "Send text to search box")
    public void test1(){
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'");
    }

    @Test(description = "get the page title")
    public void testcase3(){
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("https://www.etsy.com/");

        JavascriptExecutor js =(JavascriptExecutor)driver;
        String pageTitle= js.executeScript("return document.title").toString();
        System.out.println(pageTitle);
    }
}
