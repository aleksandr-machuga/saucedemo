package by.epam.machuga.saucedemo;

import by.epam.machuga.saucedemo.page.HomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {
    private HomePage homePage = new HomePage();

    @Test
    public void loginFormWithEmptyCredentialsTest() {
        String expectedError = "Username is required";
        loginPage.setLogin("standard_user");
        loginPage.clearLogin();
        loginPage.clickLoginButton();
        String errorMessageText = loginPage.getErrorMessageText();
        Assertions.assertThat(errorMessageText)
                .as("Error message doesn't contain expected text")
                .contains(expectedError);
    }

    @Test
    public void loginFormWithEmptyPasswordTest() {
        String expectedError = "Password is required";
        loginPage.setLogin("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clearPassword();
        loginPage.clickLoginButton();
        String errorMessageText = loginPage.getErrorMessageText();
        Assertions.assertThat(errorMessageText)
                .as("Error message doesn't contain expected text")
                .contains(expectedError);
    }

    @Test
    public void loginFormWithValidCredentialsTest() {
        String expectedTitle = "Swag Labs";
        loginPage.setLogin("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        String titleText = homePage.getTitleText();
        Assertions.assertThat(titleText)
                .as("Title text doesn't contain expected text")
                .contains(expectedTitle);
    }
}
