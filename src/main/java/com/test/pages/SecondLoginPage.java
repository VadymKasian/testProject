package com.test.pages;

import com.test.base.BasePage;
import com.test.locators.ID;
import com.test.locators.Locator;

public class SecondLoginPage extends BasePage {
    private static SecondLoginPage secondLoginPage;

    private Locator continueButton = new ID("login-submit");
    private Locator passwordInput = new ID("password");
    private Locator logInButton = new ID("login-submit");
    private Locator loginError = new ID("login-error");

    public static SecondLoginPage getInstance() {
        if (secondLoginPage == null) {
            return new SecondLoginPage();
        }
        return secondLoginPage;
    }

    private SecondLoginPage() {
    }

    public String getTitle() {
        return getPageTitle("Page title");
    }

    public void clickContinueButton() {
        waitForElementToBeClickable(continueButton);
        click("Clicking Continue button", continueButton);
    }

    public void inputPassword(String password) {
        waitForElementToBeClickable(passwordInput);
        type("Typing password: " + password, password, passwordInput);
    }

    public void clickLogInButton() {
        waitForElementToBeClickable(logInButton);
        click("Clicking login button", logInButton);
    }

    public String getErrorMessage() {
        waitForElementVisibility(loginError);
        return getElement(loginError).getText();
    }
}
