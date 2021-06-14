package framework;

import com.google.common.base.Strings;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.naming.NamingException;
import java.util.concurrent.TimeUnit;

import static framework.PropertyReader.getIntProperty;

public class Browser {

    private static final long IMPLICITLY_WAIT = getIntProperty("timeout");
    private static final int DEFAULT_CONDITION_TIMEOUT = getIntProperty("timeoutElement");
    private static final int DEFAULT_PAGE_LOAD_TIMEOUT = getIntProperty("timeout");;

    static final String PROPERTIES_FILE = "selenium.properties";
    private static final String BROWSER_BY_DEFAULT = "firefox";
    private static final String BROWSER_PROP = "browser";


    // browsers
    private static Browser instance;
    private static WebDriver driver;

    // поля класса

    private static String timeoutForPageLoad;
    private static String timeoutForCondition;

    public static Browser currentBrowser;

//    private Browser() {
//        Logger.getInstance().info(String.format(getLoc("loc.browser.ready"), currentBrowser.toString()));
//    }

    public boolean isBrowserAlive() {
        return instance != null;
    }

    public static Browser getInstance() {
        if (instance == null) {
            try {
                driver = DriverFactory.getDriver();
                driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
            } catch (Exception e) {
                Assert.fail("Driver does not instance");
            }
            instance = new Browser();
        }
        return instance;
    }

    public void exit() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance = null;
        }
    }

    public String getTimeoutForCondition() {
        return String.valueOf(DEFAULT_CONDITION_TIMEOUT);
    }

    public String getTimeoutForPageLoad() {
        return String.valueOf(DEFAULT_PAGE_LOAD_TIMEOUT);
    }


    public void waitForPageToLoad() {
        // Logger.getInstance().info("waitForPageToLoad started");
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(getTimeoutForPageLoad()));
        try {
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver d) {
                    if (!(d instanceof JavascriptExecutor)) {
                        return true;
                    }
                    Object result = ((JavascriptExecutor) d)
                            .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                    if (result != null && result instanceof Boolean && (Boolean) result) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            Assert.fail("Page does not Load");
        }
        // Logger.getInstance().info("waitForPageToLoad ended");
    }

    public void windowMaximise() {
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            //A lot of browsers crash here
        }

    }

    public void navigate(final String url) {
        driver.navigate().to(url);
    }


    public WebDriver getDriver() {
        return driver;
    }

    @Deprecated
    public void click(final By selector) {
        new Label(selector).click();
    }

    public String getLocation() {
        return driver.getCurrentUrl();
    }
}
