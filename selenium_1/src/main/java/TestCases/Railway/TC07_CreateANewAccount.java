package TestCases.Railway;

import Common.Constant;
import Common.Utils;
import PageObject.Railway.HomePage;
import PageObject.Railway.RegisterPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_CreateANewAccount extends BaseTest{
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();


    @Test
    public void TC07(){
        test = extent.createTest("TC07", "User can create new account");
        System.out.println("User can create a new account");
        test.info("1. Navigate to QA Railway Website");
        homePage.open();

        test.info("2. Click on Register tab");
        homePage.goToTabRegister();

        test.info("3. Enter valid information into all fields");
        test.info("4. Click on \"Register\" button");
        String actual = registerPage.register(Constant.EMAIL_REGISTER, Constant.PASSWORD_REGISTER, Constant.CONFIRM_PASSWORD_REGISTER,
                Constant.PID_REGISTER).getRegisterSuccess();

        String expected = "Thank you for registering your account";
        Assert.assertEquals(actual, expected);
    }
}
