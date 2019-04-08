package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightConfirm extends BasePage {

    @FindBy (xpath = "//title)")
    String title;

    @FindBy (xpath = "(//tr//font[contains(.,'Departing')]/following::tr//font)[1]")
    public WebElement departingSummaryInfo;
    @FindBy (xpath = "(//tr//font[contains(.,'Returning')]/following::tr//font)[1]")
    public WebElement returningSummaryInfo;
    @FindBy (xpath = "(//tr//font[contains(.,'Passengers')]/following::tr//font)[1]")
    public WebElement passengerSummaryInfo;
    @FindBy (xpath = "(//tr//font[contains(.,'Billed')]/following::tr//font)[1]")
    public WebElement billedSummaryInfo;
    @FindBy (xpath = "(//tr//font[contains(.,'Delivery')]/following::tr//font)[1]")
    public WebElement deliverySummaryInfo;
    @FindBy (xpath = "(//td//font/b[contains(.,'Total')]/following::td//font)[1]")
    public WebElement totalPrice;
    @FindBy (xpath = "//a[@href='mercurywelcome.php']/img")
    WebElement homeButton;

    public void clickHomeButton() {
        homeButton.click();
    }

    public FlightConfirm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
