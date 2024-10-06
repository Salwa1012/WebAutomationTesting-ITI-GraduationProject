package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage extends PageBase{

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }


    private By HistoryHeader = By.xpath("//h1[text()='Order History']");
    private By ReturnHeader = By.xpath("//h1[text()='Product Returns']");
    By ViewHistory = By.cssSelector("a[href='https://tutorialsninja.com/demo/index.php?route=account/order/info&order_id=10201']");
    private By returnBtn = By.xpath("//a[@data-original-title=\"Return\"]");

    public String getHeaderText() {
        return driver.findElement(HistoryHeader).getText();
    }
    public String getHeaderReturn() {
        return driver.findElement(ReturnHeader).getText();
    }

    public void viewHistory ()
    {
        click(ViewHistory);

    }

    public void returnOrder()
    {
        click(returnBtn);
    }
}
