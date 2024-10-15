package tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
public class AddProductToWishListTest extends TestBase{

    String productName = "iPhone";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    HomePage homeObject;
    UserRegisterationPage registerObject;
    LoginPage LoginObject;
    ProductReviewPage reviewObject;
    WishlistPage wishlistObject;
    Faker faker = new Faker();
    String email;
    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject = new UserRegisterationPage(driver);

        email = faker.internet().emailAddress();
        registerObject.userRegistration("Salwa", "Abdallah", email, "01030883428", "54321");
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertTrue(registerObject.getSuccessMessageText().contains(expectedMessage),
                "The success message is not displayed or is incorrect.");

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
    }


    @Test(priority = 3)
    public void UserCanAddProductToWishList(){
        detailsObject = new ProductDetailsPage(driver);
        detailsObject.AddProductToWishList();
        driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/wishlist");
        wishlistObject = new WishlistPage(driver);
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("My Wish List"), "The page does not contain the text 'My Wish List'.");
        waitFor(2000);
    }
    @Test(priority = 4)
    public void UserCanRemoveProductFromWishList(){

        wishlistObject = new WishlistPage(driver);
        wishlistObject.RemoveProductFromWishList();
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Your wish list is empty"), "The page does not contain the text 'Your wish list is empty.");
    }



    @Test(priority =5)
    public void RegisteredUserCanLogout()
    {

        registerObject.userLogout();
    }



}
