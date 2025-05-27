package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class Topic_06 {
    // se co ca ham non-abstract va abstract
    // khong cho phep khoi tao
    // chi cho ke thua

    // OOP: Abstraction
    // Neu class A ke thua class B -> goi la extend

    // lay du lieu ra (KHAC void)
    public String getFullName(){
        WebDriver driver = new FirefoxDriver();
        driver.get("");
        driver.findElement(By.cssSelector("")).getText();
        return null;
    }

    // action -> co (void)
    public void setFullname(){

    }

}
