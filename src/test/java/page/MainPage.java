package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

public class MainPage extends BasePage {

    public static final String MAIN_MENU_XPATH = "//span[contains(@class,'b-main-navigation__text')][contains(text(),'%s')]";
    public static final String WAIT_FOR_IS_PAGE_OPEN_XPATH = "//h1[contains(@class,'catalog-navigation__title')][contains(text(),'%s')] ";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        driver.get(URL);
    }

    public void navigatePage(String label) {
        driver.findElement(By.xpath(String.format(MAIN_MENU_XPATH, label))).click();
    }
    public void isPageOpen(String label) {
        SoftAssert softAssert = new SoftAssert();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(WAIT_FOR_IS_PAGE_OPEN_XPATH, label))));
        softAssert.assertTrue(true);
    }

}