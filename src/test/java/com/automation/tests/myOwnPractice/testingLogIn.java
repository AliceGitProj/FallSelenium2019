package com.automation.tests.myOwnPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testingLogIn {

    public static void main(String[] args)throws Exception {
        TestWebsite();
    }

    public static void TestWebsite()throws Exception{
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://thedemosite.co.uk/index.php");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();

        driver.findElement(By.name("username")).sendKeys("seleniumMas");
        driver.findElement(By.name("password")).sendKeys("code365d");
        Thread.sleep(2000);
        driver.findElement(By.name("FormsButton2")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
        driver.findElement(By.name("username")).sendKeys("seleniumMas");
        driver.findElement(By.name("password")).sendKeys("code365d");
        Thread.sleep(2000);
        driver.findElement(By.name("FormsButton2")).click();
        //String expectedMessage = "**Successful Login**";
        //WebElement actualMessage = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
        Thread.sleep(2000);
        driver.close();
    }
}



