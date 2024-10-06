package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegisterationPage extends PageBase {
    public UserRegisterationPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By FirstName = By.id("input-firstname");
    private By LastName = By.id("input-lastname");
    private By Email = By.id("input-email");
    private By Telephone = By.id("input-telephone");
    private By Password = By.id("input-password");
    private By confirm = By.id("input-confirm");
    private By subscribe = By.cssSelector("input[type*='radio'][name='newsletter'][value='1']");
    private By agree = By.cssSelector("input[type*='checkbox'][name='agree'][value='1']");
    private By Continue = By.cssSelector(".btn.btn-primary");
    public By successMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");
    public By logOut = By.xpath("(//a[text()='Logout'])[1]");
    private By account = By.xpath("//a[span[contains(text(), 'My Account')]]");

    // Action method
    public void userRegistration(String firstName, String lastName, String email, String telephone, String pass) {
        type(FirstName,firstName);
        type(LastName,lastName);
        type(Email,email);
        type(Telephone,telephone);
        type(Password, pass);
        type(confirm, pass);
        click(subscribe);
        click(agree);
        click(Continue);

    }
    public String getSuccessMessageText() {
        return driver.findElement(successMessage).getText();
    }
    public void userLogout()
    {
        click(account);
        click(logOut);
    }
    public void clickAccount()
    {
        click(account);
    }

}
