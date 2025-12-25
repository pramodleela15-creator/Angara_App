

package utils;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class ScreenshotUtil {

    public static File captureScreenshot(WebDriver driver, String filePath) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);
            FileUtils.copyFile(src, dest);
            return dest;
        } catch (Exception e) {
            throw new RuntimeException("Failed to capture screenshot", e);
        }
    }
}

