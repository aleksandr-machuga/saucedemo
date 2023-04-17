package by.epam.machuga.saucedemo.page;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By title = By.className("app_logo");

    public String getTitleText() {
        waitForElementVisible(title);
        return driver.findElement(title).getText();
    }
}
