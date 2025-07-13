package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeletePatient {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public DeletePatient(WebDriver driver) {
        this.driver = driver;
        this.wait  = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // ---------- LOCATORS ----------

    @FindBy(css  = "#referenceapplication\\.realTime\\.endVisit div")              // “End Visit” blue button
    private WebElement btnEndVisit;

    @FindBy(css  = "#end-visit-dialog button.confirm")                           // confirm in the modal
    private WebElement btnConfirmEndVisit;

    @FindBy(css  = "#org\\.openmrs\\.module\\.coreapps\\.deletePatient div:nth-child(2)")
    private WebElement btnDeletePatient;

    @FindBy(id   = "delete-reason")
    private WebElement txtDeleteReason;

    @FindBy(css  = "#delete-patient-creation-dialog button.confirm")             // confirm delete
    private WebElement btnConfirmDelete;

    @FindBy(id   = "patient-search")
    private WebElement txtPatientSearch;

    @FindBy(css  = "ul#patient-search-results li")                               // list items returned after search
    private WebElement lstSearchResult;

    // ---------- ACTIONS ----------

    /** Clicks the blue “End Visit” pill in the right rail. */
    public void endVisit() {
        clickWithJsFallback(btnEndVisit);
        wait.until(ExpectedConditions.visibilityOf(btnConfirmEndVisit)).click();
        wait.until(ExpectedConditions.invisibilityOf(btnConfirmEndVisit));
    }

    /** Deletes the patient with a supplied reason. */
    public void deletePatient(String reason) {
        wait.until(ExpectedConditions.elementToBeClickable(btnDeletePatient)).click();
        wait.until(ExpectedConditions.visibilityOf(txtDeleteReason)).sendKeys(reason);
        clickWithJsFallback(btnConfirmDelete);
        wait.until(ExpectedConditions.invisibilityOf(btnConfirmDelete));
    }

    /** Searches for a patient name and returns true if ANY result is still shown. */
    public boolean patientExists(String patientName) {
        wait.until(ExpectedConditions.visibilityOf(txtPatientSearch)).clear();
        txtPatientSearch.sendKeys(patientName);
        wait.until(ExpectedConditions.attributeContains(txtPatientSearch, "value", patientName));
        // Wait for the results panel to finish updating (spinner disappears)
        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.querySelector('#patient-search-results')?.classList.contains('loading')") == Boolean.FALSE);
        return driver.findElements(By.cssSelector("ul#patient-search-results li")).size() > 0;
    }

    // ---------- helpers ----------

    private void clickWithJsFallback(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException | TimeoutException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}
