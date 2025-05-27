package UI.orangehrm.user;

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

// import cac class/interface tu package khac

import javaSDET.Topic_01_Keywords;

import java.time.Duration;

public class Login_01_DRY {
    private WebDriver driver;
    private Topic_01_Keywords topic01;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    @Test
    public void Login_01_Empty(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
         driver.findElement(By.cssSelector("input[name='username']")).sendKeys("");
         driver.findElement(By.cssSelector("input[name='password']")).sendKeys("");

         driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
         Assert.assertEquals(driver.findElement(By.xpath("//input[@name='username']/parent::div/following-sibling::span")).getText(),"Required");
         Assert.assertEquals(driver.findElement(By.xpath("//input[@name='password']/parent::div/following-sibling::span")).getText(),"Required");
    }

    @Test
    public void Login_02_InvalidUserName(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("ttt@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.orangehrm-login-error p.oxd-alert-content-text")).getText(),"Invalid credentials");

    }

    @Test
    public void Login_03_InvalidPassword(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123@@");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.orangehrm-login-error p.oxd-alert-content-text")).getText(),"Invalid credentials");
    }

    @Test
    public void Login_04_ValidAccount(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.oxd-topbar-header-title h6")).getText(),"Dashboard");

    }

    public boolean isAllLoadingSpinnerInvisible(){
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.oxd-loading-spinner"))));
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
