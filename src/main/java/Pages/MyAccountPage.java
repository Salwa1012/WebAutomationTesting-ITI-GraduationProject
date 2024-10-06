package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    private By acc = By.xpath("//*[@id=\"top-links\"]/ul/li[2]");
    private By myAcc = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");

    private By changePassword = By.xpath("//*[@id=\"content\"]/ul[1]/li[2]/a");
    private By newPasswordTxt = By.xpath("//*[@id=\"input-password\"]");
    private By confirmPasswordTxt = By.xpath("//*[@id=\"input-confirm\"]");
    private By ChangePasswordBtn = By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");


    public void OpenChangePasswordPage(){
        click(acc);
        click(myAcc);
        click(changePassword);
    }
    public void ChangePassword(String newpassword, String confirmpassword){
        type(newPasswordTxt,newpassword);
        type(confirmPasswordTxt,confirmpassword);
        click(ChangePasswordBtn);

    }



}
