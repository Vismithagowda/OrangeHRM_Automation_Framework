package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;

public class EmployeePage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public EmployeePage(WebDriver driver){
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    private final By pimMenu = By.xpath("//span[text()='PIM']");

    public void clickPIM(){
        waitUtils.waitForElementClickable(pimMenu).click();
    }

    private final By addEmployeeButton = By.xpath("//button[text()=' Add ']");

    public void clickAddEmployee(){
        waitUtils.waitForElementClickable(addEmployeeButton).click();
    }

    private final By firstName = By.xpath("//input[@name='firstName']");

    public void enterFirstName(String name){
        waitUtils.waitForElementVisible(firstName).sendKeys(name);
    }

    private final By middleName = By.xpath("//input[@name='middleName']");

    public void enterMiddleName(String name){
        waitUtils.waitForElementVisible(middleName).sendKeys(name);
    }

    private final By lastName = By.xpath("//input[@name='lastName']");

    public void enterLastName(String name){
        waitUtils.waitForElementVisible(lastName).sendKeys(name);
    }

    private final By saveButton = By.xpath("//button[text()=' Save ']");

    public void clickSave(){
        waitUtils.waitForLoaderToDisappear();
        waitUtils.waitForElementClickable(saveButton).click();
    }

    private final By personDetails = By.xpath("//a[text()='Personal Details']");

    public boolean isEmployeeProfileDisplayed(){
        return waitUtils.waitForElementVisible(personDetails).isDisplayed();
    }

    private final By searchExpandButton = By.xpath("//i[@class='oxd-icon bi-caret-down-fill']");

    public void expandSearchSection(){
        waitUtils.waitForElementClickable(searchExpandButton).click();
    }

    private final By employeeNameSearch = By.xpath("(//div[@class='oxd-autocomplete-wrapper']//input)[1]");

    public void enterEmployeeName (String name){
        waitUtils.waitForElementClickable(employeeNameSearch).click();
    }

    private final By employeeIDSearch = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");

    public void enterEmployeeID (String ID){
        waitUtils.waitForElementVisible(employeeIDSearch).sendKeys(ID);
    }

    private By searchButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

    public void clickSearch (){
        waitUtils.waitForElementClickable(searchButton).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");
    }

    public boolean isEmployeeDisplayed (String employeeID){
        By result = By.xpath(
                "//div[@role='row'][.//div[@role='cell'][normalize-space()='"
                        + employeeID + "']]");
        return waitUtils.waitForElementVisible(result).isDisplayed();
    }

    public final By employeeID = By.xpath("//label[normalize-space()='Employee Id']/following::input[1]");

    public String getEmployeeID(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(driver -> {
            String id = driver.findElement(employeeID).getDomProperty("value");

            if (id != null && !id.trim().isEmpty()) {
                return id;
            }
            return null;
        });
    }

    public void deleteEmployee(String employeeID){
        By deleteButton = By.xpath(
                "//div[@role='row'][.//div[@role='cell'][normalize-space()='"
                        + employeeID +
                        "']]//button[.//i[contains(@class,'bi-trash')]]"
        );

        waitUtils.waitForElementClickable(deleteButton).click();
    }

    private final By confirmDeleteButton = By.xpath("//button[normalize-space()='Yes, Delete']");

    public void confirmDelete(){
        waitUtils.waitForElementClickable(confirmDeleteButton).click();
    }

    private final By deleteSuccessMessage =By.xpath("//div[contains(@class,'oxd-toast-content')]//p[text()='Successfully Deleted']");

    public boolean isDeleteSuccessMessageDisplayed() {
        By successMessage = By.xpath("//p[contains(@class,'oxd-text--toast-message') and normalize-space()='Successfully Deleted']");

        try {
            waitUtils.waitForElementVisible(successMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
