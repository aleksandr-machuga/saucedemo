package by.epam.machuga.saucedemo.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private static void setWebDriver() {
        if (webDriver.get() == null) {
            WebDriverManager.chromedriver().setup();
            webDriver.set(new ChromeDriver());
            webDriver.get().manage().window().maximize();
            webDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
            webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    public static WebDriver getWebDriver() {
        setWebDriver();
        return webDriver.get();
    }

    public static void closeDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
