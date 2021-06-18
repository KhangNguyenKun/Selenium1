package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.ChangePasswordPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest{
    private HomePage homePage= new HomePage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC09(){
        System.out.println("User can change password");
        homePage.open();
        homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.goToChangePasswordTab();
        String actual = changePasswordPage.changePassword(Constant.PASSWORD, Constant.NEW_PASSWORD, Constant.CONFIRM_PASSWORD)
                .getChangePasswordSuccessMess();
        String expected=  "Your password has been updated";

        if (actual.equals(expected)){
            test.log(LogStatus.PASS, "TC09- User can change password");
        }
        else
        {
            test.log(LogStatus.FAIL, "TC09- Fail");
        }
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void TC13(){
        System.out.println("Errors display if password and confirm password don't match when resetting password");
        homePage.open();
        homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Change different that confirm password dont match to password");

        homePage.goToChangePasswordTab();
        String actual = changePasswordPage.changePassword(Constant.PASSWORD, "12345678999", "1234587888")
                .getChangePasswordSuccessMess();
        String expectedMsgAbove=  "Could not reset password. Please correct the errors and try again.";

        if (actual.equals(expectedMsgAbove)){
            test.log(LogStatus.PASS, "");
        }
//        Assert.assertEquals(actual, expectedMsgAbove);

        String expectedMsgNextTo = "The password confirmation did not match the new password.";

        Assert.assertEquals(actual, expectedMsgNextTo);

    }

}
