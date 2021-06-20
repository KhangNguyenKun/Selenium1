package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest_TC03 extends BaseTest{

    private HomePage homePage = new HomePage();

    private LoginPage loginPage = new LoginPage();
    @Test
    public void TC03(){
        System.out.println("TC03-User can't login with invalid password");

        test.info("1. Navigate to Railway website");
        homePage.open();

        test.info("2. Click to Login tab");

        homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD).getErrorMessage();
        String expectedInvalidPass = "There was a problem with your login and/or errors exist in your form.";

        if(actualMsg.equals(expectedInvalidPass)){
            test.log(Status.PASS, "Message show correctly");
        }else if (!actualMsg.equals(expectedInvalidPass)){
            test.log(Status.FAIL, "Message show not correctly");
        }else {
            test.log(Status.FAIL, "User log in successfully");
        }
    }
}
