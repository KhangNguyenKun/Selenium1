package TestCases.Railway;

import Common.Constant;

import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import PageObject.Railway.MyTicketPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TC16_DeleteTicketTest extends BaseTest {


    @Test
    public void TC16() throws InterruptedException {
//        1. Navigate to QA Railway Website
//        2. Login with a valid account
//        3. Book a ticket
//        4. Click on "My ticket" tab
//        5. Click on "Cancel" button of ticket which user want to cancel.
//        6. Click on "OK" button on Confirmation message "Are you sure?"


        test = extent.createTest("TC16", "User can cancel a ticket");

        test.info("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        test.info("2. Login with a valid account");
        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.login(System.getenv("USERNAME"), System.getenv("PASSWORD"));

        test.info("Book a ticket");

        homePage.gotoMyTicket();
        int size = homePage.checkAmountExistTicket(Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE,
                Constant.DATEBOOK, Constant.TICKET_AMOUNT);
        test.info("4. Click on \"My ticket\" tab");
        test.info("5. Click on \"Cancel\" button of ticket which user want to cancel.");
        test.info("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        MyTicketPage myTicket = new MyTicketPage();
        myTicket.cancelTicket(Constant.DEPART_FROM, Constant.ARRIVE_AT);

        int sizeAfter = homePage.checkAmountExistTicket(Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE,
                Constant.DATEBOOK, Constant.TICKET_AMOUNT);

        try
        {
            boolean isTrue = sizeAfter == size -1;
            if (isTrue) {
                test.log(Status.PASS, "Ticket is deleted");
            } else {
                test.log(Status.FAIL, "Ticket is not delete");
            }
        }
        catch (Exception e){
            test.info(e);
        }

    }

}
