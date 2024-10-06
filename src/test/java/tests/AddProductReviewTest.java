package tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import static org.testng.Assert.assertEquals;

public class AddProductReviewTest extends TestBase {
    String productName = "iPhone";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    HomePage homeObject;
    UserRegisterationPage registerObject;
    LoginPage LoginObject;
    ProductReviewPage reviewObject;
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
    public void RegisteredUserCanReviewProduct()
    {
        detailsObject.openAddReviewPage();
        reviewObject = new ProductReviewPage(driver);
        reviewObject.AddProductReview("Salwa", "TestingReviewTestingReviewTestingReviewTestingReviewTestingReview");


        String expectedMessage = "Thank you for your review. It has been submitted to the webmaster for approval.";
        String actualMessage = reviewObject.getReviewSubmissionMessage();
        assertEquals(expectedMessage, actualMessage);


    }




    @Test(priority =4)
    public void RegisteredUserCanLogout()
    {

        registerObject.userLogout();
    }










}
