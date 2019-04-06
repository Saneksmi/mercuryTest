package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlightSelect extends BasePage {

    //Depart
    @FindBy(xpath = "//input[@value='Blue Skies Airlines$360$270$5:03']")
    WebElement blueSkies360;
    @FindBy(xpath = "//input[@value='Blue Skies Airlines$361$271$7:10']")
    WebElement blueSkies361;
    @FindBy(xpath = "//input[@value='Pangaea Airlines$362$274$9:17']")
    WebElement pangaea362;
    @FindBy(xpath = "//input[@value='Unified Airlines$363$281$11:24']")
    WebElement unified363;
    //Return
    @FindBy(xpath = "//input[@value='Blue Skies Airlines$630$273$12:23']")
    WebElement blueSkies630;
    @FindBy(xpath = "//input[@value='Blue Skies Airlines$631$273$14:30']")
    WebElement blueSkies631;
    @FindBy(xpath = "//input[@value='Pangea Airlines$632$273$16:37']")
    WebElement pangea632;
    @FindBy(xpath = "//input[@value='Unified Airlines$633$273$18:44']")
    WebElement unified633;
    @FindBy(xpath = "//input[@name='reserveFlights']")
    WebElement continueButton;

    public FlightSelect(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void flight360Choise() {
        blueSkies360.click();
    }

    public void flight361Choise() {
        blueSkies361.click();
    }

    public void flight362Choise() {
        pangaea362.click();
    }

    public void flight363Choise() {
        unified363.click();
    }

    public void flight630Choise() {
        blueSkies630.click();
    }

    public void flight631Choise() {
        blueSkies631.click();
    }

    public void flight632Choise() {
        pangea632.click();
    }

    public void flight633Choise() {
        unified633.click();
    }

    public void continueButtonClick() {
        waitClickable(continueButton);
        continueButton.click();

    }

}
