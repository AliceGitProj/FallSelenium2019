package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{

        //to start selenium script we need:
        //setup Webdriver(browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();
        //RemoteWebDriver webDriv = new SafariDriver();
        //Everything starts from the WebDriver interface

        driver.get("http://google.com");//to open a website

        Thread.sleep(3000); //for demo, wait 3 seconds

        driver.close();//to close browser



    }
}
