package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends PageBase{


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private By removeFromCart =By.xpath("//button[@class=\"btn btn-danger\"]");
    private By updateCart = By.xpath("//button[@class=\"btn btn-primary\"]");
    private By quantityTxt = By.xpath("//input[contains(@name, 'quantity')]");
    private By totalLbl = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]");
    private By  emptyCart = By.xpath("//*[@id=\"content\"]/p");
    public By itemInCart = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a");
    public By checkoutBtn = By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a");





    public void  RemoveProductFromCart()
    {
        click(removeFromCart);
        click(updateCart);
    }

    public void UpdateQuantityInCart(String quantity) {
        WebElement quantityField = driver.findElement(quantityTxt);
        quantityField.clear();
        quantityField.sendKeys(quantity);
        click(updateCart);
    }
    public String getEmptyCartMessage()
    {

        return driver.findElement(emptyCart).getText();
    }
    public String getCartItem() {

        return driver.findElement(itemInCart).getText();

    }
    public String getTotal() {

        return driver.findElement(totalLbl).getText();

    }

    public void openCheckoutPage()
    {
        click(checkoutBtn);
    }

}
