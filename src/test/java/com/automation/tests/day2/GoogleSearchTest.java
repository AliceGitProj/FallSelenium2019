package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.name("q")); //check for element name="q"
        //to enter text use sendKeys
        //hot to press Enter after entering the text?
        //use Key.Enter to perform keyboard click
       // search.sendKeys("Java", Keys.ENTER);
        search.sendKeys("J");
        Thread.sleep(1000);
        search.sendKeys("a");
        Thread.sleep(1000);
        search.sendKeys("v");
        Thread.sleep(1000);
        search.sendKeys("a");
        Thread.sleep(1000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        // IF SEE <a> elements, it calls link
        //visible text of this link, can be used by selenium to find this element
        WebElement news = driver.findElement(By.linkText("News"));
        news.click();
        Thread.sleep(3000);


        driver.quit();

    }
}
