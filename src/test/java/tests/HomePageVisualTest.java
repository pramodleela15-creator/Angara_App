
package tests;

import base.BaseTest;
import pages.HomePage;
import utils.FileUtil;
import utils.ImageCompareUtil;
import utils.ScreenshotUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class HomePageVisualTest extends BaseTest {

    @Test
    public void compareHomePageScreenshotAcrossRuns() {

        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.waitForPageLoad();

        String referenceDir = "screenshots/reference";
        String passedDir    = "screenshots/passed";
        String failedDir    = "screenshots/failed";

        // Create folders if not exist
        FileUtil.createDirectoryIfNotExists(referenceDir);
        FileUtil.createDirectoryIfNotExists(passedDir);
        FileUtil.createDirectoryIfNotExists(failedDir);

        String referencePath = referenceDir + "/homepage.png";
        String currentPath   = passedDir + "/homepage_passed.png";

        File currentImage = ScreenshotUtil.captureScreenshot(driver, currentPath);
        File referenceImage = new File(referencePath);

        // First execution → create reference screenshot
        if (!referenceImage.exists()) {
            currentImage.renameTo(referenceImage);
            Assert.assertTrue(true, "Reference screenshot created successfully");
            return;
        }

        boolean isSame = ImageCompareUtil.compareImages(referenceImage, currentImage);

        // If difference detected → move to failed folder with timestamp
        if (!isSame) {
            String failedPath = failedDir + "/homepage_failed_" +
                    FileUtil.getTimestamp() + ".png";

            currentImage.renameTo(new File(failedPath));
            Assert.fail("Visual differences detected. Manual review required.");
        }

        Assert.assertTrue(true, "No visual changes detected");
    }
}
