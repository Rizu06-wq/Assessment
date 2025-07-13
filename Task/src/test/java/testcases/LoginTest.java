package testcases;

import base.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

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
     Snippet scrnshot = new Snippet();
     String file ="C:\\Users\\RIZWAN\\eclipse-workspace\\Task\\src\\test\\resources\\Screenshot\\1.jpg" ;
     
     
        Thread.sleep(2000);
        
    }
}
