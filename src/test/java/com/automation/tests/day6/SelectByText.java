package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        Select selectSimpleDropdown = new Select(simpleDropdown);
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        selectSimpleDropdown.selectByVisibleText("Option 1");

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("2003");
        selectMonth.selectByVisibleText("February");
        selectDay.selectByVisibleText("1");
        BrowserUtils.wait(3);

        List<WebElement> months = selectMonth.getOptions();
        for(WebElement eachMonth : months){
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("District Of Columbia");

        //option that is currently selected
        //getFirstSelectedOption()
        String selected = stateSelect.getFirstSelectedOption().getText();
        if(selected.equals("District Of Columbia")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        List<WebElement>states = stateSelect.getOptions();
        for(WebElement stateOption:states){
            System.out.println(stateOption.getText());
        }

        BrowserUtils.wait(3);
        driver.quit();
    }
}
