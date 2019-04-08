import org.junit.Assert;
import org.junit.Test;
import pages.*;

import static java.lang.Integer.parseInt;

public class MainTest extends BaseTest {

    private String homePageTitle = "Mercury Tours";
    private String flightFinderPageTitle = "Find a Flight";
    private String selectFlightPageTitle = "Select a Flight";
    private String bookFlightPageTitle = "Book a Flight";
    private String flightConfirmationPageTitle = "Flight Confirmation";
    private String currentYear = "2019";

    //authorization
    private String login = "test1";
    private String password = "test1";

    //Flight details
    private String numberOfPassengers = "1";
    private String departingFrom = "New York";
    private String departingMonth = "March";
    private String departingDay = "8";
    private String arrivalTo = "Acapulco";
    private String arrivalMonth = "May";
    private String arrivalDay = "6";
    private String flightClass = "Business";
    private String airline = "Blue Skies Airlines";

    //Select flight
    private String departingRoute;
    private String departingDate;
    private String departingFlight = "Blue Skies Airlines 361";
    private int departingPrice;
    private String returnRoute;
    private String returnDate;
    private String returnFlight = "Blue Skies Airlines 631";
    private int returnPrice;

    //Book a flight
    private int departingPriceCheck;
    private int returnPriceCheck;
    private int taxes;
    private int totalPrice;
    private int totalPriceCheck;
    private String firstName = "Victor";
    private String middleName = "Ivanovich";
    private String lastName = "Pupkin";
    private String mealPreferences = "Low Calorie";
    private String cardType = "MasterCard";
    private String cardNumber = "4444 8888";
    private String cardExpirationMonth = "09";
    private String cardExpirationYear = "2010";
    private String address = "4765 Bond Str.";
    private String city = "Yfa";
    private String state = "My State";
    private String postCode =  "778866";
    private String country = "UNITED STATES";

    //Confirm flight
    private String passengerFullName;

    private int monthToInt(String monthString) {
        int monthInt = 0;
            switch (monthString) {
                case "January":
                    monthInt = 1;
                    break;
                case "February":
                    monthInt = 2;
                    break;
                case "March":
                    monthInt = 3;
                    break;
                case "April":
                    monthInt = 4;
                    break;
                case "May":
                    monthInt = 5;
                    break;
                case "June":
                    monthInt = 6;
                    break;
                case "July":
                    monthInt = 7;
                    break;
                case "August":
                    monthInt = 8;
                    break;
                case "September":
                    monthInt = 9;
                    break;
                case "October":
                    monthInt = 10;
                    break;
                case "November":
                    monthInt = 11;
                    break;
                case "December":
                    monthInt = 12;
                    break;
            }
        return monthInt;
    }

    @Test
    public void stepsOfTest() {
        loginFromHomePage();
        selectFlightDetails();
        selectFlight();
        bookFlight();
        confirmFlight();
    }

