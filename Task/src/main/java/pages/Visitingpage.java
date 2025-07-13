package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Visitingpage {

    private WebDriver driver;
    private WebDriverWait wait;

    public Visitingpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[normalize-space(text())='Start Visit']")
    private WebElement btnStartVisit;

    @FindBy(id = "start-visit-with-visittype-confirm")
    private WebElement btnConfirm;

    @FindBy(id = "attachments.attachments.visitActions.default")
    private WebElement btnAttachment;

    @FindBy(xpath = "//*[@id='att-page-main']//att-file-upload//textarea")
    private WebElement txtCaption;

    @FindBy(xpath = "//div[text()='Click or drop a file here.']")
    private WebElement btnUploadFile;
    
    @FindBy(xpath = "//*[@class='confirm ng-binding']")
    private WebElement btnFileUpload;
    
    @FindBy(xpath = "//*[@id=\"breadcrumbs\"]/li[2]/a")
    private WebElement profileNavigateLink;

    public void clickStartVisit() {
        wait.until(ExpectedConditions.elementToBeClickable(btnStartVisit)).click();
    }

    public void clickConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(btnConfirm)).click();
    }

    public void clickAttachment() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAttachment)).click();
    }

    public void uploadFile(String filePath) throws AWTException {
        wait.until(ExpectedConditions.elementToBeClickable(btnUploadFile)).click();

        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot = new Robot();
        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void enterCaption(String caption) {
        wait.until(ExpectedConditions.visibilityOf(txtCaption)).sendKeys(caption);
    }

    public void clickFinalUpload() {
        wait.until(ExpectedConditions.elementToBeClickable(btnFileUpload)).click();
    }
    public void clickProfileNavigateLink() {
        wait.until(ExpectedConditions.elementToBeClickable(profileNavigateLink)).click();
    }
}
