package testcases;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.Visitingpage;
import utils.ScreenshotUtil;

import java.awt.AWTException;

public class VisitingPageTest extends BaseClass {

    @Test
    public void testVisitingPage() throws AWTException {
        Visitingpage visitingPage = new Visitingpage(driver);

        // Start visit
        visitingPage.clickStartVisit();
        visitingPage.clickConfirm();

        // Upload image
        visitingPage.clickAttachment();
        String filePath = "C:\\Users\\RIZWAN\\Downloads\\Oodu image.jpg";
        visitingPage.uploadFile(filePath);

        // Add caption
        visitingPage.enterCaption("This is a test caption.");
        visitingPage.clickFinalUpload();

        // Navigate back
        visitingPage.clickProfileNavigateLink();

        // ✅ Take screenshot after upload
        ScreenshotUtil.takeScreenshot(driver, 
            "C:\\Users\\RIZWAN\\eclipse-workspace\\Task\\src\\test\\resources\\Screenshot\\VisitingPage");

        System.out.println("✅ Visiting Page Test with file upload and caption completed successfully!");
    }

    // Uncomment if needed
    // @AfterClass
    // public void tearDown() {
    //     quitDriver();
    // }
}
