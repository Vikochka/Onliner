package framework;

import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Date;


public class BasePage {
    private String title;
    protected By titleLocator;

    public BasePage(final By locator, final String pageTitle) {
        init(locator, pageTitle);
        assertIsOpen();
    }

    private void init(final By locator, final String pageTitle) {
        titleLocator = locator;
        title = pageTitle;
    }

    public void assertIsOpen() {
        Label elem = new Label(titleLocator, title);
        try {
            elem.waitForIsElementPresent();
        } catch (Throwable e) {
            Assert.fail(title + "does not open");
        }
    }
}
