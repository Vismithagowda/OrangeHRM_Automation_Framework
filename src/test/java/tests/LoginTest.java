package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {

        ExcelUtils.setExcelFile(
                "src/test/resources/LoginData.xlsx",
                "Sheet1"
        );
        String username = ExcelUtils.getCellData(1, 0);
        String password = ExcelUtils.getCellData(1, 1);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard is not displayed after login"
        );
    }

    @Test
    public void verifyInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "wrongPassword");
        Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                "Login error message is not displayed"
        );
    }


}
