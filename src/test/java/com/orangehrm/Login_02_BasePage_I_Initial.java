package com.orangehrm;

import core.BasePage;
import javaSDET.Topic_01_Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_02_BasePage_I_Initial {
    private WebDriver driver;
    private BasePage basePage;
    private String appUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        basePage = new BasePage();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    @Test
    public void Login_01_Empty(){
        basePage.openPageUrl(driver,appUrl);

        basePage.sendkeyToElement(driver,"//input[@name='username']","");
        basePage.sendkeyToElement(driver,"//input[@name='password']","");
        basePage.clickToElement(driver,"//button[contains(@class,'orangehrm-login-button')]");

        Assert.assertEquals(basePage.getElementText(driver,"//input[@name='username']/parent::div/following-sibling::span"), "Required");
        Assert.assertEquals(basePage.getElementText(driver,"//input[@name='password']/parent::div/following-sibling::span"),"Required");
    }

    @Test
    public void Login_02_InvalidUserName(){
        basePage.openPageUrl(driver,appUrl);

        basePage.sendkeyToElement(driver,"//input[@name='username']","ttt@gmail.com");
        basePage.sendkeyToElement(driver,"//input[@name='password']","admin123");
        basePage.clickToElement(driver,"//button[contains(@class,'orangehrm-login-button')]");

        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='orangehrm-login-error']//p[contains(@class,'content-text')]"), "Invalid credentials");

    }

    @Test
    public void Login_03_InvalidPassword(){
        basePage.openPageUrl(driver,appUrl);

        basePage.sendkeyToElement(driver,"//input[@name='username']","Admin");
        basePage.sendkeyToElement(driver,"//input[@name='password']","admin123@@");
        basePage.clickToElement(driver,"//button[contains(@class,'orangehrm-login-button')]");

        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='orangehrm-login-error']//p[contains(@class,'content-text')]"), "Invalid credentials");
    }

    @Test
    public void Login_04_ValidAccount(){
        basePage.openPageUrl(driver,appUrl);

        basePage.sendkeyToElement(driver,"//input[@name='username']","Admin");
        basePage.sendkeyToElement(driver,"//input[@name='password']","admin123");
        basePage.clickToElement(driver,"//button[contains(@class,'orangehrm-login-button')]");

        Assert.assertTrue(isAllLoadingSpinnerInvisible());
        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='oxd-topbar-header-title']//h6"),"Dashboard");

    }

    public boolean isAllLoadingSpinnerInvisible(){
        return basePage.waitListElementInvisible(driver,"//div[@class='oxd-loading-spinner']");
     }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
