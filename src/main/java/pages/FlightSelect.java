package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlightSelect extends BasePage {

    @FindBy (xpath = "//title)")
    String title;

    //Depart info
    @FindBy (xpath = "(//font[text() = 'DEPART']/following::tr//font)[1]")
    public WebElement departRoute;
    @FindBy (xpath = "(//font[text() = 'DEPART']/following::tr//font)[2]")
    public WebElement departDate;

    //Depart
    @FindBy(xpath = "//input[@value='Blue Skies Airlines$361$271$7:10']")
    WebElement departFlight;
    @FindBy(xpath = "(//td//b[contains(.,'Blue Skies Airlines 361')]/following::tr//b)[1]")
    public WebElement departPrice;

    //Return info
    @FindBy (xpath = "(//font[text() = 'RETURN']/following::tr//font)[1]")
    public WebElement returnRoute;
    @FindBy (xpath = "(//font[text() = 'RETURN']/following::tr//font)[2]")
    public WebElement returnDate;

    //Return
    @FindBy(xpath = "//input[@value='Blue Skies Airlines$631$273$14:30']")
    WebElement returnFlight;
    @FindBy(xpath = "(//td//b[contains(.,'Blue Skies Airlines 631')]/following::tr//b)[1]")
    public WebElement returnPrice;
    @FindBy(xpath = "//input[@name='reserveFlights']")
    WebElement continueButton;

    public FlightSelect(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Depart
    public void departFlightSelect() {
        departFlight.click();
    }

    //Return
    public void returnFlightSelect() {
        returnFlight.click();
    }

    public void continueButtonClick() {
        waitClickable(continueButton);
        continueButton.click();

    }

}
