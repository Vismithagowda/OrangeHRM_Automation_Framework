package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LeavePage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    private final By leaveMenu =
            By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']");

    public void clickLeave() {
        waitUtils.waitForElementClickable(leaveMenu).click();
    }

    private final By leavePageHeading =
            By.xpath("//h6[contains(normalize-space(),'Leave')]");

    public boolean isLeavePageDisplayed() {
        return waitUtils.waitForElementVisible(leavePageHeading).isDisplayed();
    }

    private final By applyButton = By.xpath("//a[text()='Apply']");

    public void clickApply() {
        waitUtils.waitForElementClickable(applyButton).click();
    }

    private final By leaveTypeDropdown =
            By.xpath("//label[text()='Leave Type']/following::div[contains(@class,'oxd-select-text')][1]");

    public void clickLeaveType() {
        waitUtils.waitForElementClickableWithoutLoader(leaveTypeDropdown).click();
    }

    private final By BereavedLeaveOption =
            By.xpath("//div[@role='option'][.//*[normalize-space()='CAN - Bereavement']]");

    public void selectBereavedLeave() {
        waitUtils.waitForElementClickable(BereavedLeaveOption).click();
    }

    private final By fromDate =
            By.xpath("//label[text()='From Date']/following::input[@placeholder='yyyy-dd-mm'][1]");

    public void enterFromDate(String date) {
        waitUtils.waitForElementVisible(fromDate).click();
        waitUtils.waitForElementVisible(fromDate).sendKeys(date);
    }

    private final By toDate =
            By.xpath("//label[text()='To Date']/following::input[@placeholder='yyyy-dd-mm'][1]");

    public void enterToDate(String date) {
        waitUtils.waitForElementVisible(toDate).click();
        waitUtils.waitForElementVisible(toDate).sendKeys(date);
    }

    private final By partialDaysDropdown =
            By.xpath("//label[contains(normalize-space(),'Partial Days')]/following-sibling::div//div[contains(@class,'oxd-select-text')]");

    public void clickPartialDays() {
        waitUtils.waitForElementClickable(partialDaysDropdown).click();
    }

    private final By halfDayMorning =
            By.xpath("//div[@role='option']//span[text()='Half Day - Morning']");

    public void selectHalfDayMorning() {
        waitUtils.waitForElementClickable(halfDayMorning).click();
    }

    private final By comment =
            By.xpath("//textarea[contains(@class,'oxd-textarea--resize-vertical')]");

    public void enterComment(String text) {
        waitUtils.waitForElementVisible(comment).sendKeys(text);
    }

    private final By applyLeaveButton =
            By.xpath("//button[@type='submit' and contains(@class,'oxd-button--secondary')]");

    public void clickApplyLeave() {
        waitUtils.waitForElementClickable(applyLeaveButton).click();
        waitUtils.waitForLoaderToDisappear();
    }

    private final By noLeaveBalanceMessage =
            By.xpath("//*[normalize-space()='No Leave Types with Leave Balance']");

    public boolean isNoLeaveBalanceMessageDisplayed() {
        return waitUtils.waitForElementVisible(noLeaveBalanceMessage).isDisplayed();
    }
}