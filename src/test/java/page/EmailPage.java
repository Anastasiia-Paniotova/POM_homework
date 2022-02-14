package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseTest;

import java.time.Duration;
import java.util.ArrayList;

public class EmailPage extends BaseTest {
    public WebDriver driver;
    private WebDriverWait wait;

    public EmailPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }


    /**
     * method switch tabs
     */
    public void switchTab(){
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));
    }

    /**
     * search 'Вхід' link
     */
    @FindBy(xpath = "//*[text()='Вхідні']")
    private WebElement messageListLink;

    public void clickMessageListLink(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Вхідні']"))).click();
    }

    /**
     * search 'Надіслати листа' button
     */
    @FindBy(xpath = "//*[@class='button primary compose']")
    private WebElement sendLetter;

    public void clickSendLetter(){
        sendLetter.click();
    }

    /**
     * search to Field Input
     */
    @FindBy(xpath = "//*[@name='toFieldInput']")
    private WebElement recipient;

    public void inputRecipient(String toRecipient){
        recipient.sendKeys(toRecipient);
    }

    /**
     * search Subject input
     */
    @FindBy(xpath = "//*[@name='subject']")
    private WebElement subject;

    public void inputSubject(String topic){
        subject.sendKeys(topic);
    }

    /**
     * search 'Надіслати' button
     */
    @FindBy(xpath = "//div[@class='controls']/button[@class='button primary send']")
    private WebElement sendButton;

    public void clickSendButton(){
        sendButton.click();
    }

    /**
     * search Confirmation message
     */
    @FindBy(xpath = "//*[@class='sendmsg__ads-ready']")
    private WebElement confirmMessage;

    public Boolean isDisplayedConfirmMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='sendmsg__ads-ready']")));
        return confirmMessage.isDisplayed();
    }

}
