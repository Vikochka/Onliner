package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.CatalogPage;
import page.MainPage;
import page.TVPage;

public class SearchTest extends BaseTest {
    MainPage mainPage;
    CatalogPage catalogPage;
    TVPage tvPage;

    @Parameters({"manufacturer", "priceTo", "diagonalFrom", "diagonalTo", "resolution"})
    @Test
    public void searchTVTest(String manufacturer,String priceTo,String diagonalFrom,String diagonalTo,String resolution) {
        SoftAssert softAssert = new SoftAssert();
        mainPage = new MainPage(driver);
        mainPage.navigateMainPage();
        mainPage.navigatePage("Каталог");
        mainPage.isPageOpen("Каталог");
        catalogPage = new CatalogPage(driver);
        catalogPage.catalogNavigation("Электроника");
        catalogPage.isListOpened();
        catalogPage.listTitle("Телевидение", "Телевизоры");
        catalogPage.isPageOpened("Телевизоры");
        tvPage = new TVPage(driver);
        tvPage.selectManufacturer(manufacturer);
        tvPage.selectDiagonal(diagonalFrom, diagonalTo);
        tvPage.selectPrice(priceTo);
        tvPage.selectResolution(resolution);
        tvPage.validationManufacturer("Samsung");
        tvPage.validationDiagonal(40, 50);
        tvPage.validationResolution("1920x1080 (Full HD)");
        tvPage.validationPrice(1000);
        softAssert.assertAll();
        softAssert.assertAll();
    }
}
