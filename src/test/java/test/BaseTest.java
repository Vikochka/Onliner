package test;

import Browser.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
       this.driver = new DriverFactory().getDriver();
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}