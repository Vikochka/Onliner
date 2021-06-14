package framework.elements;

import framework.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static framework.PropertyReader.getIntProperty;

public abstract class BaseElement {
    protected WebElement element;
    protected WebDriver driver;
    private By by;
    private String name;
    private WebDriverWait wait;
    private static final int TIMEOUT_WAIT_0 = 0;

    public WebElement getElement() {
        waitForIsElementPresent();
        return element;
    }

    public BaseElement(By by) {
        this.by = by;
    }

    public BaseElement(By by, String name) {
        this.by = by;
        this.name = name;
    }

    protected abstract void getElementType();

    public void waitForIsElementPresent() {
        waitForVisibility(by);
        if (!element.isDisplayed()) {
            Assert.fail("Element do not found");
        }
    }

    public WebElement waitForClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForVisibility(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.fail("Element do not found");
    }

    public void sendKeys(String sendKeys) {
        getElement().sendKeys(sendKeys);
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public boolean isDisplayed() {
        waitForIsElementPresent();
        return element.isDisplayed();
    }

    public void click() {
        waitForClickable(by);
        element.click();
    }

    public String getText() {
        waitForIsElementPresent();
        return element.getText();
    }

    public void moveAndClickByAction() {
        waitForClickable(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement()).build().perform();
        actions.click(getElement()).build().perform();
    }

    public void moveToElement() {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public boolean isPresent() {
        return isPresent(TIMEOUT_WAIT_0);
    }

    public boolean isPresent(int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeout);
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(TIMEOUT_WAIT_0, TimeUnit.SECONDS);
        try {
            wait.until((ExpectedCondition<Boolean>)  new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver driver) {
                    try {
                        List<WebElement> list = driver.findElements(by);
                        for (WebElement el : list) {
                            if (el instanceof WebElement && el.isDisplayed()) {
                                element = (WebElement) el;
                                return element.isDisplayed();
                            }
                        }
                        element = (WebElement) driver.findElement(by);
                    } catch (Exception e) {
                        return false;
                    }
                    return element.isDisplayed();
                }
            });
        } catch (Exception e) {
            return false;
        }
        try {
            DriverFactory.getDriver().manage().timeouts().implicitlyWait(getIntProperty("timeoutElement"), TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (Exception e) {
            Assert.fail("Element does not appeared");
        }
        return false;
    }
}