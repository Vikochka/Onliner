package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class BasePage {
    public WebDriver driver;
    Waiters waiters;
    private String title;
    private By by;

    public BasePage() {
        assertIsOpen();
    }

    public void assertIsOpen() {
        try {
            waiters.waitForVisibility(by).isDisplayed();
        } catch (Throwable throwable) {
            Assert.fail("Page" + title + "does not appeared");
        }
    }
}
