package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

public class CatalogPage extends BasePage{
    public static final String CATALOG_NAVIGATION = "//span[contains(@class,'catalog-navigation-classifier__item-title-wrapper')][contains(text(),'%s')]";
    public static final String CATALOG_LIST_XPATH = "//div[@data-id='1']//div[contains(@class,'catalog-navigation-list__aside-list')]";
    public static final String LIST_TITLE_XPATH = "//*[contains(@class,'catalog-navigation-list__aside-title')][contains(text(),'%s')]";
    public static final String LIST_DROPDOWN_XPATH = "//*[contains(@class,'catalog-navigation-list__dropdown-data')]//*[contains(text(),'%s')]";
    public static final String WAIT_FOR_IS_PAGE_OPEN = "//*[contains(@class,'schema-header__title')][contains(text(),'%s')]";
    SoftAssert softAssert = new SoftAssert();

    public CatalogPage(WebDriver driver) {
        super(driver);
    }
    public void catalogNavigation(String catalogNavigation) {
        driver.findElement(By.xpath(String.format(CATALOG_NAVIGATION, catalogNavigation))).click();
    }

    public void listTitle(String listTitle, String listDropdown) {
        driver.findElement(By.xpath(String.format(LIST_TITLE_XPATH, listTitle))).click();
        driver.findElement(By.xpath(String.format(LIST_DROPDOWN_XPATH, listDropdown))).click();
    }

    public void isPageOpened(String page) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(WAIT_FOR_IS_PAGE_OPEN, page))));
        softAssert.assertTrue(true);
    }

    public void isListOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CATALOG_LIST_XPATH)));
        softAssert.assertTrue(true);
    }


}
