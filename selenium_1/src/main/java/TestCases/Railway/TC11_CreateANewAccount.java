package TestCases.Railway;

import Common.Constant;
import Common.Utils;
import PageObject.Railway.HomePage;
import PageObject.Railway.RegisterPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11_CreateANewAccount extends BaseTest{
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();


    @Test
    public void TC11(){
        test = extent.createTest("TC11", "User can't create account while password and PID fields are empty");

        test.info("1. Navigate to QA Railway Website");
        homePage.open();
        test.info("2. Click on Register tab");
        homePage.goToTabRegister();

        test.info("3. Enter valid information into all fields except Confirm password is not the same with Password");
        test.info("4. Click on \"Register\" button");
        String actual = registerPage.register(Constant.EMAIL_REGISTER,"", "",
                "").getRegisterFailure();

        String expected = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actual, expected);

        //Scroll to bottom of page
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        String actualPassLength = registerPage.getInvalidPassLength();
        String expectedPassLength = "Invalid password length";
        Assert.assertEquals(actualPassLength, expectedPassLength);
        String actualPIDLength = registerPage.getInvalidIDLength();
        String expectedIDLength = "Invalid ID length";
        Assert.assertEquals(actualPIDLength, expectedIDLength);
    }
}
