package com.automation.tests.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class officeClass {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();
        BrowserUtils.wait(3);
        //click on contacts
        //create contact
        //Use map to store information and use it later to enter in UI
        // //tag[@attribute='value']
        WebElement contact_link = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        BrowserUtils.wait(3);
        String currentTitle = driver.getTitle();
        if (currentTitle.equalsIgnoreCase("Create Contact - Contacts - Customers")) {
            System.out.println("Title is expected");
        } else {
            System.out.println("Title is NOT expected");
        }
        HashMap<String, String> contact1 = new HashMap<>();
        contact1.put("First Name", "John");
        contact1.put("Last name", "Smith");
        contact1.put("Phone", "517-236-4567");
        contact1.put("Street", "400 Main Street");
        contact1.put("City", "Tysons");
        contact1.put("Zip Code", "22102");
        contact1.put("Sales Group", "true");
        contact1.put("Country", "United States");

        System.out.println("contact1 = " + contact1);

        WebElement first_name = driver.findElement(By.xpath("(//input[@data-name = 'field__first-name'])[1]"));
        WebElement last_name = driver.findElement(By.xpath("(//input[@data-name = 'field__last-name'])[1]"));
        WebElement phone = driver.findElement(By.name("oro_contact_form[phones][0][phone]"));
        WebElement street = driver.findElement(By.name("oro_contact_form[addresses][0][street]"));

        first_name.sendKeys(contact1.get("First Name"));
        last_name.sendKeys(contact1.get("Last Name"));
        phone.sendKeys(contact1.get("Phone"));
        street.sendKeys(contact1.get("Street"));



        WebElement country=driver.findElement(By.name("oro_contact_form[addresses][0][country]"));
        Select country_drpdwn = new Select(country);
        country_drpdwn.selectByVisibleText(contact1.get("Country"));





    }
}
