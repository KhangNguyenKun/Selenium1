package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.HomePage;
import PageObject.Railway.RegisterPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class CreateANewAccount_TC11 extends BaseTest{
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();


    @Test
    public void TC11(){

        test.info("1. Navigate to QA Railway Website");
        homePage.open();
        test.info("2. Click on Register tab");
        homePage.goToTabRegister();

        test.info("3. Enter valid information into all fields except Confirm password is not the same with Password");
        String actual = registerPage.register(Constant.EMAIL_REGISTER, Constant.PASSWORD_REGISTER, Constant.INVALID_PASSWORD,
                Constant.PID_REGISTER).getRegisterSuccess();
        String expected = "There're errors in the form. Please correct the errors and try again.";
        if (actual.equals(expected)){
            test.log(Status.PASS, "Error displayed correctly");
        }else {
            test.log(Status.FAIL,"Fail to displayed message");
        }
    }
}
