package com.automation.tests.day13;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    @Test
    public void readProperties(){
        String browser = ConfigurationReader.getProperty("browser");
        String url= ConfigurationReader.getProperty("qa1");
        String store_manager=ConfigurationReader.getProperty("store_manager");
        String password=ConfigurationReader.getProperty("password");

        System.out.println(browser);
        System.out.println(url);
        System.out.println(store_manager);
        System.out.println(password);

    }
}
