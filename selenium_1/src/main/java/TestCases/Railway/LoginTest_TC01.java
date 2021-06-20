package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class LoginTest_TC01 extends BaseTest{
    @Test
    public void TC01(){
        HomePage homePage = new HomePage();

        LoginPage loginPage = new LoginPage();

        System.out.println("TC01-user can log into Railway with valid user name and password");

        test.info("1. Navigate to Railway website");
        homePage.open();

        test.info("2. Click to Login tab");
        homePage.gotoLoginPage();

        test.info("3. Enter valid email and password");

        String actualMsg= loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        if (actualMsg.equals(expectedMsg)){
            test.log(Status.PASS, "User can log into Railway with valid user name and password");
        }
        else {
            test.log(Status.FAIL, "User can not log into Railway with valid user name and password");
        }
//         Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not display as expected");
    }
}
