package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TVPage extends BasePage {
    public static final String CHECKBOX_XPATH = "//ul[@class='schema-filter__list']//label[contains(@class,'schema-filter__checkbox-item')]//span[contains(@class,'schema-filter__checkbox-text')][text()='%s'] ";
    public static final String DIAGONAL_FROM_XPATH = "//div[contains(@class,'schema-filter__label')]/..//*[@class='schema-filter-control schema-filter-control_select']//select[contains(@data-bind,'value: facet.value.from')]";
    public static final String DIAGONAL_TO_XPATH = "//div[contains(@class,'schema-filter__label')]/..//*[@class='schema-filter-control schema-filter-control_select']//select[contains(@data-bind,'value: facet.value.to')]";
    public static final String SELECT_PRICE_TO_XPATH = "//div[contains(@class,'schema-filter__label')]/..//*[@class='schema-filter__facet']//input[contains(@placeholder,'до')]";
    public static final String TITLE_CHECK_XPATH = "//div[@class='schema-product__title']//span[contains(text(),'%s')]";
    public static final String RESOLUTION_CHECK_XPATH = "//div[@class='schema-product__description']//span[contains(text(),'%s')] ";
    public static final String CHECK_PRICE_TO_XPATH = "//div[@class='schema-product__group']//div[contains(@class,'schema-product__price')]//span[contains(@data-bind,'format.minPrice')]";
    public static final By BLOCK_CSS = By.cssSelector(".schema-product__group");
    public static final By DESCRIPTION_CSS = By.cssSelector(".schema-product__description");

    SoftAssert softAssert = new SoftAssert();

    public TVPage() {
        super();
    }

    public void selectManufacturer(String manufacturer) {
        WebElement element = driver.findElement(By.xpath(String.format(CHECKBOX_XPATH, manufacturer)));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().perform();
    }

    public void selectResolution(String resolution) {
        WebElement element = driver.findElement(By.xpath(String.format(CHECKBOX_XPATH, resolution)));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().perform();
    }

    public void selectDiagonal(String from, String to) {
        driver.findElement(By.xpath(DIAGONAL_FROM_XPATH)).sendKeys(from);
        driver.findElement(By.xpath(DIAGONAL_TO_XPATH)).sendKeys(to);
    }

    public void selectPrice(String price) {
        driver.findElement(By.xpath(SELECT_PRICE_TO_XPATH)).sendKeys(price);
    }

    public void validationManufacturer(String title) {
        String[] manufacturer;
        String value = driver.findElement(By.xpath(String.format(TITLE_CHECK_XPATH, title))).getText();
        manufacturer = value.split(" ");
        for (int i = 0; i < manufacturer.length; i++) {
            if (manufacturer[i].equals(title)) {
                softAssert.assertTrue(true);
            }
        }
    }

    public void validationResolution(String resolution) {
        String[] description;
        String value = driver.findElement(By.xpath(String.format(RESOLUTION_CHECK_XPATH, resolution))).getText();
        description = value.split(" ");
        for (int i = 0; i < description.length; i++) {
            if (description[i].equals(resolution)) {
                softAssert.assertTrue(true);
            }
        }
    }

    public void validationDiagonal(int diagonalFrom, int diagonalTo) {
        List<WebElement> block = driver.findElements(BLOCK_CSS);
        String value = driver.findElement(DESCRIPTION_CSS).getText();
        for (int i = 1; i <= block.size(); i++) {
            String[] description;
            description = value.split("\"");
            for (int j = 0; j < description.length; j++) {
                double convert = Double.parseDouble(description[0]);
                if (convert >= diagonalFrom && convert <= diagonalTo) {
                    softAssert.assertTrue(true);
                }
            }
        }
    }

    public void validationPrice(int priceTo) {
        List<WebElement> block = driver.findElements(BLOCK_CSS);
        String priceBlock = driver.findElement(By.xpath(CHECK_PRICE_TO_XPATH)).getText();
        for (int i = 1; i <= block.size(); i++) {
            String[] price;
            price = priceBlock.split(",");
            for (int j = 0; j < price.length; j++) {
                double convert = Double.parseDouble(price[0]);
                if (convert < priceTo) ;
                softAssert.assertTrue(true);
            }
        }
    }
}
