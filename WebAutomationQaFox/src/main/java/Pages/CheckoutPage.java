package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends PageBase{


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private By Email = By.id("input-email");
    private By password = By.id("input-password");
    private By loginBtn = By.id("button-login");
    private By continueBtn = By.id("button-payment-address");
    private By continueBtn2 = By.id("button-shipping-address");
    private By continueBtn3 = By.id("button-shipping-method");
    private By agreeBtn = By.xpath("//input[@name=\"agree\"]");
    private By continueBtn4 = By.id("button-payment-method");
    private By confirmBtn = By.id("button-confirm");
    private By Header = By.xpath("//p[text()='Your order has been successfully processed!']");
    private By guestBtn = By.xpath("//input[@type='radio' and @value='guest']");
    private By guestContinueBtn= By.id("button-account");
    private By firstName = By.id("input-payment-firstname");
    private By lastName = By.id("input-payment-lastname");
    private By email = By.id("input-payment-email");
    private By telephone = By.id("input-payment-telephone");
    private By address1 = By.id("input-payment-address-1");
    private By city = By.id("input-payment-city");
    private By postcode = By.id("input-payment-postcode");
    private By country = By.id("input-payment-country");
    private By egypt =  By.xpath("//select/option[@value='63' and text()='Egypt']");
    private By Region = By.id("input-payment-zone");

    private By cairo = By.xpath("//select/option[@value='1011' and text()='Al Qahirah']");
    private By GuestContinueBtn = By.id("button-guest");
    private By secondguestContinueBtb = By.xpath("//input[@value=\"Continue\"]");

    public void login(String email, String pass) {
        type(Email,email);
        type(password, pass);
        click(loginBtn);


    }

    public void RegisteredUserCheckOut()
    {
        click(continueBtn);
        click(continueBtn2);
        click(continueBtn3);
        waitFor(1000);
        click(agreeBtn);
        click(continueBtn4);
        click(confirmBtn);

    }

    public void GuestCheckOut(String firstname , String lastname , String Email, String Teleph , String address , String City , String Post  )
    {

        click(guestBtn);
        click(guestContinueBtn);
        type(firstName, firstname);
        type(lastName,lastname);
        type(email,Email);
        type(telephone,Teleph);
        type(address1,address);
        type(city,City);
        type(postcode,Post);
        click(country);
        click(egypt);
        click(Region);
        click(cairo);
        click(GuestContinueBtn);
        click(continueBtn3);
        waitFor(1000);
        click(agreeBtn);
        click(continueBtn4);
        click(confirmBtn);



    }

    public void RegisteredCheckOut(String firstname , String lastname ,  String address , String City , String Post  )
    {

        type(firstName, firstname);
        type(lastName,lastname);
        type(address1,address);
        type(city,City);
        type(postcode,Post);
        click(country);
        click(egypt);
        click(Region);
        click(cairo);
        click(GuestContinueBtn);
        click(continueBtn3);
        click(agreeBtn);
        click(continueBtn4);
        click(confirmBtn);



    }
    public String getHeaderText() {
        return driver.findElement(Header).getText();

    }



}
