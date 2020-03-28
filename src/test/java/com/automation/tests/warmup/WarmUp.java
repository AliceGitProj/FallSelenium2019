package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUp {
    static WebDriver driver;
    public static void main(String[] args)throws Exception {
       //Ebay();
        //AmazonTest();
        Wikipedia();
    }

    public static void Ebay()throws Exception {
        driver=DriverFactory.createADriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ")[0]);
        driver.quit();
    }

    public static void AmazonTest(){

        driver= DriverFactory.createADriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        String title = driver.getTitle();
        if(title.contains("java book")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.quit();
    }

    public static void Wikipedia() throws Exception{
        driver = DriverFactory.createADriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.RETURN);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(2000);

        String link = driver.getCurrentUrl(); // to get link as a String

        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.quit();
    }
}
