package by.epam.machuga.saucedemo;

import by.epam.machuga.saucedemo.driver.DriverManager;
import by.epam.machuga.saucedemo.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private static final String BASE_URL = "https://www.saucedemo.com/";
    protected LoginPage loginPage;
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        driver = DriverManager.getWebDriver();
    }

    @BeforeMethod
    public void openLoginPage() {
        driver.get(BASE_URL);
        loginPage = new LoginPage();
    }

    @AfterTest
    public void closeDriver() {
        DriverManager.closeDriver();
    }
}
