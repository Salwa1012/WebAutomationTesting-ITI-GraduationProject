package tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisterationPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends TestBase {

    HomePage homeObject;
    UserRegisterationPage registerObject;
    LoginPage LoginObject;
    MyAccountPage myAccountObject;
    Faker faker = new Faker();
    String email;
    String newpassword = "1010";
    String confirmpassword = "1010";
    String firstName = "Salwa";
    String lastName = "Abdallah";
    String pass = "54321";
    String Telephone = "01030883428";

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully() {

        {
            homeObject = new HomePage(driver);
            homeObject.openRegisterationPage();
            registerObject = new UserRegisterationPage(driver);
            email = faker.internet().emailAddress();
            registerObject.userRegistration("Salwa", "Abdallah", email, "01030883428", "54321");
            String expectedMessage = "Your Account Has Been Created!";
            Assert.assertTrue(registerObject.getSuccessMessageText().contains(expectedMessage),
                    "The success message is not displayed or is incorrect.");

        }}


    @Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
    public void RegisteredUserCanChangePassword() {
        myAccountObject = new MyAccountPage(driver);
        myAccountObject.OpenChangePasswordPage();
        myAccountObject.ChangePassword(newpassword, confirmpassword);
        String expectedText = "Success";
        String actualText = driver.getPageSource();
        Assert.assertTrue(actualText.contains(expectedText), "Login was not successful; 'Success' not found.");
    }


    @Test(dependsOnMethods = {"RegisteredUserCanChangePassword"})
    public void RegisteredUserCanLogout()
    {
        registerObject.userLogout();
    }
    @Test(dependsOnMethods = {"RegisteredUserCanLogout"})
    public void RegisteredUserCanLogin(){
        homeObject.openLoginPage();
        LoginObject = new LoginPage(driver);
        LoginObject.UserLogin(email,newpassword);
        String expectedText = "Edit your account information";
        String actualText = driver.getPageSource();
        Assert.assertTrue(actualText.contains(expectedText), "Login was not successful.");
    }
}
