package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.ChangePasswordPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest_TC09 extends BaseTest{
    private HomePage homePage= new HomePage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC09(){
        test = extent.createTest("TC09", "User can change password");
        System.out.println("User can change password");
        homePage.open();

        test.info("Navigate to Railway");
        homePage.gotoLoginPage();

        test.info("Login to Railway");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        test.info("Change password");
        homePage.goToChangePasswordTab();
        String actual = changePasswordPage.changePassword(Constant.PASSWORD, Constant.NEW_PASSWORD, Constant.CONFIRM_PASSWORD)
                .getChangePasswordSuccessMess();
        String expected=  "Your password has been updated!";

        if (actual.equals(expected)){
            test.log(Status.PASS, "User can change password");
        }
        else
        {
            test.log(Status.FAIL, "Fail");
        }
//        Assert.assertEquals(actual, expected);

    }

}
