package context;
import page.MainPage;

import static test.BaseTest.driver;

public class MainPageContext {
    public static MainPage mainPage = new MainPage(driver);

    /**
     * full login and check the text in the fields
     */
    public static void login(String login, String password){
            mainPage.inputLogin(login);
            mainPage.inputPassword(password);
            mainPage.submitLogin();
        }
    /**
     * get text upon entering valid login/password
     * verification that user's email is displayed
     */
    public static String getTextValidEmail() {
        return mainPage.getTextUserEmail();
    }

    /**
     * get error message upon failed login
     */
    public static String getTextInvalidEmail() {
        return mainPage.getTextErrorMessage();
    }


}

