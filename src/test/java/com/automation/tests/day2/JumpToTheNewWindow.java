package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        //every window has some ID - its called window handle
        //based on window handle, we will switch in between windows
        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        //returns id's of all currently opened windows
        //Set does not allow duplicates
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);
        System.out.println("Before switch : "+ driver.getCurrentUrl());
        //since we know id of original window
        for(String windowID : windowHandles){

            if(!windowID.equals(windowHandle)){
                driver.switchTo().window(windowID);
            }
        }
        System.out.println("AFter switch : "+ driver.getCurrentUrl());
        driver.close();
    }

    /**
     * This method helps to switch in between windows based on page title
     * @param pageTitle
     * @param driver
     */
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String>windows = driver.getWindowHandles();
        for(String window : windows){
            driver.switchTo().window(window);
            if(driver.getTitle().equals(pageTitle)){
                break;
            }
        }

    }
}
