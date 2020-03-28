package com.automation.tests.day4;

import java.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsTest {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
//        for(WebElement link : links){
//            System.out.println(link.getText());
//            System.out.println(link.getAttribute("href"));
//            System.out.println();
//
//        }

        for (int i = 1; i < links.size(); i++) {
            //driver.navigate().refresh();

            links.get(i).click();
            driver.navigate().back();
            links = driver.findElements(By.tagName("a"));

//           driver.findElements(By.tagName("a")).get(i).click();
//           driver.navigate().back();

        }
        driver.quit();

    }
}
