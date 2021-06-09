package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox extends BaseElement {
    public TextBox(WebDriver driver, By by) {
        super(driver, by);
    }

    public TextBox(WebDriver driver, By by, String name) {
        super(driver, by, name);
    }

    public TextBox(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public void textBox(String sendKeys){
        sendKeys(sendKeys);
    }
}
