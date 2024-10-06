package tests;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase{

    HomePage homeObject;
    ProductDetailsPage detailsObject;
    String productName = "iPhone";
    SearchPage searchObject;



    @Test(priority = 1)
    public void UserCanChangeCurrency()
    {
        homeObject = new HomePage(driver);
        homeObject.changeCurrency();
        detailsObject = new ProductDetailsPage(driver);
    }
    @Test(priority = 2)
    public void UserCanSearchForProduct()
    {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.ProductSearch(productName);
        Assert.assertTrue(detailsObject.getProductNameText().equalsIgnoreCase(productName),
                "The product name displayed on the page does not match the search query.");
        searchObject.Opendetails();
        String priceText = driver.findElement(homeObject.priceText).getText();
        Assert.assertTrue(priceText.contains("£"), "Expected to find '£Pound Sterling' in the product price label but found: " + priceText);


    }
}
