package TestCases.Railway;

import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TC02_LoginTest extends BaseTest  {

    @Test
    public void TC02(){
        test = extent.createTest("TC02", "User can't login with blank Username textbox");
        try {
            HomePage homePage = new HomePage();
            LoginPage loginPage = new LoginPage();
            System.out.println("TC02-User can't login with blank Username text box");
            test.info("1. Navigate to Railway website");
            homePage.open();
            test.info("2. Click on Login tab");
            homePage.gotoLoginPage();
            test.info("3. User does not type any words into Username textbox but enter valid information in Password");
            test.info("4. Click on \"Login\" button");
            String actualMsg = loginPage.login("",System.getenv("PASSWORD")).getErrorMessage();
            String expectedMsgBlankTextBox = "There was a problem with your login and/or errors exist in your form.";
            if (actualMsg.equals(expectedMsgBlankTextBox)) {
                test.log(Status.PASS, "Error message show correctly");
            } else {
                test.log(Status.FAIL, "Error message show not correctly");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
