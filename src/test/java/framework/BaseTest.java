package framework;

import framework.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import static framework.PropertyReader.getIntProperty;
import static framework.PropertyReader.getProperty;

public class BaseTest {
    public WebDriver driver;
    protected static Browser browser = Browser.getInstance();
    protected ITestContext context;


    @BeforeClass
    public void before(ITestContext context) {
        this.context = context;
        browser = Browser.getInstance();
        browser.windowMaximise();
        browser.navigate(getProperty("URL"));
    }

    @AfterClass(alwaysRun = true, description = "Closing browser")
    public void after() {
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }


}