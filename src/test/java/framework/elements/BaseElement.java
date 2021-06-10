package framework.elements;

import framework.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public abstract class BaseElement {
    protected WebElement element;
    protected WebDriver driver;
    private By by;
    private String name;
    private Waiters waiters;



    public BaseElement(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
        waiters = new Waiters(driver);
    }

    public BaseElement(WebDriver driver, By by, String name) {
        this.driver = driver;
        this.by = by;
        this.name = name;
        waiters = new Waiters(driver);
    }

    public BaseElement(WebDriver driver, WebElement element) {
        this.element = element;
        this.driver = driver;
        waiters = new Waiters(driver);
    }

    public WebElement getElement() { //find element
        element =driver.findElement(by);
        return element;
    }

    public List<WebElement> getElements() { //for collections
        return driver.findElements(by);
    }

    public void sendKeys(String sendKeys){
        getElement().sendKeys(sendKeys);
    }

    public boolean isSelected() {
        return element.isSelected();
    }
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public void click() {
        waiters.waitForVisibility(by);
        element = getElement();
        element.click();
    }

    public String getText() {
        element = getElement();
        return element.getText();
    }

    public void moveAndClickByAction() {
        waiters.waitForClickable(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement()).build().perform();
        actions.click(getElement()).build().perform();
    }

    public void moveToElement() {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}