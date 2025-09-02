package pageObjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddEmployeePageUI;

public class AddEmployeePageObject extends BasePage {
    private WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitListElementVisible(driver, AddEmployeePageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver,AddEmployeePageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitListElementVisible(driver, AddEmployeePageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver,AddEmployeePageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public String getEmployeeID() {
        waitListElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementDOMProperty(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public void clickToSaveButton() {
        waitElementClickable(driver,AddEmployeePageUI.SAVE_BUTTON);
        clickToElement(driver,AddEmployeePageUI.SAVE_BUTTON);
    }
}
