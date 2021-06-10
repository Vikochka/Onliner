package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static framework.PropertyReader.getIntProperty;

public abstract class BaseElement {
    protected WebElement element;
    protected WebDriver driver;
    private By by;
    private String name;
    private WebDriverWait wait;

    public BaseElement(By by) {
        this.by = by;
        wait = Waiter(driver);
    }

    public BaseElement(By by, String name) {
        this.by = by;
        this.name = name;
        wait = Waiter(driver);
    }


    public BaseElement(WebElement element) {
        this.element = element;
        wait = Waiter(driver);
    }

    public WebDriverWait Waiter(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, getIntProperty("timeoutElement"));
        return null;
    }

    public WebElement getElement() {
        element = driver.findElement(by);
        waitForIsElementPresent();
        return element;
    }

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

    public List<WebElement> getElements() { //for collections
        return driver.findElements(by);
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
        element = getElement();
        element.click();
    }

    public String getText() {
        element = getElement();
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
}