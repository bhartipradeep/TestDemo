package com.rx.qa.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {

    public static Properties prop;
    public static WebDriver driver;

    public testBase() throws IOException {
        prop = new Properties();
        FileInputStream fp = new FileInputStream("/Users/pradeepbharti/Desktop/Automation1stApril/ScipherRx/src/main/java/com/rx/qa/config/config.properties");
        prop.load(fp);
    }

    public static void initialization() throws InterruptedException {
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(prop.getProperty("URL"));
            Thread.sleep(5000); // Adjust wait time as needed
        }
    }
}
