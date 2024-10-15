package tests;

import Pages.CheckoutPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturningUserCheckoutTest extends TestBase {

    CheckoutPage checkoutObject;
    String productName = "HP LP3065";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ShoppingCartPage cartObject;

    @Test(priority = 1)
    public void UserCanSearchForProduct() {
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
        detailsObject.OpenShoppingCart();
        Assert.assertEquals(cartObject.getCartItem(), productName, "Item name in the cart does not match the expected product.");

        cartObject.openCheckoutPage();
    }

    @Test(priority = 3)
    public void RegisteredUserCanCheckOutSuccessfully() {
        checkoutObject = new CheckoutPage(driver);

        checkoutObject.login("salwaabdallah2412@gmail.com", "1234");
        checkoutObject.RegisteredUserCheckOut();
        Assert.assertTrue(checkoutObject.getHeaderText().contains("successfully"), "Checkout Not successful");

    }
}
