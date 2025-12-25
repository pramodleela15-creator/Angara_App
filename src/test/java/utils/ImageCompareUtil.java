

package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageCompareUtil {

    // MUST be public + static
    public static boolean compareImages(File referenceImage, File currentImage) {
        try {
            BufferedImage img1 = ImageIO.read(referenceImage);
            BufferedImage img2 = ImageIO.read(currentImage);

            // Null check safety
            if (img1 == null || img2 == null) {
                return false;
            }

            // Dimension check
            if (img1.getWidth() != img2.getWidth() ||
                img1.getHeight() != img2.getHeight()) {
                return false;
            }

            // Pixel-by-pixel comparison
            for (int x = 0; x < img1.getWidth(); x++) {
                for (int y = 0; y < img1.getHeight(); y++) {
                    if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                        return false;
                    }
                }
            }
            return true;

        } catch (Exception e) {
            throw new RuntimeException("Image comparison failed", e);
        }
    }
}
