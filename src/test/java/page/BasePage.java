package page;

import framework.DriverFactory;
import framework.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.utils.PropertyReader;


public class BasePage  {
    public WebDriver driver;
    Waiters waiters;


    protected boolean isPageOpened(By by) {
        return waiters.waitForVisibility(by).isDisplayed();
    }
}
