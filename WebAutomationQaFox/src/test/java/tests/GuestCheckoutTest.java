package tests;

import Pages.CheckoutPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuestCheckoutTest extends TestBase{

    CheckoutPage checkoutObject;
    String productName = "HP LP3065";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ShoppingCartPage cartObject;

    @Test(priority = 1)
    public void GuestCanSearchForProduct() {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);

        searchObject.ProductSearch(productName);
        Assert.assertTrue(detailsObject.getProductNameText().equalsIgnoreCase(productName),
                "The product name displayed on the page does not match the search query.");
        searchObject.Opendetails();
    }

    @Test(priority = 2)
    public void GuestCanAddProductToShoppingCart() {
        detailsObject = new ProductDetailsPage(driver);
        cartObject = new ShoppingCartPage(driver);

        detailsObject.AddToCart();
        detailsObject.OpenShoppingCart();
        Assert.assertEquals(cartObject.getCartItem(), productName, "Item name in the cart does not match the expected product.");

        cartObject.openCheckoutPage();
    }

    @Test(priority = 3)
    public void GuestCanCheckOutSuccessfully() {
        checkoutObject = new CheckoutPage(driver);
        checkoutObject.GuestCheckOut("salwa", "abdallah" , "salwapo@gmai.com", "03829" , "iojsiocfj" , "jgajs" , "72563" );
        Assert.assertTrue(checkoutObject.getHeaderText().contains("successfully"), "Checkout Not successful");


    }
}
