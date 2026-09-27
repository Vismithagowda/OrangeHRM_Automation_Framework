package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeavePage;

public class LeaveTest extends BaseTest {

    @Test
    public void verifyNoLeaveBalanceMessage() {
        LeavePage leavePage = new LeavePage(driver);
        loginAsAdmin();
        leavePage.clickLeave();
        Assert.assertTrue(
                leavePage.isLeavePageDisplayed(),
                "Leave page is not displayed");
        leavePage.clickApply();
        Assert.assertTrue(
                leavePage.isNoLeaveBalanceMessageDisplayed(),
                "No Leave Types with Leave Balance message is not displayed");
    }
}