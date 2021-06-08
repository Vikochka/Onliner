package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utills.PropertyReader;


public class BasePage {
    public WebDriver driver;
    PropertyReader propertyReader =new PropertyReader();
    public String URL =propertyReader.getProperty("URL");
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,propertyReader.getIntProperty("timeout"));
    }
}
