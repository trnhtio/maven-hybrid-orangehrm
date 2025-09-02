package pageObjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DashboadPageUI;

public class DashboardPageObject extends BasePage {
    private WebDriver driver;

    public DashboardPageObject(WebDriver driver){
        this.driver = driver;

    }

    public void clickToPIMModule() {
        waitElementClickable(driver, DashboadPageUI.PIM_MODULE);
        clickToElement(driver,DashboadPageUI.PIM_MODULE);

    }
}
