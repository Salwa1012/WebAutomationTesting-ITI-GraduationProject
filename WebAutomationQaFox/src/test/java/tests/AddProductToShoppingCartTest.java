package tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class AddProductToShoppingCartTest extends TestBase{

    String productName = "iPod Nano";
    String ProductName2 = "Canon EOS 5D";
    String ProductName3 = "Apple Cinema";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ShoppingCartPage cartObject;

    @Test(priority = 1)
    public void UserCanSearchForProduct()
    {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.ProductSearch(productName);
        Assert.assertTrue(detailsObject.getProductNameText().equalsIgnoreCase(productName),
                "The product name displayed on the page does not match the search query.");

        searchObject.Opendetails();
    }

    @Test(priority = 2)
    public void UserCanAddProductToShoppingCart() {

        detailsObject = new ProductDetailsPage(driver);
        cartObject = new ShoppingCartPage(driver);
        detailsObject.AddToCart();
         waitFor(1000);
        String headerText = detailsObject.getHeaderText();
        Assert.assertTrue(headerText.contains(" added"), "Item not added to cart, assertion failed");
        detailsObject.OpenShoppingCart();
        Assert.assertEquals(cartObject.getCartItem(), "iPod Nano", "Item name does not match");
        Assert.assertTrue(cartObject.getTotal().contains("$122.00"), "Price does not match");
    }

    @Test(priority = 3)
    public void UserCanUpdateProductQuantityInShoppingCart() {

        detailsObject = new ProductDetailsPage(driver);
        cartObject = new ShoppingCartPage(driver);
        cartObject.UpdateQuantityInCart("3");
        Assert.assertEquals(cartObject.getCartItem(), "iPod Nano", "Item name does not match");
        Assert.assertTrue(cartObject.getTotal().contains("$366.00"), "Price does not match");
    }

    @Test(priority = 4)
    public void UserCanRemoveProductFromShoppingCart()
    {
        cartObject = new ShoppingCartPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        cartObject.RemoveProductFromCart();
        Assert.assertTrue(cartObject.getEmptyCartMessage().contains("is empty!"), "Message does not match");
    }

    @Test(priority = 5)
    public void UserCanAddProduct2ToCart() {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);


        searchObject.ProductSearch(ProductName2);
        Assert.assertTrue(detailsObject.getProductNameText().equalsIgnoreCase(ProductName2),
                "The product name displayed on the page does not match the search query.");
        searchObject.Opendetails2();
        detailsObject.ChooseFromCanonDropDown();
     //   waitFor(100);
        detailsObject.AddToCart();
        String headerText = detailsObject.getHeaderText();
        Assert.assertTrue(headerText.contains(" added"), "Item not added to cart, assertion failed");
        detailsObject.OpenShoppingCart();
    }


    @Test(priority = 6)
    public void UserCanAddProduct3ToCart() {

        detailsObject.clearSearchInput();
        searchObject.ProductSearch(ProductName3);
        searchObject.Opendetails3();
            searchObject.checkRadioButton();
            searchObject.checkCheckBox();
            searchObject.setText("ValidTest1");
            searchObject.chooseFromDropdown();
            searchObject.setTextBox("ValidTest1");
            try {
                searchObject.uploadFileWithRobot("C:\\Users\\hp\\OneDrive\\Desktop\\MonitorsTest\\File1.txt");
                searchObject.handleAlert();
            } catch (AWTException | InterruptedException e) {
                e.printStackTrace();
                Assert.fail("File upload failed");
            }
            searchObject.handleAlert();
            searchObject.addToCart();
            detailsObject.OpenShoppingCart();
            waitFor(100);


        }


}




