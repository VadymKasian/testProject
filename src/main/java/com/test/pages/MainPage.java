package com.test.pages;

import com.test.base.BasePage;
import com.test.locators.ClassName;
import com.test.locators.Locator;
import com.test.locators.XPath;

public class MainPage extends BasePage {
    private static MainPage mainPage;
    private Locator logInButton = new XPath("//a[@class='btn btn-sm btn-link text-white']");

    public static MainPage getInstance() {
        if (mainPage == null) {
            return new MainPage();
        }
        return mainPage;
    }

    private MainPage() {
    }

    public void goToLoginPage() {
        waitForElementToBeClickable(logInButton);
        click("Clicking login button", logInButton);
    }
}
