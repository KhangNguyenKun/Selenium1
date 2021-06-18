package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.HomePage;
import PageObject.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateANewAccount extends BaseTest{
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();


    @Test
    public void TC07(){
        System.out.println("User can create a new account");
        homePage.open();
        homePage.goToTabRegister();


        String actual = registerPage.register(Constant.EMAIL_REGISTER, Constant.PASSWORD_REGISTER, Constant.CONFIRM_PASSWORD_REGISTER,
                Constant.PID_REGISTER).getRegisterSuccess();
        String expected = "Thank you for registering your account";
        Assert.assertEquals(actual, expected);
    }
}
