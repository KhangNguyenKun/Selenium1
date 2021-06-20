package TestCases.Railway;

import Common.Constant;

import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import PageObject.Railway.MyTicketPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class DeleteTicketTest_TC16 extends BaseTest {


    @Test
    public void TC16() throws InterruptedException {


        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.gotoMyTicket();
        int size = homePage.checkExistTicket( Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE,
                Constant.DATEBOOK, Constant.TICKET_AMOUNT);
        MyTicketPage myTicket = new MyTicketPage();
       myTicket.cancelTicket(Constant.DEPART_FROM, Constant.ARRIVE_AT);

       int sizeAfter = homePage.checkExistTicket(Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE,
               Constant.DATEBOOK, Constant.TICKET_AMOUNT);
       if (sizeAfter == size -1 ){
           test.log(Status.PASS, "Ticket is deleted");
       }
       else {
           test.log(Status.FAIL, "Ticket is not delete");
       }

    }

}
