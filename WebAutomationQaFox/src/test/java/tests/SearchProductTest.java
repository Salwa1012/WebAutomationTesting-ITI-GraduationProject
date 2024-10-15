package tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase{
    String productName = "iPhone";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    @Test
    public void UserCanSearchForProduct()
    {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.ProductSearch(productName);
        Assert.assertTrue(detailsObject.getProductNameText().equalsIgnoreCase(productName),
                "The product name displayed on the page does not match the search query.");

        searchObject.Opendetails();
    }



}
