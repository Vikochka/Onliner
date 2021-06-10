package test;

import framework.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.CatalogPage;
import page.MainPage;
import page.TVPage;

public class SearchTest extends BaseTest {


    @Parameters({"manufacturer", "priceTo", "diagonalFrom", "diagonalTo", "resolution"})
    @Test
    public void searchTVTest(String manufacturer, String priceTo, String diagonalFrom, String diagonalTo, String resolution) {
        SoftAssert softAssert = new SoftAssert();

        MainPage mainPage = new MainPage();
        mainPage.navigatePage("Каталог");

//        CatalogPage catalogPage = new CatalogPage();
//        catalogPage.catalogNavigation("Электроника");
//        catalogPage.isListOpened();
//        catalogPage.listTitle("Телевидение", "Телевизоры");
//
//        TVPage tvPage = new TVPage();
//        tvPage.selectManufacturer(manufacturer);
//        tvPage.selectDiagonal(diagonalFrom, diagonalTo);
//        tvPage.selectPrice(priceTo);
//        tvPage.selectResolution(resolution);
//        tvPage.validationManufacturer(manufacturer);
//        tvPage.validationDiagonal(diagonalFrom, diagonalTo);
//        tvPage.validationResolution(resolution);
//        tvPage.validationPrice(priceTo);

        softAssert.assertAll();
    }
}
