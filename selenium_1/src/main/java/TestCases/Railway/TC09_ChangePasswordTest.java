package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.ChangePasswordPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09_ChangePasswordTest extends BaseTest{
    private HomePage homePage= new HomePage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC09(){
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
        homePage.goToChangePasswordPage();
        String actual = changePasswordPage.changePassword(System.getenv("PASSWORD"), Constant.NEW_PASSWORD, Constant.CONFIRM_PASSWORD)
                .getChangePasswordSuccessMess();
        String expected=  "Your password has been updated!";
        Assert.assertEquals(actual, expected);

    }

}
