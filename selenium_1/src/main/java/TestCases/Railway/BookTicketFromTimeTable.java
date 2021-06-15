package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import PageObject.Railway.TimeTablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketFromTimeTable {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
//        System.setProperty("webdriver.chrome.driver", Utilities.getPro())
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();

        Constant.WEBDRIVER.manage().window().maximize();
    }

    @Test
    public void TC04(){
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        TimeTablePage timeTablePage = loginPage.gotoTimetable();
        timeTablePage.bookTicket(Constant.DEPART_FROM,Constant.ARRIVE_AT);

//        BookTicketPage bookTicketPage = new BookTicketPage();
//        bookTicketPage.gotoBookTicket(Constant.DATEBOOK, Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE,
//                Constant.TICKET_AMOUNT);
    }
}
