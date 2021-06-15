package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BookTicketTest {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
//        System.setProperty("webdriver.chrome.driver", Utilities.getPro())
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();

        Constant.WEBDRIVER.manage().window().maximize();
    }

//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("Post- condition");
//        Constant.WEBDRIVER.quit();
//    }

    @Test
    public void Tc03(){

        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        System.out.println("TC01-user can log into Railway with invalid user name and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage= homePage.gotoLoginPage();
       loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();


        BookTicketPage bookTicket = homePage.gotoBookTicket();

        String actual= bookTicket.gotoBookTicket(Constant.DATEBOOK, Constant.DEPART_FROM,
                Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT).getSuccessBookTicket();
        System.out.println("Actual: " + actual);
        String expected = "Ticket Booked Successfully!";
        Assert.assertEquals(actual, expected, "Message is not display as expected");
    }
}
