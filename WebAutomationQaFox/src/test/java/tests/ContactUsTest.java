package tests;

import Pages.ContactUsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase{

    HomePage home;
    ContactUsPage contactPage;

    String email = "salwa@gmail.com";
    String InvalidEmail = "salwagmail.com";
    String fullName = "First Test";
    String enquiry = "Contact Us Test";
    String InvalidEnquiry = "Invalid";
    String InvalidName = "000";

    @Test(priority = 1)
    public void UserCanUseContactUs(){
        home = new HomePage(driver);
        home.openContactUsPage();
        contactPage = new ContactUsPage(driver);
        contactPage.ContactUs(fullName, email , enquiry);
        String actualMessage = contactPage.getSuccessMessageText();
        String expectedMessage = "Contact Us";


        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected message to contain: " + expectedMessage + " but found: " + actualMessage);
    }
    @Test(priority = 2)
    public void UserEntersInvalidNameInEnquiry(){
        home = new HomePage(driver);
        home.openContactUsPage();
        contactPage = new ContactUsPage(driver);
        contactPage.ContactUs(InvalidName, email , enquiry);
        String actualMessage = contactPage.getSuccessMessageText();
        String expectedMessage = "Contact Us";


        Assert.assertFalse(actualMessage.contains(expectedMessage),
                "User can enter invalid name in enquiry contact form ");
    }
    @Test(priority = 3)
    public void UserEntersInvalidEmailInEnquiry() {
        home = new HomePage(driver);
        home.openContactUsPage();
        contactPage = new ContactUsPage(driver);
        contactPage.ContactUs(fullName, InvalidEmail, enquiry);
        String pageSource = driver.getPageSource();
        String expectedMessage = "E-Mail Address does not appear to be valid!";
        Assert.assertTrue(pageSource.contains(expectedMessage),
                "User can use invalid email in enquiry");
    }


    @Test(priority = 4)
    public void UserEntersInvalidEnquiry() {
        home = new HomePage(driver);
        home.openContactUsPage();
        contactPage = new ContactUsPage(driver);
        contactPage.ContactUs(fullName, email, InvalidEnquiry);
        waitFor(1000);
        String pageSource = driver.getPageSource();
        String expectedErrorMessage = "Enquiry must be between 10 and 3000 characters!";

        Assert.assertTrue(pageSource.contains(expectedErrorMessage),
                "Expected error message to be displayed for enquiry less than 10 characters");
    }







}