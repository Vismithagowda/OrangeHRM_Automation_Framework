package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyLogout() {

        DashboardPage dashboardPage = new DashboardPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginAsAdmin();
        dashboardPage.clickProfileMenu();
        dashboardPage.clickLogout();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
}
