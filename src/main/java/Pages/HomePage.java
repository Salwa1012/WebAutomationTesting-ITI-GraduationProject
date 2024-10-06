package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    By createaccountButton = new By.ByXPath("//*[@id=\"top-links\"]/ul/li[2]/a");
    By Register = new By.ByXPath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
    By Login = new By.ByXPath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
    public By currencydrl = By.xpath("//*[@id=\"form-currency\"]/div/button");
    public By ContactUsLink = By.xpath("//a[contains(@href, 'information/contact') and text()='Contact Us']");
    public By Pound = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button");
    public By  priceText = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/ul[2]/li[1]/h2");
    By Desktops = By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a");
    By Mac = By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a");

    By giftbutton = new By.ByXPath("//a[text()=\"Gift Certificates\"]");

    public void openGiftCertificatePage()
    {
        click(giftbutton);
    }
    public void openRegisterationPage()

    {
        click(createaccountButton);
        click(Register);

    }

    public void openLoginPage()
    {
        click(createaccountButton);
        click(Login);
    }

    public void openContactUsPage()
    {
        scrollToBottom();
        click(ContactUsLink);

    }
    public void changeCurrency() {

        waitUntilVisible(currencydrl);
        click(currencydrl);
        click(Pound);
    }



    public void selectDesktopMenu() {
        WebElement desktopsElement = driver.findElement(Desktops);
        WebElement macElement = driver.findElement(Mac);
        action.moveToElement(desktopsElement).moveToElement(macElement).click().build().perform();
    }


}
