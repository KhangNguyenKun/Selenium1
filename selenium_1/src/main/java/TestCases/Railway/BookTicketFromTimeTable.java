package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import PageObject.Railway.TimeTablePage;
import org.testng.annotations.Test;

public class BookTicketFromTimeTable extends BaseTest {


    @Test
    public void TC15() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        TimeTablePage timeTablePage = loginPage.gotoTimetable();
        timeTablePage.bookTicket(Constant.DEPART_FROM,Constant.ARRIVE_AT);

        BookTicketPage bookTicketPage = new BookTicketPage();

        bookTicketPage.bookTicket(Constant.DATEBOOK, Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE,
                Constant.TICKET_AMOUNT);

    }
}
