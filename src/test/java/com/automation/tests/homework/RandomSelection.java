package com.automation.tests.homework;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

    public class RandomSelection {

        private WebDriver driver = Driver.getDriver();

        @Test
        public void test(){

            driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
            BrowserUtils.wait(2);
            driver.quit();

        }
    }


