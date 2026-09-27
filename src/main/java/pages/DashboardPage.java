package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class DashboardPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By dashboardingHeading = By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module') and normalize-space()='Dashboard']");
    private By profileMenu = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private By logoutButton = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isDashboardDisplayed(){
        return waitUtils.waitForElementVisible(dashboardingHeading).isDisplayed();
    }

    public void clickProfileMenu(){
        waitUtils.waitForElementClickable(profileMenu).click();
    }
    public void clickLogout(){
        waitUtils.waitForElementClickable(logoutButton).click();
    }
}