    public void loginFromHomePage() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(driver.getTitle().contains(homePageTitle));
        homePage.login(login, password);
        homePage.signInButtonClick();
    }

    public void selectFlightDetails() {
        FlightFinder flightFinder = new FlightFinder(driver);
        Assert.assertTrue(driver.getTitle().contains(flightFinderPageTitle));
        flightFinder.oneWayTripClick();
        flightFinder.setNumberOfPassengers(numberOfPassengers);
        flightFinder.setDepartingDetails(departingFrom, departingMonth, departingDay);
        flightFinder.setArrivingDetails(arrivalTo, arrivalMonth, arrivalDay);
        flightFinder.businessClassChoise();
        flightFinder.flightPreferences(airline);
        flightFinder.continueButtonClick();
    }

    public void selectFlight() {
        FlightSelect flightSelect = new FlightSelect(driver);
        Assert.assertTrue(driver.getTitle().contains(selectFlightPageTitle));

        departingRoute = departingFrom + " to " + arrivalTo;
        Assert.assertEquals(departingRoute, flightSelect.departRoute.getText());

        departingDate = monthToInt(departingMonth) + "/" + departingDay + "/" + currentYear;
        Assert.assertEquals(departingDate, flightSelect.departDate.getText());

        flightSelect.departFlightSelect();

        departingPrice = parseInt(flightSelect.departPrice.getText().replaceAll("[^0-9]", ""));

        returnRoute = arrivalTo + " to " + departingFrom;
        Assert.assertEquals(returnRoute, flightSelect.returnRoute.getText());

        returnDate = monthToInt(arrivalMonth) + "/" + arrivalDay + "/" + currentYear;
        Assert.assertEquals(returnDate, flightSelect.returnDate.getText());

        flightSelect.returnFlightSelect();

        returnPrice = parseInt(flightSelect.returnPrice.getText().replaceAll("[^0-9]", ""));

        flightSelect.continueButtonClick();
    }

    public void bookFlight() {
        FlightBooking flightBooking = new FlightBooking(driver);

        Assert.assertTrue(driver.getTitle().contains(bookFlightPageTitle));
        Assert.assertEquals(departingRoute, flightBooking.departRoute.getText());
        Assert.assertEquals(departingDate, flightBooking.departDate.getText());
        Assert.assertEquals(departingFlight, flightBooking.departFlight.getText());
        Assert.assertEquals(flightClass, flightBooking.departFlightClass.getText());
        departingPriceCheck = parseInt(flightBooking.departPrice.getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(departingPriceCheck, departingPrice);

        Assert.assertEquals(returnRoute, flightBooking.arrivalRoute.getText());
        Assert.assertEquals(returnDate, flightBooking.arrivalDate.getText());
        Assert.assertEquals(returnFlight, flightBooking.arrivalFlight.getText());
        Assert.assertEquals(flightClass, flightBooking.arrivalFlightClass.getText());
        returnPriceCheck = parseInt(flightBooking.arrivalPrice.getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(returnPriceCheck, returnPrice);
        Assert.assertEquals(numberOfPassengers, flightBooking.numberOfPassengers.getText());

        //считываем налоги и общую стоимость
        taxes = parseInt(flightBooking.taxes.getText().replaceAll("[^0-9]", ""));
        totalPrice = (departingPrice + returnPrice)*parseInt(numberOfPassengers) + taxes;
        totalPriceCheck = parseInt(flightBooking.totalPrice.getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(totalPrice, totalPriceCheck);

        flightBooking.setPassengers(firstName, lastName, mealPreferences);
        flightBooking.setCreditCard(cardType, cardNumber, cardExpirationMonth, cardExpirationYear);
        flightBooking.setCardOwner(firstName, middleName, lastName);
        flightBooking.setBillingAddress(address, city, state, postCode, country);
        flightBooking.asBillingAddressClick();
        flightBooking.setDeliveryAddress(address, city, state, postCode, country);
        flightBooking.securePurchaseButtonClick();
    }

    public void confirmFlight() {
        FlightConfirm flightConfirm = new FlightConfirm(driver);
        Assert.assertTrue(driver.getTitle().contains(flightConfirmationPageTitle));

        Assert.assertTrue(flightConfirm.departingSummaryInfo.getText().contains(departingRoute));
        Assert.assertTrue(flightConfirm.departingSummaryInfo.getText().contains(departingDate));
        Assert.assertTrue(flightConfirm.departingSummaryInfo.getText().contains(airline));
        Assert.assertTrue(flightConfirm.departingSummaryInfo.getText().contains(flightClass));
        Assert.assertTrue(flightConfirm.departingSummaryInfo.getText().contains(Integer.toString(departingPrice)));

        Assert.assertTrue(flightConfirm.returningSummaryInfo.getText().contains(returnRoute));
        Assert.assertTrue(flightConfirm.returningSummaryInfo.getText().contains(returnDate));
        Assert.assertTrue(flightConfirm.returningSummaryInfo.getText().contains(airline));
        Assert.assertTrue(flightConfirm.returningSummaryInfo.getText().contains(flightClass));
        Assert.assertTrue(flightConfirm.returningSummaryInfo.getText().contains(Integer.toString(returnPrice)));

        Assert.assertTrue(flightConfirm.passengerSummaryInfo.getText().contains(numberOfPassengers));

        passengerFullName = firstName + " " + middleName + " " + lastName;

        Assert.assertTrue(flightConfirm.billedSummaryInfo.getText().contains(passengerFullName));
        Assert.assertTrue(flightConfirm.billedSummaryInfo.getText().contains(address));
        Assert.assertTrue(flightConfirm.billedSummaryInfo.getText().contains(city));
        Assert.assertTrue(flightConfirm.billedSummaryInfo.getText().contains(state));
        Assert.assertTrue(flightConfirm.billedSummaryInfo.getText().contains(postCode));

        Assert.assertTrue(flightConfirm.deliverySummaryInfo.getText().contains(address));
        Assert.assertTrue(flightConfirm.deliverySummaryInfo.getText().contains(city));
        Assert.assertTrue(flightConfirm.deliverySummaryInfo.getText().contains(state));
        Assert.assertTrue(flightConfirm.deliverySummaryInfo.getText().contains(postCode));

        Assert.assertTrue(flightConfirm.totalPrice.getText().contains(Integer.toString(totalPriceCheck)));

        flightConfirm.clickHomeButton();

    }
}
