package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductReturnPage extends PageBase{


    public ProductReturnPage(WebDriver driver) {
        super(driver);
    }


    private By radioBtn = By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[4]/div/div[5]/label/input");
    private By submitBtn = By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");
    private By returnHeaderTxt = By.xpath("//*[@id=\"content\"]/p[1]");


    public void returnOrder()
    {
        click(radioBtn);
        click(submitBtn);

    }
    public String getProductReturnHeader() {
        return driver.findElement(returnHeaderTxt).getText();
    }

}
