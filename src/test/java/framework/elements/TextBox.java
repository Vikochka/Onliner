package framework.elements;

import framework.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class TextBox extends BaseElement {

    public TextBox(By by) {
        super(by);
    }

    public TextBox(By by, String name) {
        super(by, name);
    }

    public String getElementType() {
        return getElementType();
    }

    public void sendKeys(final String value) {
        waitForIsElementPresent();
        element.sendKeys(value);
    }
}
