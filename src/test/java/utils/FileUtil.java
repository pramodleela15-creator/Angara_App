

package utils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileUtil {

    // Create directory if it does not exist
    public static void createDirectoryIfNotExists(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    // Generate timestamp for file naming
    public static String getTimestamp() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return LocalDateTime.now().format(formatter);
    }

    // Optional: delete file if needed
    public static void deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }
}

