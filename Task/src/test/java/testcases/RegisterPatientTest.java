package testcases;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.RegisterPatient;
import utils.ScreenshotUtil;

public class RegisterPatientTest extends BaseClass {

    @Test(dependsOnMethods = {"testcases.LoginTest.loginTest"})
    public void testRegisterPatient() throws InterruptedException {
        RegisterPatient registerPatient = new RegisterPatient(driver);

        // Register the patient
        registerPatient.registerPatientFlow(
                "Rizu", "Dg",
                "15", "July", "1990",
                "123 Main St", "Apt 4B",
                "9876543210",
                "Male"
        );

        // ✅ Take screenshot after registration
        ScreenshotUtil.takeScreenshot(driver, "C:\\Users\\RIZWAN\\eclipse-workspace\\Task\\src\\test\\resources\\Screenshot\\RegisterPatient");

        System.out.println("✅ Register patient test completed!");
    }
}
