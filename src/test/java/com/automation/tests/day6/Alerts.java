package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();//to click on the first button
        BrowserUtils.wait(3);


        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);
        driver.switchTo().alert().accept();//to click OK
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected :"+expected);
            System.out.println("Actual :"+actual);
        }
        BrowserUtils.wait(3);

        buttons.get(1).click();//to click on the second button
        BrowserUtils.wait(3);
        //to clikc cancel
        driver.switchTo().alert().dismiss();

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("expected: "+expected2);
            System.out.println("actual: "+actual2);
        }
        //TASK: click on button 3
        //Enter some text: Hello, World

        buttons.get(2).click();
        BrowserUtils.wait(3);

        Alert alert = driver.switchTo().alert();


       alert.sendKeys("Hello, World!");
       alert.accept();
        String expected3 = "Hello, World!";
        String actual3 = driver.findElement(By.id("result")).getText();

        if(actual3.endsWith(expected3)){
            System.out.println("TEST PASSED!");
        }else {
            System.out.println("TEST FAILED!");
        }

        BrowserUtils.wait(3);
        driver.quit();
    }
}
