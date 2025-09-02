package javaOOP;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorMethod {
    public static void main (String[] args) {
        FirefoxDriver ffDriver;

        ffDriver = new FirefoxDriver();

        FirefoxOptions ffOption = new FirefoxOptions();
        ffOption.addArguments("--headless");
        ffDriver = new FirefoxDriver(ffOption);

        WebDriverWait explicitWait;

        explicitWait = new WebDriverWait(ffDriver, Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(ffDriver, Duration.ofSeconds(10), Duration.ofSeconds(1));
    }

    public void fistMethod(){
        String name;
        int number;
    }

    public void secondMethod(String name, int number){

        // Phạm vi trong block-code
        if (name.equals("Automation")) {
            int second = 15;
            System.out.println(second);
    }
}
}
