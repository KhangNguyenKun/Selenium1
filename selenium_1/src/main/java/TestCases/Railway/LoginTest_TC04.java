package TestCases.Railway;

import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest_TC04 extends BaseTest{
    private HomePage homePage = new HomePage();

    private LoginPage loginPage = new LoginPage();
    @Test
    public void TC04(){
        System.out.println("TC04-Login page displays when un-logged User clicks on Book ticket tab");

        homePage.open();

        BookTicketPage bookTicketPage = new BookTicketPage();


        BookTicketPage actualMsg= bookTicketPage.gotoBookTicket();
        LoginPage expectedMsg= homePage.gotoLoginPage();

        Assert.assertNotSame(actualMsg, expectedMsg,   "Welcome message is not display as expected");
    }
}
