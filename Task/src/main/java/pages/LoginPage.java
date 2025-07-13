package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    // ✅ The element to click to open the dropdown
    @FindBy(id = "sessionLocation") // ✅ Make sure this is really the clickable element!
    private WebElement locationTrigger;

    @FindBy(id = "loginButton")
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        txtUsername.sendKeys(user);
        txtPassword.sendKeys(pass);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ✅ Click to open the dropdown
        locationTrigger.click();

        // ✅ Dynamic <li> locator — do NOT use @FindBy!
        By outpatientOption = By.xpath("//li[normalize-space()='Outpatient Clinic']");

        // ✅ Wait for <li> to appear & be clickable
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(outpatientOption));
        option.click();

        // ✅ Click login
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
    }
}
