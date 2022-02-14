package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    /**
     * search login
     */
    @FindBy(name = "login")
    private WebElement loginField;

    /**
     * search password
     */
    @FindBy(name = "password")
    private WebElement passwordField;

    /**
     * search submit
     */
    @FindBy(className = "form__submit")
    private WebElement submitButton;

    /**
     * method input login string
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    /**
     * method input password string
     */
    public void inputPassword(String login) {
        passwordField.sendKeys(login);
    }

    /**
     * method submit login
     */
    public void submitLogin() {
        submitButton.click();
    }

    /**
     * search user email on mail panel
     */
    @FindBy(id = "id-user-email")
    private WebElement userEmail;

    /**
     * method get text from user email
     */
    public String getTextUserEmail() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id-user-email")));
        return userEmail.getText();

    }

    /**
     * error message upon failed login
     */
    @FindBy(xpath = "//*[@class='form__error form__error_wrong form__error_visible']")
    private WebElement errorMessage;


    /**
     * method get Error Message
     */
    public String getTextErrorMessage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='form__error form__error_wrong form__error_visible']")));
        return errorMessage.getText();
    }

}

