package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
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
        String reportPath = System.getProperty("user.dir")+"/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(reportPath);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");
    }
    @AfterTest
    public void tearDownTest(){
        report.flush();
    }
    @BeforeMethod
    public void setup() {
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 20);
        //river.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ITestResult class describes the result of a test.
        //if test failed, take a screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            //screenshot will have a name of the test
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());
//            test.addScreenCaptureFromPath(screenshotPath);//attach screenshot
            MediaEntityModelProvider mediaModel =  MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build();
            test.fail(iTestResult.getName(),mediaModel);//attach test name that failed
            test.fail(iTestResult.getThrowable());//attach console output
        }
        Driver.closeDriver();
    }
//    @AfterMethod
//    public void teardown(ITestResult result) throws IOException {
//        if (result.getStatus() == ITestResult.FAILURE){
//            String screenshotPath = BrowserUtils.getScreenshot(result.getName());
//            test.fail(result.getName());
//            BrowserUtils.wait(4);
//            test.addScreenCaptureFromPath(screenshotPath, "Failed");
//            test.fail(result.getThrowable());
//        }
//        Driver.closeDriver();
//    }

//
//    @BeforeTest
//    public void setUpTest(){
//        report = new ExtentReports();
//        String reportPath = System.getProperty("user.dir")+"\\test-output\\report.html";
//        htmlReporter = new ExtentHtmlReporter(reportPath);
//        report.attachReporter(htmlReporter);
//        htmlReporter.config().setReportName("VYTRACK Test Automation Results");
//    }
//
//
//    @BeforeMethod
//    public void setup(){
//        String URL = ConfigurationReader.getProperty("qa1");
//        Driver.getDriver().get(URL);
//        Driver.getDriver().manage().window().maximize();
//        wait = new WebDriverWait(Driver.getDriver(), 15);
//        actions = new Actions(Driver.getDriver());
//    }
//
//    @AfterTest
//    public void tearDownTest(){
//        report.flush(); //to release a report
//    }
//
//    @AfterMethod
//    public void teardown(ITestResult iTestResult) throws IOException {
//        //ITestResult class describes the result of a test
//        //if test failed, take a screenshot
//        //no fail no screenshot
//        if(iTestResult.getStatus()==ITestResult.FAILURE){
//            //screenshot will have a name of the test
//            String screenshotPath=BrowserUtils.getScreenshot(iTestResult.getName());
//            test.fail(iTestResult.getName());   // attach test name that failed
//            BrowserUtils.wait(4);
//            test.addScreenCaptureFromPath(screenshotPath,"Failed");  // attached screenshot
//            test.fail(iTestResult.getThrowable());  //attach console output
//        }
//        BrowserUtils.wait(2);
//        Driver.closeDriver();
//    }
}
