package tests;

import Pages.*;

import org.testng.Assert;
import org.testng.annotations.Test;


public class OrderHistoryAndReturnsTest extends TestBase{

    HomePage HomeObject;
    LoginPage LoginObject;
    OrderHistoryPage OrderHistoryObject;
    ProductReturnPage ProductReturnObject;
    @Test(priority = 1)
    public void RegisteredUserCanLogin() {


        HomeObject = new HomePage(driver);
        LoginObject = new LoginPage(driver);
        HomeObject.openLoginPage();
        LoginObject.UserLogin("salwaabdallah2412@gmail.com", "1234");
        String expectedText = "Edit your account information";
        String actualText = driver.getPageSource();
        Assert.assertTrue(actualText.contains(expectedText), "Login was not successful.");

    }

    @Test(priority = 2)
    public void UserCanViewHistory()
    {
        LoginObject = new LoginPage(driver);
        LoginObject.OpenHistoryPage();
        OrderHistoryObject = new OrderHistoryPage(driver);
        String headerText = OrderHistoryObject.getHeaderText();
        Assert.assertEquals(headerText, "Order History", "Order History Not Displayed!");


    }

    @Test(priority = 3)
    public void UserCanReturnOrder()
    {

        OrderHistoryObject = new OrderHistoryPage(driver);
        OrderHistoryObject.viewHistory();
        OrderHistoryObject.returnOrder();
        ProductReturnObject = new ProductReturnPage(driver);

        String ReturnText = OrderHistoryObject.getHeaderReturn();
        Assert.assertEquals(ReturnText, "Product Returns", "Order Return Not Displayed!");
        ProductReturnObject.returnOrder();
        String headerText2 = ProductReturnObject.getProductReturnHeader();
        Assert.assertEquals(headerText2, "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.", "Order Not Returned!");




    }




}
