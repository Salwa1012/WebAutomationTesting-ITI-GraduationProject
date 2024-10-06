package tests;

import Pages.ContactUsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase{

    HomePage home;
    ContactUsPage contactPage;

    String email = "salwa@gmail.com";
    String fullName = "First Test";
    String enquiry = "Contact Us Test";



    @Test
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
    }
