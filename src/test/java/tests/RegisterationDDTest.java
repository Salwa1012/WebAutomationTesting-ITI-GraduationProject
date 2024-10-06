package tests;

import Pages.HomePage;
import Pages.UserRegisterationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtils;

public class RegisterationDDTest extends TestBase {

    HomePage homeObject;
    UserRegisterationPage registerObject;


    @DataProvider(name = "registrationData")
    public Object[][] userRegistrationData() throws Exception {
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/registrationData.xlsx";
        return ExcelUtils.getExcelData(filePath, "Sheet1");
    }

    @Test(priority = 1, dataProvider = "registrationData", alwaysRun = true)
    public void UserRegistrationDDT(String firstName, String lastName, String email, String telephone, String password, String expectedResult) {
        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject = new UserRegisterationPage(driver);

        registerObject.userRegistration(firstName, lastName, email, telephone, password);

        if (expectedResult.equalsIgnoreCase("Success")) {
            String expectedMessage = "Your Account Has Been Created!";
            Assert.assertTrue(registerObject.getSuccessMessageText().contains(expectedMessage),
                    "The success message is not displayed or is incorrect.");
        }
    }
}
