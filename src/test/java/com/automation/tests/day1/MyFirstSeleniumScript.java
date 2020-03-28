package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args)throws Exception {

        //Set up Chrome driver

        WebDriverManager.chromedriver().setup();
        //create chromedriver object

        ChromeDriver driver = new ChromeDriver();
        //open some website

        driver.get("http://google.com");
        driver.manage().window().maximize();//to maximize browser window
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        String title = driver.getTitle();//returns<title>Some title</title> text
        String expectedTitle = "Google";

        System.out.println("Title is "+ title);

        if(expectedTitle.equals(title)){
            System.out.println("Test passed!");
        }else {
            System.out.println("Test failed!");
        }

        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);
        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.navigate().back();
        Thread.sleep(3000);
        verifyEquals(driver.getTitle(),"Google");
        //move forward in the browser
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("Title: "+ driver.getTitle());


        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.close(); //close must be at the end
    }

    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
    }
}
