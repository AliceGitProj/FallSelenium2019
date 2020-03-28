package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select lanuagesSelect = new Select(driver.findElement(By.name("Languages")));
        //returns true is dropdown returns multiple selections
        boolean isMultiple = lanuagesSelect.isMultiple();
        System.out.println(isMultiple);

        lanuagesSelect.selectByVisibleText("Java");
        lanuagesSelect.selectByVisibleText("JavaScript");
        lanuagesSelect.selectByVisibleText("Python");

        List<WebElement> selectedLanguages = lanuagesSelect.getAllSelectedOptions();

        for(WebElement selectedLanguage :selectedLanguages){
            System.out.println(selectedLanguage.getText());
        }
        BrowserUtils.wait(3);

        lanuagesSelect.deselectByVisibleText("Java");
        BrowserUtils.wait(3);
        lanuagesSelect.deselectAll();

        BrowserUtils.wait(3);
        driver.quit();

    }
}
