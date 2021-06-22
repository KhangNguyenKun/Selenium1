package TestCases.Railway;

import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_LoginTest extends BaseTest{
    private HomePage homePage = new HomePage();
    @Test
    public void TC04(){
        test = extent.createTest("TC04", "Login page displays when un-logged User clicks on \"Book ticket\" tab");
        System.out.println("TC04-Login page displays when un-logged User clicks on Book ticket tab");

        test.info("1. Navigate to Railway website");
        homePage.open();

        test.info("2. Click on BookTicket tab");
        BookTicketPage bookTicketPage = new BookTicketPage();

        BookTicketPage actualMsg= bookTicketPage.gotoBookTicket();
        LoginPage expectedMsg= homePage.gotoLoginPage();

        Assert.assertNotEquals(actualMsg, expectedMsg);
    }
}
