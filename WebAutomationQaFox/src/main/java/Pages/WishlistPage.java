package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends PageBase{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }



    private By removefromWishList = By.cssSelector(".btn.btn-danger");





    public void RemoveProductFromWishList()
    {
        click(removefromWishList);
    }

}
