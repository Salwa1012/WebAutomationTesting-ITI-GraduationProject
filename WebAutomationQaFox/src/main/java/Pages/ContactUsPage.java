package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends PageBase{


    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    private By fullNameTxt = By.id("input-name");
    private By emailTxt = By.id("input-email");
    private By enquiryTxt = By.id("input-enquiry");
    private By submitBtn = By.xpath("//input[@class='btn btn-primary']");
    private By successMessage = By.xpath("//h1[text()='Contact Us']");

    public void ContactUs(String fullName , String email , String message)
    {

        type(fullNameTxt, fullName);
        type(emailTxt, email);
        type(enquiryTxt, message);
        click(submitBtn);

    }
    public String getSuccessMessageText() {

        return driver.findElement(successMessage).getText();
    }

}
