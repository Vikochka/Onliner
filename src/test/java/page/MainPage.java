package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public static final String MAIN_MENU_XPATH = "//span[contains(@class,'b-main-navigation__text')][contains(text(),'%s')]";
    private By MAIN_LABEL=By.xpath("//a[contains(@class,'footer-3-links all-news-link')]");

    public MainPage() {
        super();
    }


    public void navigatePage(String label) {
        driver.findElement(By.xpath(String.format(MAIN_MENU_XPATH, label))).click();
    }

    @Override
    public boolean isPageOpened(By by) {
        return super.isPageOpened(MAIN_LABEL);
    }
}