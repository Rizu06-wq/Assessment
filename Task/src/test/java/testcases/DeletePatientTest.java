package testcases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.DeletePatient;
import utils.ScreenshotUtil;

public class DeletePatientTest extends BaseClass {

    /** Depends on the visit having been created in the previous test. */
    @Test(dependsOnMethods = "testcases.VisitingPageTest.testVisitingPage")
    public void testDeletePatientFlow(ITestContext context) {

        // Retrieve the patient name from context (set in RegisterPatientTest) or use fallback:
        String patientName = (String) context.getSuite().getAttribute("registeredPatientName");
        if (patientName == null) patientName = "Rizu Dg";

        DeletePatient deletePage = new DeletePatient(driver);

        // 1. End the current visit
        deletePage.endVisit();

        // 2. Delete the patient
        deletePage.deletePatient("Automation Test - Delete reason");

        // ✅ Take screenshot after deletion
        ScreenshotUtil.takeScreenshot(driver, "C:\\Users\\RIZWAN\\eclipse-workspace\\Task\\src\\test\\resources\\Screenshot\\DeletePatient");

        // 3. Verify patient is gone
        boolean stillPresent = deletePage.patientExists(patientName);
        Assert.assertFalse(stillPresent, "❌ Patient '" + patientName + "' was still found after deletion!");

        System.out.println("✅ Delete Patient Flow completed successfully!");
    }
}
