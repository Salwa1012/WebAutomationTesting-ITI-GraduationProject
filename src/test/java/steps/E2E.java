package steps;

import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import tests.TestBase;

public class E2E extends TestBase {
    HomePage homeObject;
    LoginPage LoginObject;
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    CheckoutPage checkoutObject;
    ShoppingCartPage cartObject;
    String productName = "HP LP3065";
    UserRegisterationPage registerObject;

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        homeObject = new HomePage(driver);
        homeObject.openLoginPage();
        LoginObject = new LoginPage(driver);
        LoginObject.UserLogin("salwaabdallah1012@gmail.com", "0987");
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String productName) {
        searchObject = new SearchPage(driver);
        searchObject.ProductSearch(productName);
    }

    @Then("the user should see search results for {string}")
    public void the_user_should_see_search_results_for(String productName) {
        detailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(detailsObject.getProductNameText().equalsIgnoreCase(productName),
                "The product name displayed does not match the search results.");
    }

    @When("the user selects the item from the search results")
    public void the_user_selects_the_item_from_the_search_results() {
        searchObject.Opendetails();
    }

    @When("the user adds the item to the cart")
    public void the_user_adds_the_item_to_the_cart() {
        detailsObject.AddToCart();
        detailsObject.OpenShoppingCart();
        cartObject = new ShoppingCartPage(driver);
        Assert.assertEquals(cartObject.getCartItem(), productName, "Item name in the cart does not match the expected product.");
    }

    @When("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {
        cartObject.openCheckoutPage();
        checkoutObject = new CheckoutPage(driver);
        checkoutObject.RegisteredUserCheckOut();
    }

    @Then("the purchase should be completed successfully")
    public void the_purchase_should_be_completed_successfully() {
        Assert.assertTrue(checkoutObject.getHeaderText().contains("successfully"), "Checkout not successful");
    }

    @Then("the user should see a confirmation message")
    public void the_user_should_see_confirmation_message() {
       registerObject = new UserRegisterationPage(driver);
        Assert.assertTrue(checkoutObject.getHeaderText().contains("successfully"), "Confirmation message was not displayed.");
        registerObject.userLogout();
    }


}
