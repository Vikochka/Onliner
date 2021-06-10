package page;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public static final String MAIN_MENU_XPATH = "//span[contains(@class,'b-main-navigation__text')][contains(text(),'%s')]";
    private static String MAIN_LABEL="//a[contains(@class,'footer-3-links all-news-link')]";

    public MainPage() {
        super(By.xpath(MAIN_LABEL),"Main page");
    }

    public void navigatePage(String label) {
     //   driver.findElement(By.xpath(String.format(MAIN_MENU_XPATH, label))).click();
    }

}