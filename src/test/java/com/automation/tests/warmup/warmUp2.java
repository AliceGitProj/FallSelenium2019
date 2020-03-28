package com.automation.tests.warmup;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class warmUp2 {
    private WebDriver driver;
    /*
    Go to http://practice.cybertekschool.com/tables
Click on "Last name" column name
Verfiy that table is sorted by last name in alphabetic order.

     */
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.setHeadless(false);
        driver=new ChromeDriver(chromeOptions);

        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }

    @Test
    public void isSorted(){

        WebElement lastName = driver.findElement(By.xpath("//table[1]//th[1]"));
        lastName.click();
        List <WebElement> lastNames = driver.findElements(By.xpath("//table[1]//tbody//tr//td[1]"));
        List<String>stringNames= Collections.singletonList(lastNames.toString());
       // Assert.assertTrue(Collections.);

    }


}
