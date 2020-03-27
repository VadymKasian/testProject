package net.test;

import com.test.base.BaseTest;
import com.test.pages.SecondLoginPage;
import com.test.pages.LoginPage;
import com.test.pages.MainPage;
import com.test.pages.MainPageAfterLogin;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //zhhrkrislhjgiqhjoi@awdrt.net
    //qwertyasd1
    @BeforeMethod
    public void switchToLoginPage() {
        MainPage.getInstance().goToLoginPage();
    }

    @Test
    public void testWrongLogin() {
        LoginPage.getInstance().inputEmail("obtbvdjxufgtx@dsf");
        LoginPage.getInstance().inputPassword("qwertyasd1");
        LoginPage.getInstance().clickLogInButton();

        //check wrong email format
        Assert.assertEquals("There isn't an account for this email", LoginPage.getInstance().getErrorText());
    }

    @Test
    public void testWrongPassword() {
        LoginPage.getInstance().inputEmail("zhhrkrislhjgiqhjoi@awdrt.net");
        LoginPage.getInstance().clickLogInButton();

        //check page switched to second login page

        SecondLoginPage.getInstance().clickContinueButton();

        SecondLoginPage.getInstance().inputPassword("asd");
        SecondLoginPage.getInstance().clickLogInButton();

        //check wrong password error message
        Assert.assertEquals(SecondLoginPage.getInstance().getErrorMessage(), "Incorrect email address and / or password.\n" + "Do you need help logging in?");
    }

    @Test
    public void testSuccessfulLogin(){
        LoginPage.getInstance().inputEmail("zhhrkrislhjgiqhjoi@awdrt.net");
        LoginPage.getInstance().clickLogInButton();

        SecondLoginPage.getInstance().clickContinueButton();

        SecondLoginPage.getInstance().inputPassword("qwertyasd1");
        SecondLoginPage.getInstance().clickLogInButton();

    }
}