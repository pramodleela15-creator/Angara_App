

package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private final String URL = "https://www.angara.com";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(URL);
    }

    public void waitForPageLoad() {
        try {
            Thread.sleep(5000); // simple static wait for demo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
