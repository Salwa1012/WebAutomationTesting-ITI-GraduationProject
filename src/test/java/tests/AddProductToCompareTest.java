package tests;

import Pages.ComparePage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCompareTest extends TestBase {




    String productName = "iMac";
    String productName2 = "MacBook Air";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    HomePage homeObject;
    ComparePage compareObject;



    @Test(priority = 1)
    public void UserCanCompareProducts()
    {
        searchObject = new SearchPage(driver);
        compareObject = new ComparePage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.ProductSearch(productName);
        searchObject.Opendetails();
        detailsObject.AddProductToCompare();
        waitFor(3);
        searchObject.Clearsearch();
        searchObject.ProductSearch(productName2);
        searchObject.Opendetails();
        detailsObject.AddProductToCompare();
        waitFor(3);
        driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=product/compare");
        Assert.assertEquals(compareObject.getProductName(), "iMac", "Product name does not match");
        Assert.assertEquals(compareObject.getProductName2(), "MacBook Air", "Product name does not match");
        Assert.assertEquals(compareObject.getHeader(), "Product Comparison", "Header does not match");


    }
    @Test(priority = 2)
    public void UserCanRemoveItemFromCompare()
    {

        compareObject.RemoveItemOneFromCompare();
        Assert.assertTrue(compareObject.getComparisonModifiedMessage().contains("modified"), "Message does not match");
        compareObject.RemoveItemTwoFromCompare();
        Assert.assertTrue(compareObject.getEmptyComparisonMessage().contains("You have not chosen any products"), "Message does not match");


    }






}
