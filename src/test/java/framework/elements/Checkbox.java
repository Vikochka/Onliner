package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox extends BaseElement {


    public Checkbox(WebDriver driver, By by) {
        super(driver, by);
    }

    public Checkbox(WebDriver driver, By by, String name) {
        super(driver, by, name);
    }

    public Checkbox(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public void selectCheckbox() {
        getElement();
        moveAndClickByAction();
        isSelected();
    }
}