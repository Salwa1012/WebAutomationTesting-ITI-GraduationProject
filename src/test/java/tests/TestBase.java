package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName)
    {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browserName);
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");



    }

    @AfterClass
    public void stopDriver()
    {
        driver.quit();
    }


    //Screenshot
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE){

            System.out.println("Failed!");
            System.out.println("Taking ScreenShot...");
            Helper.captureScreenshot(driver,result.getName());

        }
    }
    public void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }}

    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10)); // You can adjust the timeout as needed
    }

    public void waitForElementToBeVisible(By locator) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
