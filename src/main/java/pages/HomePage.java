package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy (xpath = "//title)")
    String title;

    @FindBy(xpath = ".//input[@name='userName']")
    WebElement loginField;

    @FindBy(xpath = ".//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = ".//input[@name='login']")
    WebElement signInButton;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String login, String password) {
        waitClickable(signInButton);
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
    }

    public void signInButtonClick() {
        signInButton.click();
    }
}
