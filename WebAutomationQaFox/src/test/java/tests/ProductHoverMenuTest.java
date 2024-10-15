package tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductHoverMenuTest extends TestBase{
HomePage homeObject;

    @Test
    public void UserCanSelectSubCategoryFromMainMenu() {
        homeObject = new HomePage(driver);
        homeObject.selectDesktopMenu();


        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Mac"), "The page does not contain the text 'Mac'.");


    }




}
