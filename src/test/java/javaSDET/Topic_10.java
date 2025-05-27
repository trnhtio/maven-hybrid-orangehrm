package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_10 extends Topic_09 {
    //bien toan cu (class)
    String address;

    public Topic_10(String name, String address) { //bien pham vi cuc bo (ham)
        super(name); //goi qua constructor cua class cha (bat buoc dung dau tien)
        this.address = address; // dung this de lay bien pham vi toan cuc
    }
    //khi chay da luong va goi den synchronized
    // phai chay theo thu tu
    public synchronized WebDriver getDriver(){
        WebDriver driver = new FirefoxDriver();
        if (driver instanceof FirefoxDriver) {
            // action
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
