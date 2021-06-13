package framework.elements;

import org.openqa.selenium.By;

public abstract class Checkbox extends BaseElement{

    public Checkbox(By by) {
        super(by);
    }

    public Checkbox(By by, String name) {
        super(by, name);
    }


    public void selectCheckbox() {
        getElement();
        moveAndClickByAction();
        isSelected();
    }
}