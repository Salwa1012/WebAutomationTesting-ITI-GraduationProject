package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GiftCertificatePage extends PageBase {

    public GiftCertificatePage(WebDriver driver) {
        super(driver);
    }

    By RecipientName = new By.ByXPath("//input[@name=\"to_name\"]");
    By RecipientEmail = new By.ByXPath("//input[@name=\"to_email\"]");
    By SenderName = new By.ByXPath("//input[@name=\"from_name\"]");
    By SenderEmail = new By.ByXPath("//input[@name=\"from_email\"]");
    By Birthday = new By.ByXPath("(//input[@name=\"voucher_theme_id\"])[1]");
    By Christmas = new By.ByXPath("(//input[@name=\"voucher_theme_id\"])[2]");
    By General = new By.ByXPath("(//input[@name=\"voucher_theme_id\"])[3]");
    By Message = new By.ByXPath("//textarea[@name=\"message\"]");
    By Amount = new By.ByXPath("//input[@name=\"amount\"]");
    By AgreeButton = new By.ByXPath("//input[@type=\"checkbox\"]");
    By Continue = new By.ByXPath("//input[@type=\"submit\"]");
    By ConfirmationMessage = new By.ByXPath("//div[@id=\"content\"]/p[1]");

    public void fillGiftCertificateForm(String recipientName, String recipientEmail, String senderName, String senderEmail, String theme, String message, String amount) {
        type(RecipientName, recipientName);
        type(RecipientEmail, recipientEmail);
        type(SenderName, senderName);
        type(SenderEmail, senderEmail);

        switch (theme.toLowerCase()) {
            case "birthday":
                click(Birthday);
                break;
            case "christmas":
                click(Christmas);
                break;
            case "general":
                click(General);
                break;
            default:
                throw new IllegalArgumentException("Invalid theme: " + theme);
        }

        type(Message, message);
        type(Amount, amount);
    }

    public void clickAgreeButton() {
        click(AgreeButton);
    }

    public void clickContinue() {
        click(Continue);
    }

    public String getConfirmationMessage() {
        return driver.findElement(ConfirmationMessage).getText();
    }
}
