package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Label extends BaseElement {


    public Label(By by) {
        super(by);
    }

    public Label(By by, String name) {
        super(by, name);
    }

    public Label(WebElement element) {
        super(element);
    }

    public void getLabel(){
        getElement();
        click();
    }
}
