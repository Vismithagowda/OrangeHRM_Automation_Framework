package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForElementVisible(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public WebElement waitForElementClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public void waitForLoaderToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.className("oxd-form-loader")
        ));
    }

    public WebElement waitForElementClickableWithoutLoader(By locator) {
        return wait.until(driver -> {

            boolean loaderVisible = driver.findElements(By.className("oxd-form-loader"))
                    .stream()
                    .anyMatch(element -> {
                        try {
                            return element.isDisplayed();
                        } catch (Exception e) {
                            return false;
                        }
                    });

            if (loaderVisible) {
                return null;
            }

            WebElement element = driver.findElement(locator);

            if (element.isDisplayed() && element.isEnabled()) {
                return element;
            }

            return null;
        });
    }


}
