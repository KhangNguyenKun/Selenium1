package TestCases.Railway;

import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_LoginTest extends BaseTest{
    @Test
    public void TC01(){
        test = extent.createTest("TC01", "User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();

        LoginPage loginPage = new LoginPage();

        System.out.println("TC01-user can log into Railway with valid user name and password");

        test.info("1. Navigate to Railway website");
        homePage.open();

        test.info("2. Click to Login tab");
        homePage.gotoLoginPage();

        test.info("3. Enter valid email and password");
        test.info("4. Click on \"Login\" button");

        String actualMsg= loginPage.login(System.getenv("USERNAME"),System.getenv("PASSWORD")).getWelcomeMessage();
        String expectedMsg = "Welcome " + System.getenv("USERNAME");
         Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not display as expected");
    }
}
