package tests;

import Pages.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends TestBase{

    HomePage HomeObject;
    LoginPage LoginObject;
    CheckoutPage checkoutObject;
    String productName = "HP LP3065";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ShoppingCartPage cartObject;
    @Test(priority = 1)
    public void RegisteredUserCanLogin() {


        HomeObject = new HomePage(driver);
        LoginObject = new LoginPage(driver);
        HomeObject.openLoginPage();
        LoginObject.UserLogin("salwaabdallah2412@gmail.com", "1234");
        String expectedText = "Edit your account information";
        String actualText = driver.getPageSource();
        Assert.assertTrue(actualText.contains(expectedText), "Login was not successful.");
    }



    @Test(priority = 2)
    public void UserCanSearchForProduct() {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);

        searchObject.ProductSearch(productName);
        Assert.assertTrue(detailsObject.getProductNameText().equalsIgnoreCase(productName),
                "The product name displayed on the page does not match the search query.");
        searchObject.Opendetails();
    }

    @Test(priority = 3)
    public void UserCanAddProductToShoppingCart() {
        detailsObject = new ProductDetailsPage(driver);
        cartObject = new ShoppingCartPage(driver);

        detailsObject.AddToCart();
        detailsObject.OpenShoppingCart();
        Assert.assertEquals(cartObject.getCartItem(), productName, "Item name in the cart does not match the expected product.");

        cartObject.openCheckoutPage();
    }



    @Test(priority = 5)
    public void RegisteredUserCanCheckOutSuccessfully() {
        checkoutObject = new CheckoutPage(driver);
        checkoutObject.RegisteredUserCheckOut();
        Assert.assertTrue(checkoutObject.getHeaderText().contains("successfully"), "Checkout Not successful");

    }

}
