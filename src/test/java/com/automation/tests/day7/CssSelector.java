package com.automation.tests.day7;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelector {

    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement heading = driver.findElement(By.cssSelector(".h3"));
        WebElement home = driver.findElement(By.cssSelector(".nav-link"));
        

    }
}
