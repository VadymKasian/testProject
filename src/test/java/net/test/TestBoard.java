package net.test;

import com.test.base.BaseTest;
import com.test.pages.SecondLoginPage;
import com.test.pages.LoginPage;
import com.test.pages.MainPage;
import com.test.pages.MainPageAfterLogin;
import com.test.util.Random;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBoard extends BaseTest {

    private static final String randomBoardName = Random.genString(8);

    @BeforeMethod
    public void logIn(){
        MainPage.getInstance().goToLoginPage();

        LoginPage.getInstance().inputEmail("zhhrkrislhjgiqhjoi@awdrt.net");
        LoginPage.getInstance().clickLogInButton();

        SecondLoginPage.getInstance().clickContinueButton();

        SecondLoginPage.getInstance().inputPassword("qwertyasd1");
        SecondLoginPage.getInstance().clickLogInButton();

        MainPageAfterLogin.getInstance().waitInSeconds(15);
    }
    @Test
    public void testBoardCreate(){

        MainPageAfterLogin.getInstance().clickCreateNewBoard();

        MainPageAfterLogin.getInstance().inputBoardName(randomBoardName);
        MainPageAfterLogin.getInstance().clickSubmitCreateNewBoard();

        MainPageAfterLogin.getInstance().inputTextInListTitle("List Title");
        MainPageAfterLogin.getInstance().clickAddListButton();

        MainPageAfterLogin.getInstance().clickHomeButton();

        Assert.assertEquals(MainPageAfterLogin.getInstance().getCreatedBoardName(), randomBoardName);
    }
}
