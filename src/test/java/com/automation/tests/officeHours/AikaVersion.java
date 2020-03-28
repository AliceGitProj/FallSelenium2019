package com.automation.tests.officeHours;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AikaVersion {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

       /*
       // Negative with <tshirt>
        driver.findElement(By.id("search_query_top")).sendKeys("tshirt", Keys.ENTER);
        String expectedText = "No results were found for your search \"tshirt\"";
        WebElement textElement = driver.findElement(By.xpath("//*[@class = \"alert alert-warning\"]"));
        System.out.println("textElement.getText() = " + textElement.getText());
        Assert.assertEquals(expectedText, textElement.getText());
        */

        // Positive with <t-shirt>
        driver.findElement(By.id("search_query_top")).sendKeys("t-shirt", Keys.ENTER);
        String expectedText ="Showing 1 - 1 of 1 item";
        WebElement textElement = driver.findElement(By.className("product-count"));
        Verify.verify(textElement.getText().equals(expectedText), "text not equal to expected text");
        System.out.println("Items found: " + textElement.getText());

        //  Adding to cart

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")).click();
        Thread.sleep(4000);
        String expTxtAddCart = "Product successfully added to your shopping cart";
        WebElement textElement2= driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"));
        //System.out.println(textElement2.getText());
        Verify.verify(textElement2.getText().equals(expTxtAddCart), "text not equal to expected text from add to cart");
    }
}
