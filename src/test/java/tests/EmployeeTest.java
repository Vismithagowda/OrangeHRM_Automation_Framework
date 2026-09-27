package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeePage;

public class EmployeeTest extends BaseTest {

    private String employeeID;

    @Test(priority = 0)
    public void verifyAddEmployee() {

        EmployeePage employeePage = new EmployeePage(driver);

        loginAsAdmin();

        employeePage.clickPIM();
        employeePage.clickAddEmployee();

        employeePage.enterFirstName("meddyAn1");
        employeePage.enterMiddleName("A");
        employeePage.enterLastName("Adam");

        employeePage.clickSave();

        Assert.assertTrue(
                employeePage.isEmployeeProfileDisplayed(),
                "Employee profile is not displayed"
        );

        employeeID = employeePage.getEmployeeID();

        System.out.println("Generated Employee ID: " + employeeID);
    }

    @Test(priority = 1, dependsOnMethods = "verifyAddEmployee")
    public void employeeSearch() {

        EmployeePage employeePage = new EmployeePage(driver);

        loginAsAdmin();

        employeePage.clickPIM();

        System.out.println("Searching Employee ID: " + employeeID);

        employeePage.enterEmployeeID(employeeID);
        employeePage.clickSearch();

        Assert.assertTrue(
                employeePage.isEmployeeDisplayed(employeeID),
                "Employee is not displayed"
        );
    }

    @Test(priority = 2, dependsOnMethods = "employeeSearch")
    public void deleteEmployee() {

        EmployeePage employeePage = new EmployeePage(driver);

        loginAsAdmin();

        employeePage.clickPIM();

        employeePage.enterEmployeeID(employeeID);
        employeePage.clickSearch();

        employeePage.deleteEmployee(employeeID);
        employeePage.confirmDelete();

        Assert.assertTrue(
                employeePage.isDeleteSuccessMessageDisplayed(),
                "Employee was not deleted successfully"
        );
    }
}