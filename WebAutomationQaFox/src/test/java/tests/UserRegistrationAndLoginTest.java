package tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;


public class UserRegistrationAndLoginTest extends TestBase {
    HomePage homeObject;
    UserRegisterationPage registerObject;
    LoginPage LoginObject;
    Faker faker = new Faker();
    String email;


    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject = new UserRegisterationPage(driver);


        email = faker.internet().emailAddress();

        registerObject.userRegistration("Salwa", "Abdallah", email, "01030883428", "54321");
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertTrue(registerObject.getSuccessMessageText().contains(expectedMessage),
                "The success message is not displayed or is incorrect.");
    }

    @Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
    public void RegisteredUserCanLogout() {
        registerObject.userLogout();
    }
    @Test(dependsOnMethods = {"RegisteredUserCanLogout"})
    public void RegisteredUserCantLoginWithoutPassword() {
        homeObject.openLoginPage();
        LoginObject = new LoginPage(driver);
        LoginObject.InvalidUserLogin(email);
        String expectedText = "Warning: No match for E-Mail Address and/or Password.";
        String actualText = driver.getPageSource();
        Assert.assertTrue(actualText.contains(expectedText), "Failed, User can login without password!");

    }
    @Test(dependsOnMethods = {"RegisteredUserCantLoginWithoutPassword"})
    public void RegisteredUserCanLogin() {
        homeObject.openLoginPage();
        LoginObject = new LoginPage(driver);
        LoginObject.UserLogin(email, "54321");
        String expectedText = "Edit your account information";
        String actualText = driver.getPageSource();
        Assert.assertTrue(actualText.contains(expectedText), "Login was not successful.");
        registerObject.userLogout();

    }



}
