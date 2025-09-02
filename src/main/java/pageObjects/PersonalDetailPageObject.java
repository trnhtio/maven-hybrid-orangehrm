package pageObjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.PersonalDetailPageUI;

public class PersonalDetailPageObject extends BasePage {
    private WebDriver driver;

    public PersonalDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstNameTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX);
        return getElementDOMProperty(driver,PersonalDetailPageUI.FIRST_NAME_TEXTBOX,"value");
    }

    public String getLastNameTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX,"value");

    }
    public String getEmployeeIDValue() {
        waitElementVisible(driver,PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementDOMProperty(driver,PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX,"value");
    }
}
