package by.epam.machuga.saucedemo.page;

import by.epam.machuga.saucedemo.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver = DriverManager.getWebDriver();
    private Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    protected void waitForElementVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitForElementClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
