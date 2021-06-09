package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Label extends BaseElement {

    public Label(WebDriver driver, By by) {
        super(driver, by);
    }

    public Label(WebDriver driver, By by, String name) {
        super(driver, by, name);
    }

    public Label(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public void getLabel(By by,String label){
        getElement();
        click();
    }
}
