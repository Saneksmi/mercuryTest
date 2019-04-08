package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinder extends BasePage {

    private Select select;

    @FindBy (xpath = "//title)")
    String title;

    //Flight Details
    @FindBy(xpath = "//input[@value='roundtrip']")
    WebElement roundTrip;
    @FindBy(xpath = "//input[@value='oneway']")
    WebElement oneWayTrip;
    @FindBy(xpath = "//select[@name='passCount']")
    WebElement numberOfPassengers;
    @FindBy(xpath = "//select[@name='fromPort']")
    WebElement departingFrom;
    @FindBy(xpath = "//select[@name='fromMonth']")
    WebElement monthOfDeparture;
    @FindBy(xpath = "//select[@name='fromDay']")
    WebElement dayOfDeparture;
    @FindBy(xpath = "//select[@name='toPort']")
    WebElement arrivalTo;
    @FindBy(xpath = "//select[@name='toMonth']")
    WebElement monthOfArrival;
    @FindBy(xpath = "//select[@name='toDay']")
    WebElement dayOfArrival;

    //Preferences
    @FindBy(xpath = "//input[@value='Coach']")
    WebElement economyClass;
    @FindBy(xpath = "//input[@value='Business']")
    WebElement businessClass;
    @FindBy(xpath = "//input[@value='First']")
    WebElement firstClass;
    @FindBy(xpath = "//select[@name='airline']")
    WebElement airlineSelect;
    @FindBy(xpath = "//input[@name='findFlights']")
    WebElement continueButton;


    public FlightFinder(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Select getSelect (WebElement element) {
        select = new Select(element);
        return select;
    }

    public void roundTripClick() {
        roundTrip.click();
    }

    public void oneWayTripClick() {
        oneWayTrip.click();
    }

    public void setNumberOfPassengers(String numOfPas) {
        getSelect(numberOfPassengers);
        select.selectByVisibleText(numOfPas);
    }

    public void setDepartingDetails(String fromPort, String fromMonth, String fromDay) {
        getSelect(departingFrom);
        select.selectByVisibleText(fromPort);
        getSelect(monthOfDeparture);
        select.selectByVisibleText(fromMonth);
        getSelect(dayOfDeparture);
        select.selectByVisibleText(fromDay);
    }

    public void setArrivingDetails(String toPort, String toMonth, String toDay) {
        getSelect(arrivalTo);
        select.selectByVisibleText(toPort);
        getSelect(monthOfArrival);
        select.selectByVisibleText(toMonth);
        getSelect(dayOfArrival);
        select.selectByVisibleText(toDay);
    }

    public void economyClassChoise() {
        economyClass.click();
    }

    public void businessClassChoise() {
        businessClass.click();
    }

    public void firstClassChoise() {
        firstClass.click();
    }

    public void flightPreferences(String airline) {
        getSelect(airlineSelect);
        select.selectByVisibleText(airline);
    }

    public void continueButtonClick() {
        waitClickable(continueButton);
        continueButton.click();
    }
}
