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
        return ExcelUtils.getExcelData(filePath, "Sheet2");
    }
    @Test(priority = 1, dataProvider = "registrationData", alwaysRun = true)
    public void UserRegistrationDDT(String firstName, String lastName, String email, String telephone, String password, String expectedResult) {
        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject = new UserRegisterationPage(driver);

        registerObject.userRegistration(firstName, lastName, email, telephone, password);

        waitFor(1000);
        String pageSource = driver.getPageSource();


        if (expectedResult.equalsIgnoreCase("Success")) {
            String expectedMessage = "Your Account Has Been Created!";
            Assert.assertTrue(pageSource.contains(expectedMessage),
                    "The success message is not displayed or is incorrect.");
        }

        else if (expectedResult.contains("First Name must be between 1 and 32 characters!")) {
            Assert.assertFalse(pageSource.contains("Your Account Has Been Created!"),
                    "Account should not be created with missing first name.");
            Assert.assertTrue(pageSource.contains(expectedResult),
                    "The error message for first name is not displayed as expected.");
        }

        else if (expectedResult.contains("Last Name must be between 1 and 32 characters!")) {
            Assert.assertFalse(pageSource.contains("Your Account Has Been Created!"),
                    "Account should not be created with missing last name.");
            Assert.assertTrue(pageSource.contains(expectedResult),
                    "The error message for last name is not displayed as expected.");
        }

        else if (expectedResult.contains("E-Mail Address does not appear to be valid!")) {
            Assert.assertFalse(pageSource.contains("Your Account Has Been Created!"),
                    "Account should not be created with invalid email.");
            Assert.assertTrue(pageSource.contains(expectedResult),
                    "The error message for invalid email is not displayed as expected.");
        }

        else if (expectedResult.contains("Telephone must be between 3 and 32 characters!")) {
            Assert.assertFalse(pageSource.contains("Your Account Has Been Created!"),
                    "Account should not be created with invalid telephone.");
            Assert.assertTrue(pageSource.contains(expectedResult),
                    "The error message for invalid telephone is not displayed as expected.");
        }

        else if (expectedResult.contains("Password must be between 4 and 20 characters!")) {
            Assert.assertFalse(pageSource.contains("Your Account Has Been Created!"),
                    "Account should not be created with invalid password.");
            Assert.assertTrue(pageSource.contains(expectedResult),
                    "The error message for invalid password is not displayed as expected.");
        }

        else if (expectedResult.contains("Warning: E-Mail Address is already registered!")) {
            Assert.assertFalse(pageSource.contains("Your Account Has Been Created!"),
                    "Account should not be created with registered email.");
            Assert.assertTrue(pageSource.contains(expectedResult),
                    "The error message for registered email is not displayed as expected.");
        }


        else if (expectedResult.contains("Can't Register using numeric name")) {
            Assert.assertFalse(pageSource.contains("Your Account Has Been Created!"),
                    "Account should not be created with a numeric first name.");
            Assert.assertTrue(pageSource.contains(expectedResult),
                    "User should not be able to register using a numeric name");
        }

        else {
            Assert.assertFalse(pageSource.contains("Your Account Has Been Created!"),
                    "User Registered successfully using incorrect credentials");
        }
    }



}
