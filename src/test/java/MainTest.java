import org.junit.Test;
import pages.FlightBooking;
import pages.FlightFinder;
import pages.FlightSelect;
import pages.HomePage;

public class MainTest extends BaseTest {

    @Test
    public void stepsOfTest() {
        loginFromHomePage();
        selectFlightDetails();
        selectFlightPreferences();
        selectFlight();
        bookFlight();
    }

    public void loginFromHomePage() {
        HomePage login = new HomePage(driver);
        login.login("test1", "test1");
        login.signInButtonClick();
    }

    public void selectFlightDetails() {
        FlightFinder flight = new FlightFinder(driver);
        flight.oneWayTripClick();
        flight.setFlightDetails("1", "New York", "April", "7",
                "Acapulco", "May", "6");
        flight.continueButtonClick();
    }

    public void selectFlightPreferences() {
        FlightFinder flight = new FlightFinder(driver);
        flight.businessClassChoise();
        flight.flightPreferences("Blue Skies Airlines");
    }

    public void selectFlight() {
        FlightSelect flightSelect = new FlightSelect(driver);
        flightSelect.flight361Choise();
        flightSelect.flight631Choise();
        flightSelect.continueButtonClick();
    }

    public void bookFlight() {
        FlightBooking flightBook = new FlightBooking(driver);
        flightBook.setPassengers("Victor", "Pupkin", "Low Calorie");
        flightBook.setCreditCard("MasterCard", "4444 8888", "09", "2010");
        flightBook.setCardOwner("Victor", "Ivanovich", "Pupkin");
        flightBook.setBillingAddress("4765 Bond Str.", "Yfa", "SQ", "776688","RUSSIA");
        flightBook.asBillingAddressClick();
        flightBook.setDeliveryAddress("4765 Bond Str.", "Yfa", "SQ", "776688","RUSSIA");
        flightBook.securePurchaseButtonClick();
    }
}
