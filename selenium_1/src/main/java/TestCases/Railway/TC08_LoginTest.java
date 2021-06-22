package TestCases.Railway;

import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TC08_LoginTest extends BaseTest {
    @Test
    public void TC08() {
        test = extent.createTest("TC08", "User can't login with an account hasn't been activated");
        HomePage homePage = new HomePage();

        LoginPage loginPage = new LoginPage();

        System.out.println("TC01-user can log into Railway with valid user name and password");

        test.info("1. Navigate to Railway website");
        homePage.open();

        test.info("2. Click to Login tab");
        homePage.gotoLoginPage();

        test.info("3. Enter username and password of account hasn't been activated.");
        test.log(Status.SKIP, "Enable activated function");
    }
}