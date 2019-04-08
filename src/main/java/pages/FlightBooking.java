package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightBooking extends BasePage {

    private Select select;

    @FindBy (xpath = "//title)")
    String title;

    //Summary depart info
    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[1]")
    public WebElement departRoute;
    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[2]")
    public WebElement departDate;
    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//b)[3]")
    public WebElement departFlight;
    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[7]")
    public WebElement departFlightClass;
    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[8]")
    public WebElement departPrice;

    //Summary arrival info
    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[9]")
    public WebElement arrivalRoute;
    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[10]")
    public WebElement arrivalDate;
    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//b)[6]")
    public WebElement arrivalFlight;
    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[19]")
    public WebElement arrivalFlightClass;
    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[20]")
    public WebElement arrivalPrice;

    //Price
    @FindBy (xpath = "(//td/font[text()='Passengers:']/following::td/font)[1]")
    public WebElement numberOfPassengers;
    @FindBy (xpath = "(//td/font[contains(.,'Taxes:')]/following::td/font)[1]")
    public WebElement taxes;
    @FindBy (xpath = "(//td/font[contains(.,'Total Price')]/following::td//b)[1]")
    public WebElement totalPrice;

    //Passengers
    @FindBy(xpath = "//input[@name='passFirst0']")
    WebElement passengerFirstName;
    @FindBy(xpath = "//input[@name='passLast0']")
    WebElement passengerLastName;
    @FindBy(xpath = "//select[@name='pass.0.meal']")
    WebElement passengerMeal;

    //Credit Card
    @FindBy(xpath = "//select[@name='creditCard']")
    WebElement cardType;
    @FindBy(xpath = "//input[@name='creditnumber']")
    WebElement cardNumber;
    @FindBy(xpath = "//select[@name='cc_exp_dt_mn']")
    WebElement expirationMonth;
    @FindBy(xpath = "//select[@name='cc_exp_dt_yr']")
    WebElement expirationYear;
    @FindBy(xpath = "//input[@name='cc_frst_name']")
    WebElement cardOwnerFirstName;
    @FindBy(xpath = "//input[@name='cc_mid_name']")
    WebElement cardOwnerMiddleName;
    @FindBy(xpath = "//input[@name='cc_last_name']")
    WebElement cardOwnerLastName;

    //Billing address
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement ticketLess;
    @FindBy(xpath = "//input[@name='billAddress1']")
    WebElement billingAddress;
    @FindBy(xpath = "//input[@name='billCity']")
    WebElement billingCity;
    @FindBy(xpath = "//input[@name='billState']")
    WebElement billingState;
    @FindBy(xpath = "//input[@name='billZip']")
    WebElement billingZip;
    @FindBy(xpath = "//select[@name='billCountry']")
    WebElement billingCountry;

    //Delivery address
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    WebElement asBillingAddress;
    @FindBy(xpath = "//input[@name='delAddress1']")
    WebElement deliveryAddress;
    @FindBy(xpath = "//input[@name='delCity']")
    WebElement deliveryCity;
    @FindBy(xpath = "//input[@name='delState']")
    WebElement deliveryState;
    @FindBy(xpath = "//input[@name='delZip']")
    WebElement deliveryZip;
    @FindBy(xpath = "//select[@name='delCountry']")
    WebElement deliveryCountry;
    @FindBy(xpath = "//input[@name='buyFlights']")
    WebElement securePurchaseButton;



    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

    public FlightBooking(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setPassengers(String firstName, String lastName, String meal) {
        passengerFirstName.clear();
        passengerFirstName.sendKeys(firstName);
        passengerLastName.clear();
        passengerLastName.sendKeys(lastName);
        getSelect(passengerMeal);
        select.selectByVisibleText(meal);
    }

    public void setCreditCard(String type, String number, String month, String year) {
        getSelect(cardType);
        select.selectByVisibleText(type);
        cardNumber.clear();
        cardNumber.sendKeys(number);
        getSelect(expirationMonth);
        select.selectByVisibleText(month);
        getSelect(expirationYear);
        select.selectByVisibleText(year);
    }

    public void setCardOwner(String fName, String mName, String lName) {
        cardOwnerFirstName.clear();
        cardOwnerFirstName.sendKeys(fName);
        cardOwnerMiddleName.clear();
        cardOwnerMiddleName.sendKeys(mName);
        cardOwnerLastName.clear();
        cardOwnerLastName.sendKeys(lName);
    }

    public void setBillingAddress(String address, String city, String state, String post, String country) {
        billingAddress.clear();
        billingAddress.sendKeys(address);
        billingCity.clear();
        billingCity.sendKeys(city);
        billingState.clear();
        billingState.sendKeys(state);
        billingZip.clear();
        billingZip.sendKeys(post);
        getSelect(billingCountry);
        select.selectByVisibleText(country);
    }

    public void asBillingAddressClick() {
        asBillingAddress.click();
    }

    public void setDeliveryAddress(String address, String city, String state, String post, String country) {
        deliveryAddress.clear();
        deliveryAddress.sendKeys(address);
        deliveryCity.clear();
        deliveryCity.sendKeys(city);
        deliveryState.clear();
        deliveryState.sendKeys(state);
        deliveryZip.clear();
        deliveryZip.sendKeys(post);
        getSelect(deliveryCountry);
        select.selectByVisibleText(country);
    }

    public void securePurchaseButtonClick(){
        securePurchaseButton.click();
    }
}
