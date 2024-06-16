package com.rx.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rx.qa.basepage.testBase;
import com.rx.qa.pages.MonitorSummary;
import com.rx.qa.pages.loginPage;

public class loginPageTest extends testBase {

    loginPage lg;
    MonitorSummary monitorsummary;

    public loginPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initialization(); // Initialize WebDriver
        lg = new loginPage(driver); // Pass the driver instance to loginPage
    }

    @Test(priority = 1)
    public void loginTest() throws IOException, InterruptedException {
        monitorsummary = lg.login(prop.getProperty("username"), prop.getProperty("password"));
        // Add assertions or further verifications here
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
