package com.automation.tests.SelfPractice;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebOrders {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test", Keys.ENTER);
        //driver.findElement(By.cssSelector("input[value='Login']")).click();
    }

    @Test
    public void changeFirstName() {
        WebElement actualName = driver.findElement(By.xpath("//td[text()='Mark Smith']"));
        WebElement editBtn = driver.findElement(By.xpath("//td[text()='Mark Smith']/following-sibling::td//input"));
        String expected = "Mark Smith";
        Assert.assertEquals(actualName.getText(), expected);
        editBtn.click();
        WebElement nameInput = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));
        nameInput.clear();
        nameInput.sendKeys("John Smith");
        driver.findElement(By.cssSelector("input[value='Visa']")).click();
        driver.findElement(By.linkText("Update")).click();

        String expected2 = "John Smith";
        String actual2 = driver.findElement(By.xpath("//td[text()='John Smith']")).getText();
        Assert.assertEquals(actual2, expected2);

        WebElement actualCard = driver.findElement(By.xpath("//td[text()='John Smith']/following-sibling::td[8]"));
        Assert.assertEquals(actualCard.getText(), "Visa");


        ////td[text()='Mark Smith']/following-sibling::td//input
    }

    @Test
    public void deleteBob() {
        WebElement name = driver.findElement(By.xpath("//td[text()='Bob Feather']"));
        Assert.assertTrue(name.isDisplayed());
        WebElement deleteBtn = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl07_OrderSelector"));
        deleteBtn.click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//tbody//tr//td[2]"));

        for (WebElement each : list) {
            Assert.assertTrue(!each.getText().contains("Bob Feather"));

        }

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
