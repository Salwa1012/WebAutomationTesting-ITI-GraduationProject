package steps;

import Pages.HomePage;
import Pages.GiftCertificatePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import tests.TestBase;

public class GiftCertificate extends TestBase {

    HomePage homeObject;
    GiftCertificatePage giftCertificateObject;

    @Given("the user is on the \"Gift Certificate\" page")
    public void the_user_is_on_the_gift_certificate_page() {
        homeObject = new HomePage(driver);
        homeObject.openGiftCertificatePage();
    }

    @When("the user fills in the gift certificate form with recipient {string}, {string}, sender {string}, {string}, theme {string}, message {string}, and amount {string}")
    public void the_user_fills_in_the_gift_certificate_form(String recipientName, String recipientEmail, String senderName, String senderEmail, String theme, String message, String amount) {
        giftCertificateObject = new GiftCertificatePage(driver);
        giftCertificateObject.fillGiftCertificateForm(recipientName, recipientEmail, senderName, senderEmail, theme, message, amount);
    }

    @When("the user agrees that gift certificates are non-refundable")
    public void the_user_agrees_that_gift_certificates_are_non_refundable() {
        giftCertificateObject.clickAgreeButton();
    }

    @When("the user clicks the \"Continue\" button")
    public void the_user_clicks_the_continue_button() {
        giftCertificateObject.clickContinue();
    }

    @Then("the gift certificate purchase should be completed successfully")
    public void the_gift_certificate_purchase_should_be_completed_successfully() {
        String expectedMessage = "Thank you for purchasing a gift certificate! Once you have completed your order your gift certificate recipient will be sent an e-mail with details how to redeem their gift certificate.";
        Assert.assertTrue(giftCertificateObject.getConfirmationMessage().contains(expectedMessage),
                "The confirmation message is not displayed or incorrect.");
    }


}
