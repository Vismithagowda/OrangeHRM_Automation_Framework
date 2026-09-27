package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;

public class AdminPage {
    private WebDriver driver;
    private WaitUtils waitUtils;
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    private By adminMenu = By.xpath("//span[text()='Admin']");

    public void clickAdmin(){
        waitUtils.waitForElementClickable(adminMenu).click();
    }

    private By userManagement = By.xpath("//span[normalize-space()='User Management']");

    public void clickUserManagement() {
        waitUtils.waitForElementClickable(userManagement).click();
    }

    private By users = By.xpath("//a[text()='Users']");

    public void clickUsers() {
        waitUtils.waitForElementClickable(users).click();
    }

    private By usernameInput = By.xpath("(//input[contains(@class,'oxd-input')])[2]");

    public void enterUsername(String username) {
        waitUtils.waitForElementVisible(usernameInput).sendKeys(username);
    }

    private By searchButton = By.xpath("//button[normalize-space()='Search']");

    public void clickSearch() {
        waitUtils.waitForElementClickable(searchButton).click();
    }

    private By adminUserResult =
            By.xpath("//div[@role='row']//div[normalize-space()='Admin']");

    public boolean isAdminUserDisplayed() {
        return waitUtils.waitForElementVisible(adminUserResult).isDisplayed();
    }

    private By userRoleDropdown =
            By.xpath("(//div[contains(@class,'oxd-select-text-input')])[1]");

    public void clickUserRoleDropdown() {
        waitUtils.waitForElementClickable(userRoleDropdown).click();
    }

    private By adminRoleOption =
            By.xpath("//div[@role='option']//span[normalize-space()='Admin']");

    public void selectAdminRole() {
        waitUtils.waitForElementClickable(adminRoleOption).click();
    }

    private By adminRoleResult =
            By.xpath("//div[@role='row']//div[normalize-space()='Admin']");

    public boolean isAdminRoleDisplayed() {
        return waitUtils.waitForElementVisible(adminRoleResult).isDisplayed();
    }

    private By resetButton =
            By.xpath("//button[normalize-space()='Reset']");

    public void clickReset() {
        waitUtils.waitForElementClickable(resetButton).click();
    }

    private By userRoleSelected =
            By.xpath("(//div[contains(@class,'oxd-select-text-input')])[1]");

    public boolean isUserRoleReset() {
        return waitUtils.waitForElementVisible(userRoleSelected)
                .getText()
                .equals("-- Select --");
    }

    private By addButton =
            By.xpath("//button[normalize-space()='Add']");

    public void clickAdd() {
        waitUtils.waitForElementClickable(addButton).click();
    }

    private By addUserRoleDropdown= By.xpath("//label[normalize-space()='User Role']/following::div[contains(@class,'oxd-select-text')][1]");

    public void clickAddUserRoleDropdown(){
        waitUtils.waitForElementClickable(addUserRoleDropdown).click();
    }

    private By essRoleOption = By.xpath("//div[contains(@class,'oxd-select-option')]//span[normalize-space()='ESS']");

    public void selectESSRole(){
        waitUtils.waitForElementClickable(essRoleOption).click();
    }

    private By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");

    public void enterEmployeeName(String employeeName) {
        WebElement employeeInput = waitUtils.waitForElementVisible(employeeNameInput);
        employeeInput.sendKeys(employeeName);
    }

    private By statusDropdown = By.xpath("//label[normalize-space()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]");

    public void clickStatusDropdown(){
        waitUtils.waitForElementClickable(statusDropdown).click();
    }

    private By enabledOption = By.xpath("//div[contains(@class,'oxd-select-option')]//span[normalize-space()='Enabled']");

    public void selectEnabledStatus(){
        waitUtils.waitForElementClickable(enabledOption).click();
    }

    private By newUsernameInput =
            By.xpath("//label[normalize-space()='Username']/following::input[1]");

    public void enterNewUsername(String username){
        waitUtils.waitForElementClickable(newUsernameInput).sendKeys(username);
    }

    private By passwordInput =
            By.xpath("(//input[@type='password'])[1]");

    public void enterPassword(String password){
        waitUtils.waitForElementVisible(passwordInput).sendKeys(password);
    }

    private By confirmPasswordInput =
            By.xpath("(//input[@type='password'])[2]");

    public void enterConfirmPassword(String password){
        waitUtils.waitForElementVisible(confirmPasswordInput).sendKeys(password);
    }

    private By saveButton =
            By.xpath("//button[normalize-space()='Save']");

    public void clickSave(){
        waitUtils.waitForElementClickable(saveButton).click();
    }

    private By successMessage =
            By.xpath("//div[contains(@class,'oxd-toast-content')]");

    public boolean isUserAddedSuccessfully() {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(successMessage))
                    .isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    private By employeeSuggestion =
            By.xpath("YOUR EMPLOYEE SUGGESTION XPATH");

    public void selectEmployee(String employeeName) {

        By employeeSuggestion = By.xpath("//div[contains(@class,'oxd-autocomplete-option')]//span[normalize-space()='"
                        + employeeName + "']"
        );
        waitUtils.waitForElementClickable(employeeSuggestion).click();
    }
}
