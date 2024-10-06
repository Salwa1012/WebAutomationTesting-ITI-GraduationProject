package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparePage extends PageBase{

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    private By removeitem1 = By.xpath("//a[contains(@href, \"remove=41\")]");
    private By removeitem2 = By.xpath("//a[contains(@href, \"remove=44\")]");
    public By productNameLocator = By.xpath("//a[contains(@href, \"product_id=41\")]");
    public By productNameLocator2 = By.xpath("//a[contains(@href, \"product_id=44\")]");
    public By header = By.xpath("//h1[text()='Product Comparison']");
    public By modified = By.cssSelector(".alert.alert-success.alert-dismissible");
    public By emptyComparison = By.xpath("//p[contains(text(), 'not chosen')]");


    public String getProductName() {
        return driver.findElement(productNameLocator).getText();


    }
    public String getProductName2() {

        return driver.findElement(productNameLocator2).getText();

    }


    public String getHeader() {

        return driver.findElement(header).getText();

    }

    public void RemoveItemOneFromCompare()
    {
        click(removeitem1);
    }
    public String getComparisonModifiedMessage()
    {

        return driver.findElement(modified).getText();
    }
    public void RemoveItemTwoFromCompare()
    {
        click(removeitem2);
    }

    public String getEmptyComparisonMessage()
    {

        return driver.findElement(emptyComparison).getText();
    }

}
