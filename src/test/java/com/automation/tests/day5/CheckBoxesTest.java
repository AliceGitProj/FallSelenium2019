package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        //TASK
        //verify that 1st checkbox is not selected and second is selected
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));


        for (int i = 0; i < checkBoxes.size(); i++) {
//            if(checkBoxes.get(i).isSelected()){
////                System.out.println(" is SELECTED!");
////                //System.out.println( driver.findElement(By.id("id"))+ "SELECTED!");
////            }else if(!checkBoxes.get(i).isSelected()) {
////                //System.out.println(driver.findElement(By.id("id"))+ " IS NOT SELECTED");
////                System.out.println(" is Not SELECTED!");
////            }

            if(checkBoxes.get(i).isSelected()){
                System.out.println("CheckBox "+(i+1)+" is selected");
            }else{
                System.out.println("CheckBox "+(i+1)+" is not selected");
            }

        }

        BrowserUtils.wait(2);


        driver.quit();

    }
}
