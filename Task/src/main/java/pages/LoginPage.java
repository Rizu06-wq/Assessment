package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "sessionLocation")
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

        locationTrigger.click();

        By outpatientOption = By.xpath("//li[normalize-space()='Outpatient Clinic']");
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(outpatientOption));
        option.click();

        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
    }

 
}
