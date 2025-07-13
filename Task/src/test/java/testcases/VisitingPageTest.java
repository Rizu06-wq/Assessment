package testcases;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.Visitingpage;

import java.awt.AWTException;

public class VisitingPageTest extends BaseClass {

    @Test
    public void testVisitingPage() throws AWTException {
        Visitingpage visitingPage = new Visitingpage(driver);

        visitingPage.clickStartVisit();
        visitingPage.clickConfirm();
        visitingPage.clickAttachment();

        // Upload file
        String filePath = "C:\\Users\\RIZWAN\\Downloads\\Oodu image.jpg";
        visitingPage.uploadFile(filePath);

        // Enter caption
        visitingPage.enterCaption("This is a test caption.");

        // Click Upload to confirm
        visitingPage.clickFinalUpload();
        visitingPage.clickProfileNavigateLink();


        System.out.println("✅ Visiting Page Test with file upload and caption completed successfully!");
    }

    // @AfterClass
    // public void tearDown() {
    //     quitDriver();
    // }
}
