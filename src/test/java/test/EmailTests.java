package test;

import context.EmailContext;
import context.MainPageContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailTests extends BaseTest{
    @BeforeMethod
    public static void setUpLogin(){
        driver.switchTo().frame("mail widget");
        String login = "valid email";
        String password = "valid password";

        MainPageContext.login(login,password);
        EmailContext.switchWindow();
        EmailContext.navigateMessageListLink();
    }

    @Test
    public void sendTheLetterAndVerify() {
        String recipient = "to@ukr.net";
        String subject = "test email";

        EmailContext.sendLetter(recipient,subject);
        Assert.assertTrue(EmailContext.checkConfirmMessage());

}}
