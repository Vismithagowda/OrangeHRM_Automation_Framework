package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    // Locators
    private final By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By loginError = By.xpath("//p[contains(@class,'oxd-alert-content-text') and normalize-space()='Invalid credentials']");
    private By loginPageHeading = By.xpath("//h5[text()='Login']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    // Actions
    public void enterUsername(String username) {
        waitUtils.waitForElementVisible(this.username).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUtils.waitForElementVisible(this.password).sendKeys(password);
    }

    public void clickLogin() {
       waitUtils.waitForElementClickable(loginButton).click();
    }

    public boolean isLoginErrorDisplayed(){
       return waitUtils.waitForElementVisible(loginError).isDisplayed();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isLoginPageDisplayed(){
        return waitUtils.waitForElementVisible(loginPageHeading).isDisplayed();
    }
}
