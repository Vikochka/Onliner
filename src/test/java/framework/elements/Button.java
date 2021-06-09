package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement {


    public Button(WebDriver driver, By by) {
        super(driver, by);
    }

    public Button(WebDriver driver, By by, String name) {
        super(driver, by, name);
    }

    public Button(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public void clickButton(){
        click();
    }
}