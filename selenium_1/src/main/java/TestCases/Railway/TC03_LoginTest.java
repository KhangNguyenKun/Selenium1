package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC03_LoginTest extends BaseTest{
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    @Test
    public void TC03(){
        test = extent.createTest("TC03", "User cannot log into Railway with invalid password ");
        System.out.println("TC03-User can't login with invalid password");
        test.info("1. Navigate to Railway website");
        homePage.open();
        test.info("2. Click to Login tab");
        homePage.gotoLoginPage();
        test.info("3. Enter valid Email and invalid Password");
        test.info("4. Click on \"Login\" button");
        String actualMsg = loginPage.login(System.getenv("USERNAME"),"").getErrorMessage();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String expectedInvalidPass = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedInvalidPass);
    }
}
