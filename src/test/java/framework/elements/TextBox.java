package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox extends BaseElement {
    public TextBox(By by) {
        super(by);
    }

    public TextBox(By by, String name) {
        super(by, name);
    }

    public void textBox(String sendKeys) {
        sendKeys(sendKeys);
    }

    public void setText(final String value) {
        waitForIsElementPresent();
        element.clear();
        textBox(value);
    }

    public void getElementType() {
        getElementType();
    }

    public String getValue() {
        waitForIsElementPresent();
        return element.getAttribute("value");
    }
}
