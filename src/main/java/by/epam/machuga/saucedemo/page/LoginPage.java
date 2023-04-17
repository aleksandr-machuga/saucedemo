package by.epam.machuga.saucedemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage extends BasePage {

    private By loginInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//h3[@data-test='error']");

    public void setLogin(String login) {
        waitForElementVisible(loginInput);
        driver.findElement(loginInput).sendKeys(login);
    }

    public void setPassword(String password) {
        waitForElementVisible(passwordInput);
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clearPassword() {
        driver.findElement(passwordInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void clearLogin() {
        driver.findElement(loginInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void clickLoginButton() {
        waitForElementClickable(loginButton);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessageText() {
        waitForElementVisible(errorMessage);
        return driver.findElement(errorMessage).getText();
    }
}
