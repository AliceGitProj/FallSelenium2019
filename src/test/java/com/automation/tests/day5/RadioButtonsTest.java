package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) {
       //
        //
        //

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        WebElement blackButton= driver.findElement(By.id("black"));
        blackButton.click();

        BrowserUtils.wait(2);

        if(blackButton.isDisplayed() && blackButton.isEnabled()){
            System.out.println("CLICKED ON BLACK BUTTON");
            blackButton.click();
        }else {
            System.out.println("FAILED TO CLICK ON BLACK BUTTON");
        }

        if (blackButton.isSelected()) {
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
}
