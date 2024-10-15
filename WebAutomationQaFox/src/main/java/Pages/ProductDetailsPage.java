package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends PageBase{

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    public By addReviewLink = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[3]/p/a[2]");
    public By productName = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a");
    public By productPricelbl = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/ul[2]/li[1]/h2");
    public By addToWishListBtn = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]");
    private By addToCompareBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[2]");
    private By addToCartBtn = By.xpath("//*[@id=\"button-cart\"]");
    private By shoppingCartPage = By.xpath("//*[@id=\"product-product\"]/div[1]/a[2]");
    private By canon = By.xpath("//*[@id=\"input-option226\"]");
    private String headerText = "//*[@id=\"product-product\"]/div[1]";
    private By search = By.xpath("//*[@id=\"search\"]/input");
    public void clearSearchInput() {
        WebElement searchInput = driver.findElement(search);
        searchInput.clear();
    }

    public String getProductNameText() {
        return driver.findElement(productName).getText();

    }
    public void openAddReviewPage()
    {

        click(addReviewLink);
    }


    public void AddProductToWishList()
    {

        click(addToWishListBtn);
    }

    public void AddProductToCompare()
    {
        click(addToCompareBtn);
    }

    public void AddToCart(){
        click(addToCartBtn);
    }

    public void OpenShoppingCart(){
        click(shoppingCartPage);
    }

    public void ChooseFromCanonDropDown(){
        click(canon);

    }

    public String getPageText() {
        return driver.findElement(By.tagName("body")).getText();
    }
    public String getHeaderText() {
        return driver.findElement(By.xpath(headerText)).getText();
    }


}
