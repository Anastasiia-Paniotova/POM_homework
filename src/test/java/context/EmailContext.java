package context;

import page.EmailPage;

import static test.BaseTest.driver;

public class EmailContext {
    public static EmailPage emailPage = new EmailPage(driver);

    public static void switchWindow(){
        emailPage.switchTab();
        driver.switchTo().frame("mail widget");
    }
    /**
     * navigate to the Message List Page upon clicking 'Вхідні'
     */
    public static void navigateMessageListLink(){
        emailPage.clickMessageListLink();
        emailPage.switchTab();
    }

    /**
     * send letter
     */
    public static void sendLetter(String recipient,String subject){
        emailPage.clickSendLetter();
        emailPage.inputRecipient(recipient);
        emailPage.inputSubject(subject);
        emailPage.clickSendButton();
    }

    /**
     * check confirm message
     */
    public static Boolean checkConfirmMessage(){
        return emailPage.isDisplayedConfirmMessage();
    }



}
