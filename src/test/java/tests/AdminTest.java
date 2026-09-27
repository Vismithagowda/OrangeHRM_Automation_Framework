package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;

public class AdminTest extends BaseTest {

    @Test
    public void verifySearchByUserRole() {

        AdminPage adminPage = new AdminPage(driver);

        loginAsAdmin();

        adminPage.clickAdmin();
        adminPage.clickUserManagement();

        adminPage.clickUserRoleDropdown();
        adminPage.selectAdminRole();
        adminPage.clickSearch();

        Assert.assertTrue(
                adminPage.isAdminRoleDisplayed(),
                "Admin role was not displayed in search results"
        );
    }

    @Test
    public void verifyResetOption() {

        AdminPage adminPage = new AdminPage(driver);

        loginAsAdmin();

        adminPage.clickAdmin();
        adminPage.clickUserManagement();

        adminPage.clickUserRoleDropdown();
        adminPage.selectAdminRole();
        adminPage.clickSearch();

        adminPage.clickReset();

        Assert.assertTrue(
                adminPage.isUserRoleReset(),
                "User Role was not reset"
        );
    }

    @Test
    public void verifyAddUser() {

        AdminPage adminPage = new AdminPage(driver);

        loginAsAdmin();

        adminPage.clickAdmin();
        adminPage.clickUserManagement();
        adminPage.clickAdd();

        adminPage.clickAddUserRoleDropdown();
        adminPage.selectESSRole();

        adminPage.enterEmployeeName("Timothy");
        adminPage.selectEmployee("Timothy Lewis Amiano");

        adminPage.clickStatusDropdown();
        adminPage.selectEnabledStatus();

        String username = "Timothy" + System.currentTimeMillis();

        adminPage.enterUsername(username);
        adminPage.enterPassword("Admin@123");
        adminPage.enterConfirmPassword("Admin@123");
        adminPage.clickSave();
        Assert.assertTrue(adminPage.isUserAddedSuccessfully(),
                "User was not added successfully");

    }
}