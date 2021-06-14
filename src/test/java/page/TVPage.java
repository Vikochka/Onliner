package page;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Checkbox;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static framework.PropertyReader.getIntProperty;

public class TVPage extends BasePage {
    public static final String CHECKBOX_XPATH = "//ul[@class='schema-filter__list']//label[contains(@class,'schema-filter__checkbox-item')]//span[contains(@class,'schema-filter__checkbox-text')][text()='%s'] ";
    private TextBox DIAGONAL_FROM = new TextBox(By.xpath("//div[contains(@class,'schema-filter__label')]/..//*[@class='schema-filter-control schema-filter-control_select']//select[contains(@data-bind,'value: facet.value.from')]"));
    private TextBox DIAGONAL_TO = new TextBox(By.xpath("//div[contains(@class,'schema-filter__label')]/..//*[@class='schema-filter-control schema-filter-control_select']//select[contains(@data-bind,'value: facet.value.to')]"));
    private TextBox SELECT_PRICE_TO = new TextBox(By.xpath("//div[contains(@class,'schema-filter__label')]/..//*[@class='schema-filter__facet']//input[contains(@placeholder,'до')]"));
    private static final String TITLE_CHECK_XPATH = "//div[@class='schema-product__title']//span[contains(text(),'%s')]";
    public static final String RESOLUTION_CHECK_XPATH = "//div[@class='schema-product__description']//span[contains(text(),'%s')] ";
    public static final String CHECK_PRICE_TO_XPATH = "//div[@class='schema-product__group']//div[contains(@class,'schema-product__price')]//span[contains(@data-bind,'format.minPrice')]";
    public static final By BLOCK_CSS = By.cssSelector(".schema-product__group");
    public static final By DESCRIPTION_CSS = By.cssSelector(".schema-product__description");
    private static final String HEADER_TITLE = "//h1[contains(@class,'schema-header__title')][contains(text(),'%s')]";
    SoftAssert softAssert;

    public TVPage(String pageTitle) {
        super(By.xpath(String.format(HEADER_TITLE, pageTitle)), pageTitle);

    }

    public void selectManufacturer(String manufacturer) {
        Checkbox manufactor = new Checkbox(By.xpath(String.format(CHECKBOX_XPATH, manufacturer)));
        manufactor.click();
        manufactor.isSelected();
    }

    public void selectResolution(String resolution) {
        Checkbox selectResolution = new Checkbox(By.xpath(String.format(CHECKBOX_XPATH, resolution)));
        //  WebDriverWait wait = new WebDriverWait(driver,getIntProperty("timeoutElement"));
        selectResolution.moveAndClickByAction();
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).perform();
//        actions.click().perform();
    }

    public void selectDiagonal(String from, String to) {
        DIAGONAL_FROM.sendKeys(from);
        DIAGONAL_TO.sendKeys(to);
    }

    public void selectPrice(String price) {
        SELECT_PRICE_TO.sendKeys(price);
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

//    public void validationResolution(String resolution) {
//        String[] description;
//        String value = driver.findElement(By.xpath(String.format(RESOLUTION_CHECK_XPATH, resolution))).getText();
//        description = value.split(" ");
//        for (int i = 0; i < description.length; i++) {
//            if (description[i].equals(resolution)) {
//                softAssert.assertTrue(true);
//            }
//        }
//    }

//    public void validationDiagonal(String diagonalFrom, String diagonalTo) {
//        List<WebElement> block = driver.findElements(BLOCK_CSS);
//        String value = driver.findElement(DESCRIPTION_CSS).getText();
//        for (int i = 1; i <= block.size(); i++) {
//            String[] description;
//            description = value.split("\"");
//            int intDiagonalFrom = Integer.parseInt(diagonalFrom);
//            int intDiagonalTo = Integer.parseInt(diagonalTo);
//            for (int j = 0; j < description.length; j++) {
//                double convert = Double.parseDouble(description[0]);
//                if (convert >= intDiagonalFrom && convert <= intDiagonalTo) {
//                    softAssert.assertTrue(true);
//                }
//            }
//        }
//    }
//
//    public void validationPrice(String priceTo) {
//        List<WebElement> block = driver.findElements(BLOCK_CSS);
//        String priceBlock = driver.findElement(By.xpath(CHECK_PRICE_TO_XPATH)).getText();
//        for (int i = 1; i <= block.size(); i++) {
//            String[] price;
//            price = priceBlock.split(",");
//            for (int j = 0; j < price.length; j++) {
//                double convert = Double.parseDouble(price[0]);
//                int intPriceTo = Integer.parseInt(priceTo);
//                if (convert < intPriceTo) ;
//                softAssert.assertTrue(true);
//            }
//        }
//    }
}
