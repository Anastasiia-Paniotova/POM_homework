package test;

import context.MainPageContext;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class MainTests extends BaseTest {
    @Test
    public void loginEmail() {
        driver.switchTo().frame("mail widget");
        String login = "valid email"; //input valid email
        String password = "valid password"; //input valid password

        MainPageContext.login(login, password);
        assertThat(MainPageContext.getTextValidEmail(), containsString(login));
    }

    @Test
    public void loginByInvalidEmail() {
        driver.switchTo().frame("mail widget");

        String password = "validpassword";
        String invalidLogin = "invalid@ukr.net";
        String expectedMessage = "Неправильні дані";

        MainPageContext.login(invalidLogin, password);
        assertThat(MainPageContext.getTextInvalidEmail(), containsString(expectedMessage));
    }

    @Test
    public void loginByInvalidPassword(){
        driver.switchTo().frame("mail widget");
        String login = "valid email";
        String invalidPassword = "invalid";
        String expectedMessage = "Неправильні дані";

        MainPageContext.login(login,invalidPassword);
        assertThat(MainPageContext.getTextInvalidEmail(), containsString(expectedMessage));
    }





}
