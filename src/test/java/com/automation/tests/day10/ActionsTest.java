package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionsTest {
    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        actions = new Actions(driver);
    }

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();

        //hover over image to make text visible

        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        //verify that webElement that contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());
        ////h5[text()='name: user1']
        //move to the second image
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());

    }

    @Test
    public void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        BrowserUtils.wait(3);
        WebElement EnabledBut = driver.findElement(By.id("ui-id-3"));
        WebElement downLoad = driver.findElement(By.id("ui-id-4"));
        WebElement pdfBut = driver.findElement(By.id("ui-id-5"));

        actions.moveToElement(EnabledBut).pause(1000)
                .moveToElement(downLoad).pause(1000).
                click(pdfBut).build().
                perform();

    }

    @Test
    public void dragAndDrop(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon,earth).perform();

        String expected = "You did great!";
        String actual = earth.getText();

        Assert.assertEquals(actual,expected);

        

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
