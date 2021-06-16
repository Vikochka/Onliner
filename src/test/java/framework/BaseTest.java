package framework;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    protected static Browser browser = Browser.getInstance();
    protected ITestContext context;


    @BeforeClass
    public void before(ITestContext context) {
        this.context = context;
        browser = Browser.getInstance();
        browser.windowMaximise();
        browser.navigate(PropertyReader.getProperty("URL"));
    }

    @AfterClass(alwaysRun = true, description = "Closing browser")
    public void after() {
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }
}