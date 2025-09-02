package com.orangehrm;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_03_Multiple_Browser extends BaseTest {
    private WebDriver driver;
    private BasePage basePage;
    private String appUrl;

    @Parameters({"appUrl", "browser"})
    @BeforeClass
    public void beforeClass(String appUrl, String browserName){
        this.appUrl = appUrl;
        basePage = BasePage.getInstance();
        driver = getBrowserDriver(appUrl, browserName);

    }
    @Test
    public void Login_01_Empty(){
        basePage.openPageUrl(driver, appUrl);

        basePage.sendkeyToElement(driver,"//input[@name='username']","");
        basePage.sendkeyToElement(driver,"//input[@name='password']","");
        basePage.clickToElement(driver,"//button[contains(@class,'orangehrm-login-button')]");

        Assert.assertEquals(basePage.getElementText(driver,"//input[@name='username']/parent::div/following-sibling::span"), "Required");
        Assert.assertEquals(basePage.getElementText(driver,"//input[@name='password']/parent::div/following-sibling::span"),"Required");
    }

    @Test
    public void Login_02_InvalidUserName(){
        basePage.openPageUrl(driver, appUrl);

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
