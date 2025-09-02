package pageObjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    //Hàm khởi tạo (constructor method)
    // map driver từ Test class qua bên Page Object class
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }
    // Sẽ được chạy đầu tiên khi class đợc gọi tới
    // Nếu không viết hàm khởi tạo thì trình bien dịch sẽ tạo ra cho class này 1 hàm khởi tạo rỗng
    // Nếu viết thì nó sẽ dùng hàm do mình define
    // cùng tên với tên class chứa nó
    // KHông có giá trị trả về
    // Có 1 hoặc nhiều tham số/ có 1 hoặc nhiều hàm khi khởi tạo
    // thể hiển cho tính chất đa hình trong OOP

    public void enterToUserNameTextbox(String username) {
        // Rap action + UI
        waitElementVisible(driver,LoginPageUI.USER_NAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, username);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickLoginButton() {
        waitElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
