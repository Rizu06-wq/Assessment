package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Page Object Model for "Register Patient" page.
 */
public class RegisterPatient {

    private WebDriver driver;

    // Constructor: initializes the elements on this page
    public RegisterPatient(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='icon-user']")
    private WebElement btnRegisterPatient;

    @FindBy(name = "givenName")
    private WebElement inputGivenName;


    @FindBy(name = "familyName")
    private WebElement inputFamilyName;
  
    @FindBy(id = "next-button")
    private WebElement btnNext;

    @FindBy(id = "gender-field")
    private WebElement selectGender;

    @FindBy(id = "birthdateDay-field")
    private WebElement inputDay;

    @FindBy(id = "birthdateMonth-field")
    private WebElement selectMonth;

    @FindBy(id = "birthdateYear-field")
    private WebElement inputYear;

    @FindBy(id = "address1")
    private WebElement inputAddress1;

    @FindBy(id = "address2")
    private WebElement inputAddress2;

    @FindBy(name = "phoneNumber")
    private WebElement inputMobile;

    @FindBy(id = "submit")
    private WebElement btnConfirm;

    public void clickRegisterPatient() {
        btnRegisterPatient.click();
    }

    public void enterName(String given, String family) {
        inputGivenName.sendKeys(given);
        inputFamilyName.sendKeys(family);
    }

    public void clickNext() {
        btnNext.click();
    }

    public void selectGender(String gender) {
        Select genderDropdown = new Select(selectGender);
        genderDropdown.selectByVisibleText(gender);
    }

    public void enterBirthdate(String day, String month, String year) {
        inputDay.sendKeys(day);
        selectMonth.sendKeys(month);
        inputYear.sendKeys(year);
    }

    public void enterAddress(String addr1, String addr2) {
        inputAddress1.sendKeys(addr1);
        inputAddress2.sendKeys(addr2);
    }

    public void enterMobile(String mobile) {
        inputMobile.sendKeys(mobile);
    }

    public void confirm() {
        btnConfirm.click();
    }

    // Consolidated method for full flow
    public void registerPatientFlow(
        String given, String family, String day,
        String month, String year, String addr1,
        String addr2, String mobile, String gender
    ) {
        clickRegisterPatient();
        enterName(given, family);
        clickNext();
        selectGender(gender);
        clickNext();
        enterBirthdate(day, month, year);
        clickNext();
        enterAddress(addr1, addr2);
        clickNext();
        enterMobile(mobile);
        clickNext();
        clickNext();
        confirm();
    }
}
