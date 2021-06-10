package framework;

import framework.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static framework.PropertyReader.getIntProperty;
import static framework.PropertyReader.getProperty;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
       this.driver = new DriverFactory().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(getIntProperty("timeout"), TimeUnit.SECONDS);
        driver.get(getProperty("URL"));
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}