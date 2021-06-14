package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox extends BaseElement {


    public Checkbox(By by) {
        super(by);
    }

    public Checkbox(By by, String name) {
        super(by, name);
    }

    public void getElementType() {
        getElementType();
    }

    public void selectCheckbox() {
        getElement();
        moveAndClickByAction();
        isSelected();
    }
}