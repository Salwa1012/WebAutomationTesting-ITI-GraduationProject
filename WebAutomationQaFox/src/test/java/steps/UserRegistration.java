package steps;

import Pages.HomePage;
import Pages.UserRegisterationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import tests.TestBase;
import com.github.javafaker.Faker;

public class UserRegistration extends TestBase {

    HomePage homeObject;
    UserRegisterationPage registerObject;
    Faker faker;
    public UserRegistration() {
        faker = new Faker();
    }

    @Given("the user is on the home page")

    public void the_user_is_on_the_home_page() {
        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
    }

    @When("the user clicks on {string} and selects {string}")
    public void the_user_clicks_on_and_selects(String accountOption, String registerOption) {

        Assert.assertTrue(driver.getCurrentUrl().contains("register"), "User is not on the registration page.");
    }


    @When("user fills in the registration form with email {string}, {string}, {string}, {string}")
    public void user_fills_in_the_registration_form_with(String firstname, String lastname, String telephone, String password) {
        String email = faker.internet().emailAddress();
        registerObject = new UserRegisterationPage(driver);
        registerObject.userRegistration(firstname, lastname, email, telephone, password);
    }

    @Then("the registration should be completed successfully")
    public void the_registration_should_be_completed_successfully() {
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertTrue(registerObject.getSuccessMessageText().contains(expectedMessage),
                "The success message is not displayed or is incorrect.");
    }

    @Then("the user should see the confirmation message")
    public void the_user_should_see_the_confirmation_message() {

        Assert.assertTrue(registerObject.getSuccessMessageText().contains("Your Account Has Been Created!"),
                "Confirmation message not displayed or incorrect.");
        registerObject.userLogout();
    }
}
