package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

// class ke thua class: extends
// Class ke thua interface: implements
public class Topic_01_Keywords extends Topic_06 implements Topic_02 {
    // chi co non-abstract method - khong duoc co abstract method
    // khoi tao binh thuong va cho phep ke thua


    //data type
    char c = 'A';
    byte bNumber = 10;
    short sNumber = 100;
    int iNumber = 1400;
    long lNumber = 123132;
    float fNumber = 15.99F;
    double dNumber = 19.42343D;
    boolean marialStatus = true;

    String fullName = null;

    // access modifier

    // variable
    private String studentName = "To Trinh";
    String studentAddress = "Quang Ngai province";
    protected int studentAge = 29;
    public double studentPoint = 9.5;

    //method
    // khong co kieu tra ve -> void
    private void TC_01(){
        WebDriver driver = new FirefoxDriver();

        Topic_01_Keywords topic = new Topic_01_Keywords();
       // Topic_06 topic06 = new Topic_06(): khong co phep new - chi co th ke thua

    }
    void TC_02(){

    }
    protected  void TC_03(){

    }
    public void TC_04(){

    }

    @Override
    public void clearStudent() {
        // Tu implement lai o day
    }
}
