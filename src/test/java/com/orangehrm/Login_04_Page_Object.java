package com.orangehrm;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Login_04_Page_Object extends BaseTest {
    private WebDriver driver;

    @Parameters({"appUrl", "browser"})
    @BeforeClass
    public void beforeClass(String appUrl, String browserName){
        driver = getBrowserDriver(appUrl, browserName);
        loginPage = new LoginPageObject(driver);

        adminUsername = "Admin";
        adminPassword = "admin123";
        employeeFirstname = "Trinh";
        employeeLastname = "To";
    }
    @Test
    public void Employee_01_CreateNewEmployee() {
        // Action of Login
        loginPage.enterToUserNameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);

        loginPage.clickLoginButton();
        dashboardPage = new DashboardPageObject(driver);

        //Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));

        dashboardPage.clickToPIMModule();
        empployeeListPage = new EmployeeListPageObject(driver);
        //Assert.assertTrue(empployeeListPage.isLoadingSpinnerDisappear(driver));

        empployeeListPage.clickToAddEmployeeButton();
        addEmployeePage = new AddEmployeePageObject(driver);
        //Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        addEmployeePage.enterToFirstNameTextbox(employeeFirstname);
        addEmployeePage.enterToLastNameTextbox(employeeLastname);
        employeeID = addEmployeePage.getEmployeeID();

        addEmployeePage.isLoadingSpinnerDisappear(driver);
        addEmployeePage.clickToSaveButton();
        //Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        personalDetailPage = new PersonalDetailPageObject(driver);
        //personalDetailPage.isLoadingSpinnerDisappear(driver);
        //Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));

        personalDetailPage.sleepInSecond(10);

        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(),employeeFirstname);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(),employeeLastname);
        Assert.assertEquals(personalDetailPage.getEmployeeIDValue(), employeeID);

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject empployeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailPageObject personalDetailPage;
    private String employeeID, adminUsername, adminPassword, employeeFirstname, employeeLastname;

}
