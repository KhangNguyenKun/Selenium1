package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.ChangePasswordPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import PageObject.Railway.MyTicketPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_HomePageTest extends BaseTest {
    @Test
    public void TC06()
    {
        test = extent.createTest("TC06", "User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();

        LoginPage loginPage = new LoginPage();

        System.out.println("TC01-user can log into Railway with valid user name and password");

        test.info("1. Navigate to Railway website");
        homePage.open();

        test.info("2. Click to Login tab");
        homePage.gotoLoginPage();

        test.info("3. Enter valid email and password");
        test.info("4. Click on \"Login\" button");
        loginPage.login(System.getenv("USERNAME"),System.getenv("PASSWORD"));

        String actualMyTicketTab = Constant.WEBDRIVER.findElement(By.xpath("//span[.='My ticket']")).getText();
        String actualLogoutTab = Constant.WEBDRIVER.findElement(By.xpath("//span[.='Log out']")).getText();
        String actualChangPasswordTab = Constant.WEBDRIVER.findElement(By.xpath("//span[.='Change password']")).getText();
        Assert.assertEquals(actualMyTicketTab, "My ticket");
        Assert.assertEquals(actualLogoutTab, "Log out");
        Assert.assertEquals(actualChangPasswordTab, "Change password");

        test.info("Click \"My ticket\" tab, user will be directed to My ticket page");

        MyTicketPage actualMyTicket = homePage.gotoMyTicket();
        Assert.assertEquals(actualMyTicket, new MyTicketPage());

        test.info("Click \"Change password\" tab, user will be directed to Change password page");

        ChangePasswordPage actualChangePasswordPage = homePage.goToChangePasswordPage();
        Assert.assertEquals(actualChangePasswordPage, new ChangePasswordPage());

    }
}