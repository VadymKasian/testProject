package com.test.pages;

import com.test.base.BasePage;
import com.test.locators.ID;
import com.test.locators.Locator;

public class LoginPage extends BasePage {
    private static LoginPage loginPage;
    private Locator loginInput = new ID("user");
    private Locator passwordInput = new ID("password");
    private Locator logInButton = new ID("login");
    private Locator errorText = new ID("error");

    public static LoginPage getInstance() {
        if (loginPage == null) {
            return new LoginPage();
        }
        return loginPage;
    }

    private LoginPage() {
    }

    public void inputEmail(String email) {
        waitForElementToBeClickable(loginInput);
        type("Email input info: " + email, email, loginInput);
    }

    public void inputPassword(String password) {
        waitForElementToBeClickable(passwordInput);
        type("Email input info: " + password, password, passwordInput);
    }

    public void clickLogInButton() {
        waitForElementToBeClickable(logInButton);
        click("Clicking login button", logInButton);
    }

    public String getErrorText() {
        waitForElementVisibility(errorText);
        return getElement(errorText).getText();
    }
}
