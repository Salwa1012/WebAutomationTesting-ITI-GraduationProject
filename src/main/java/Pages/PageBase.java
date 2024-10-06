package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public JavascriptExecutor jse;
    public Select select;
    public Actions action;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait time of 10 seconds
        this.jse = (JavascriptExecutor) driver;
    }
    protected void waitUntilVisible(By locator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    protected void type(By locator, String text) {

        driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {

        driver.findElement(locator).click();
    }

    protected void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void scrollToBottom() {


        jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
