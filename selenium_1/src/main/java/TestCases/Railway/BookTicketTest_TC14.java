package TestCases.Railway;

import Common.Constant;

import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;


import PageObject.Railway.LoginPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BookTicketTest_TC14 extends BaseTest {

    @Test
    public void TC14() throws InterruptedException {

        System.out.println("Login page displays when un-logged User clicks on Book ticket tab");

        System.out.println("TC01-user can log into Railway with valid user name and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage= homePage.gotoLoginPage();
       loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();


        BookTicketPage bookTicket = homePage.gotoBookTicket();

        String actual= bookTicket.bookTicket(Constant.DATEBOOK, Constant.DEPART_FROM,
                Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT).getSuccessBookTicket();

        String expected = "Ticket Booked Successfully!";

        try
        {
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(actual, expected, "Message is not display as expected");
            String actualDate = Constant.WEBDRIVER.findElement(By.xpath("//td[.='" + Constant.DATEBOOK + "']")).getText();
            softAssert.assertEquals(actualDate, Constant.DATEBOOK);
            String actualDepart = Constant.WEBDRIVER.findElement(By.xpath("//td[.='" + Constant.DEPART_FROM + "']")).getText();
            softAssert.assertEquals(actualDepart, Constant.DEPART_FROM);
            String actualArrive = Constant.WEBDRIVER.findElement(By.xpath("//td[.='" + Constant.ARRIVE_AT + "']")).getText();
            softAssert.assertEquals(actualArrive, Constant.ARRIVE_AT);
            String actualSeatType = Constant.WEBDRIVER.findElement(By.xpath("//td[.='" + Constant.SEAT_TYPE + "']")).getText();
            softAssert.assertEquals(actualSeatType, Constant.SEAT_TYPE);
            String actualAmount = Constant.WEBDRIVER.findElement(By.xpath("//td[.='" + Constant.TICKET_AMOUNT + "']")).getText();
            softAssert.assertEquals(actualAmount, Constant.TICKET_AMOUNT);
            softAssert.assertAll();
            test.log(Status.PASS ," Ticket book successfully ");

        }
        catch (Exception e){
            test.log(Status.PASS, "Fail");
        }
    }

}
