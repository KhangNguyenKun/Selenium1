package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.HomePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC12_ForgotPasswordTest extends BaseTest{
    private HomePage homePage= new HomePage();

    @Test
    public void TC12(){
        test = extent.createTest("TC12", "Errors display when password reset token is blank");
        System.out.println("User can change password");
        homePage.open();

        test.info("1. Navigate to Railway");
        homePage.gotoLoginPage();

        test.info("2. Click on \"Forgot Password page\" link");
        Constant.WEBDRIVER.findElement(By.xpath("//a[@href=/Account/ForgotPassword.cshtml]")).click();

        test.info("3. Enter the email address of the created account in Pre-condition");
        test.log(Status.SKIP, "Function is not completed");
        Constant.WEBDRIVER.findElement(By.xpath("//input[@name='email']")).sendKeys(Constant.EMAIL_REGISTER);
        test.info("4. Click on \"Send Instructions\" button");

    }
}
