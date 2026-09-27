package base;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        DriverFactory.initDriver();

        driver = DriverFactory.getDriver();

        driver.get(ConfigReader.getProperty("url"));

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@name='username']")
                ));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    public void loginAsAdmin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
    }
}