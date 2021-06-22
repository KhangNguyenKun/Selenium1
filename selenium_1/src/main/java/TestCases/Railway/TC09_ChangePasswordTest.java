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

public class TC09_ChangePasswordTest extends BaseTest{
    private HomePage homePage= new HomePage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC09(){
//        1. Navigate to QA Railway Website
//        2. Login with valid account
//        3. Click on "Change Password" tab
//        4. Enter valid value into all fields.
//        5. Click on "Change Password" button

        test = extent.createTest("TC09", "User can change password");
        System.out.println("User can change password");
        homePage.open();

        test.info("1. Navigate to Railway");
        homePage.gotoLoginPage();

        test.info("2. Login to Railway");
        loginPage.login(System.getenv("USERNAME"),System.getenv("PASSWORD"));

        test.info("3. Click on \"Change Password\" tab");
        test.info("4. Enter valid value into all fields.");
        test.info("5. Click on \"Change Password\" button");
        homePage.goToChangePasswordTab();
        String actual = changePasswordPage.changePassword(System.getenv("PASSWORD"), Constant.NEW_PASSWORD, Constant.CONFIRM_PASSWORD)
                .getChangePasswordSuccessMess();
        String expected=  "Your password has been updated!";
        Assert.assertEquals(actual, expected);

    }

}
