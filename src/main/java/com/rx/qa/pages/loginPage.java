package com.rx.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    WebDriver driver;

    @FindBy(css = "input[placeholder='Email']")
    public WebElement typUserName;

    @FindBy(css = "input[placeholder='Password']")
    public WebElement typPassword;

    @FindBy(css = "button[type='button']")
    public WebElement typSignInBtn;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MonitorSummary login(String username, String pwd) throws InterruptedException, IOException {
        typUserName.sendKeys(username);
        typPassword.sendKeys(pwd);
        typSignInBtn.click();
        Thread.sleep(3000); // Replace with appropriate wait

        return new MonitorSummary(); // Adjust return type as per your implementation
    }
}
