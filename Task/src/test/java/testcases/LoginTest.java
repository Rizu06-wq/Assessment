package testcases;

import base.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ScreenshotUtil;

public class LoginTest extends BaseClass {

    @BeforeClass
    public void setUp() {
        initWebDriver();
        openURL();
    }

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "Admin123");

        // ✅ Use common screenshot utility method
        ScreenshotUtil.takeScreenshot(driver, "C:\\Users\\RIZWAN\\eclipse-workspace\\Task\\src\\test\\resources\\Screenshot\\LoginSuccess");

        Thread.sleep(2000);
    }
}
