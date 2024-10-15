package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By Email = By.id("input-email");
    private By Password = By.id("input-password");
    private By loginBtn = By.xpath("//input[@type=\"submit\"]");
    private By acc = By.xpath("//a[@title=\"My Account\"]");
    private By History = By.cssSelector("a[href='https://tutorialsninja.com/demo/index.php?route=account/order']");

    public void UserLogin(String email , String password){

        type(Email,email );
        type(Password,password);
        click(loginBtn);
    }
    public void InvalidUserLogin(String email){

        type(Email,email );
        click(loginBtn);
    }

    public void OpenHistoryPage ()
    {
        click(acc);
        click(History);
    }

}

