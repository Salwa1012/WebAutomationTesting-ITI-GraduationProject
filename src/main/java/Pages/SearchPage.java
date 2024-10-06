package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.io.File;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class SearchPage extends PageBase{


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private By searchTextBox = By.xpath("//*[@id=\"search\"]/input");
    private By searchBtn = By.xpath("//*[@id=\"search\"]/span/button");
    private By productLink = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a");
    private By productLink2 = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[1]/a/img");
    private By productLink3 = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[1]/a/img");
    private By components = By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a");
    private By monitors = By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]/a");
    private By item = By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]");
    private By check = By.xpath("//*[@id=\"input-option223\"]/div[1]/label/input");
    private By text = By.xpath("//*[@id=\"input-option208\"]");
    private By dropDown = By.xpath("//*[@id=\"input-option217\"]");
    private By blueColor = By.xpath("//*[@id=\"input-option217\"]/option[3]");
    private By textBox = By.xpath("//*[@id=\"input-option209\"]");
    private By file = By.xpath("//*[@id=\"button-upload222\"]");
    private By add = By.xpath("//*[@id=\"button-cart\"]");
    private By radio = By.xpath("//*[@id=\"input-option218\"]/div/label/input");
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void getMonitor() {
        driver.findElement(components).click();
        driver.findElement(monitors).click();
        js.executeScript("window.scrollBy(0,250)", "");
        waitFor(1000);
        driver.findElement(item).click();
        js.executeScript("window.scrollBy(0,250)", "");
        waitFor(3000);

    }

    public void checkRadioButton (){
        driver.findElement(radio).click();
    }



    public void checkCheckBox (){
        driver.findElement(check).click();
    }



    public void setText(String Text) {
        WebElement textField = driver.findElement(text);
        textField.clear();
        textField.sendKeys(Text);
    }


    public void chooseFromDropdown (){
        driver.findElement(dropDown).click();
        driver.findElement(blueColor).click();

    }


    public void setTextBox(String TextBox) {
        WebElement textField = driver.findElement(textBox);
        textField.clear();
        textField.sendKeys(TextBox);
    }


    public void uploadFileWithRobot(String filePath) throws AWTException, InterruptedException {
        WebElement uploadButton = driver.findElement(By.xpath("//*[@id='button-upload222']"));
        uploadButton.click();


        Thread.sleep(1000);

        Robot robot = new Robot();


        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);


        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(1000);

        handleAlert();


    }




    public void addToCart (){
        driver.findElement(add).click();

    }
    public void handleAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (Exception e) {

            System.out.println("Exception handling alert: " + e.getMessage());

        }

    }




    public void  ProductSearch(String productName)
    {
        type(searchTextBox,productName );
        click(searchBtn);
    }

    public void Opendetails(){
        click(productLink);
    }
    public void Opendetails2(){
        click(productLink2);
    }
    public void Opendetails3(){
        click(productLink3);
    }

    public void Clearsearch() {
        driver.findElement(searchTextBox).clear();
    }



}
