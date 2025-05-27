package javaSDET;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Topic_08 {
    // non-static
    String address = "adressLocation";

    // pham vi cua static la share toan bo system su dung
    static String name = "To Trinh";

    // HẰNG SỐ
    static final String AGE = "29";





    WebDriver driver;
    @Test
    public void TC_01() throws InterruptedException {
        // doi tuong la tp
        Topic_08 tp = new Topic_08();
        tp.address = "1234567";

        //thuoc pham vi class
        Topic_08.name = "12345678";

       // Topic_08.AGE = "15"; -> hang so nen khong cho phep thay doi


        String osName = "Windows 11";
        String seperator = null;
        // condition statement
        // if-else
        if (osName.contains("Windows")) {
            seperator = "\\";
        }else {
            seperator = "/";
        }
        String browserName = "Chrome";
        // switch case
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser is not supported");

        }

        // loop statement

        int studentNumber = 10;
        //Classic for
        // for
        for (int i = 0; i < studentNumber; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < studentNumber; i++) {
            if (i==5){
                System.out.println(i);
            }
        }

        List<String> studentName = new ArrayList<String>();
        // For-each
        for (String std: studentName){
            System.out.println(std);
        }
        // while
        int x = 0;
        while(x < studentNumber){
            System.out.println(x);
            x++;
        }
        // do-while
        int z = 10;
        do {
            System.out.println(z);
            z++;
        } while (z < studentNumber);

        // neu nhu element khong duoc tim thay thi cung khong bi loi
        try {
            // happy case
            driver.findElement(By.cssSelector("")).isDisplayed();
        } catch (NoSuchElementException exception) {
            // edge case
            System.out.println(exception.getMessage());
        } finally {
            //close connection: DB/File/...
        }
        Thread.sleep(5000);
    }
}
