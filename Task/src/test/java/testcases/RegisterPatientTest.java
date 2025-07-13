package testcases;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.RegisterPatient;

public class RegisterPatientTest extends BaseClass {

    @Test(dependsOnMethods = {"testcases.LoginTest.loginTest"})
    public void testRegisterPatient() throws InterruptedException {
        RegisterPatient registerPatient = new RegisterPatient(driver);
        registerPatient.registerPatientFlow(
                "Gokul", "sivam",
                "15", "July", "1990",
                "123 Main St", "Apt 4B",
                "9876543210",
                "Male"
        );
        System.out.println("✅ Register patient test completed!");
    }
}
