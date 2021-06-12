package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Button extends BaseElement {


    public Button(By by) {
        super(by);
    }

    public Button(By by, String name) {
        super(by, name);
    }

    protected Button(String stringLocator, String nameOfElement) {
        super(stringLocator, nameOfElement);
    }

    public void clickButton(){
        click();
    }
}