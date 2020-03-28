package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CalendarEventsPageTests {
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriver driver;
    private Actions actions;
    private String storeManagerUserName="storemanager85";
    private String storeManagerPassword="UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By createCalendarEvent = By.cssSelector("a[title='Create Calendar event']");
    private By currentUser = By.cssSelector("#user-menu>a");
    private By OwnerBy = By.className("select2-chosen");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start']");


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(5);
        //hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();

        BrowserUtils.wait(5);

        driver.findElement(By.xpath("//span[@class='title title-level-2' and contains(text(),'Calendar Events')]")).click();
        BrowserUtils.wait(5);



    }

    @Test
    public void verifyCreateButton(){
        WebElement createCalendarEventBtn = driver.findElement(createCalendarEvent);
        Assert.assertTrue(createCalendarEventBtn.isDisplayed());
    }

    @Test
    public void verifyDefaultValues(){
        //Click on Create Calendar Event
        driver.findElement(createCalendarEvent).click();
        BrowserUtils.wait(3);
        //Default owner name should be current user
        String currentUserName = driver.findElement(currentUser).getText().trim();
        String defaultOwnerName = driver.findElement(OwnerBy).getText().trim();
        Assert.assertEquals(currentUserName, defaultOwnerName);

        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());

        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");

        Assert.assertEquals(actualDate, expectedDate);

        String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");

        Assert.assertEquals(actualDate, expectedTime);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
