package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest_TC02 extends BaseTest  {

    @Test
    public void TC02(){
        try {
            HomePage homePage = new HomePage();

            LoginPage loginPage = new LoginPage();

            System.out.println("TC02-User can't login with blank Username text box");

            test.info("1. Navigate to Railway website");
            homePage.open();

            test.info("2. Click on Login tab");
            homePage.gotoLoginPage();

            test.info("3. User does not type any words into Username textbox but enter valid information in Password");
            String actualMsg = loginPage.login("", Constant.PASSWORD).getErrorMessage();
            String expectedMsgBlankTextBox = "There was a problem with your login and/or errors exist in your form.";
//        Assert.assertEquals(actualMsg, expectedMsgBlankTextBox, "Welcome message is not display as expected");

            if (actualMsg.equals(expectedMsgBlankTextBox)) {
                test.log(Status.PASS, "Error message show correctly");
            } else if (!actualMsg.equals(expectedMsgBlankTextBox)) {
                test.log(Status.FAIL, "Error message show not correctly");
            }else {
                test.log(Status.FAIL, "User login successfully");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
