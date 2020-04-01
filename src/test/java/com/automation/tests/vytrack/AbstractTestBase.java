package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public abstract class AbstractTestBase {
    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeTest
    public void setUpTest(){
        report = new ExtentReports();
        String reportPath = System.getProperty("user.dir")+"\\test-output\\report.html";
        htmlReporter = new ExtentHtmlReporter(reportPath);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");
    }


    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }

    @AfterTest
    public void tearDownTest(){
        report.flush(); //to release a report
    }

    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ITestResult class describes the result of a test
        //if test failed, take a screenshot
        //no fail no screenshot
        if(iTestResult.getStatus()==ITestResult.FAILURE){
            //screenshot will have a name of the test
            String screenshotPath=BrowserUtils.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName());   // attach test name that failed
            BrowserUtils.wait(4);
            test.addScreenCaptureFromPath(screenshotPath,"Failed");  // attached screenshot
            test.fail(iTestResult.getThrowable());  //attach console output
        }
        BrowserUtils.wait(2);
        Driver.closeDriver();
    }
}
