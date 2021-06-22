package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.HomePage;
import PageObject.Railway.RegisterPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10_CreateANewAccount extends BaseTest{
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();
    @Test
    public void TC10(){
        test = extent.createTest("TC10", "User can't create account with \"Confirm password\" is not the same with \"Password\"");

        test.info("1. Navigate to QA Railway Website");
        homePage.open();
        test.info("2. Click on Register tab");
        homePage.goToTabRegister();

        test.info("3. Enter valid information into all fields except \"Confirm password\" is not the same with \"Password\"");
        test.info("4. Click on \"Register\" button");
        registerPage.register(Constant.EMAIL_REGISTER, Constant.PASSWORD_REGISTER, "1365465486",
                Constant.PID_REGISTER);
        String actual = registerPage.getRegisterFailure();
        String expected = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actual, expected);
    }
}
