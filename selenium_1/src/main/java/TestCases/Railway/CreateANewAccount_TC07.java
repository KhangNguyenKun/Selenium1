package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.HomePage;
import PageObject.Railway.RegisterPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateANewAccount_TC07 extends BaseTest{
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();


    @Test
    public void TC07(){
        System.out.println("User can create a new account");
        test.info("1. Navigate to QA Railway Website");
        homePage.open();

        test.info("2. Click on Register tab");
        homePage.goToTabRegister();

        test.info("3. Enter valid information into all fields");
        String actual = registerPage.register(Constant.EMAIL_REGISTER, Constant.PASSWORD_REGISTER, Constant.CONFIRM_PASSWORD_REGISTER,
                Constant.PID_REGISTER).getRegisterSuccess();
        String expected = "Thank you for registering your account";
        if (actual.equals(expected)){
            test.log(Status.PASS, "User create a new account successfully");
        }
        else test.log(Status.FAIL, "");
    }
}
