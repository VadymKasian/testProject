package com.test.pages;

import com.test.base.BasePage;
import com.test.locators.ClassName;
import com.test.locators.Locator;
import com.test.locators.XPath;

public class MainPageAfterLogin extends BasePage {
    public static MainPageAfterLogin mainPageAfterLogin;

    public Locator newBoardButton = new XPath("//div[@class='board-tile mod-add']");
    public Locator boardNameInput = new ClassName("subtle-input");
    public Locator boardCreateButton = new XPath("//button[@class='button primary']");
    public Locator listTitleInput = new ClassName("list-name-input");
    public Locator addListButton = new XPath("//input[@class='primary mod-list-add-button js-save-edit']");
    public Locator createdBoardName = new XPath("//div[@class='board-tile-details is-badged']/div/div");
    public Locator homeButton = new XPath("//div[@id='header']/div/a");

    public static MainPageAfterLogin getInstance() {
        if (mainPageAfterLogin == null) {
            return new MainPageAfterLogin();
        }
        return mainPageAfterLogin;
    }

    public MainPageAfterLogin waitInSeconds(int time) {
        wait(time);
        return this;
    }

    public String getTitle() {
        return getPageTitle("Page title");
    }

    public void clickCreateNewBoard() {
        click("Creating new board", newBoardButton);
    }

    public void inputBoardName(String text) {
        waitForElementToBeClickable(boardNameInput);
        type("Entering board name", text, boardNameInput);
    }

    public void clickSubmitCreateNewBoard() {
        waitForElementToBeClickable(boardCreateButton);
        click("Submit creating new board", boardCreateButton);
    }

    public void inputTextInListTitle(String text){
        waitForElementToBeClickable(listTitleInput);
        type("Entering text in textArea", text, listTitleInput);
    }

    public void clickAddListButton() {
        waitForElementToBeClickable(addListButton);
        click("Clicking Add list button", addListButton);
    }

    public String getCreatedBoardName(){
        return getElement(createdBoardName).getText();
    }

    public void clickHomeButton() {
        click("Clicking Add list button", homeButton);
        click("Clicking Add list button", homeButton);
    }
}
