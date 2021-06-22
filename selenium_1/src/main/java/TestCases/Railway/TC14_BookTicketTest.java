package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC14_BookTicketTest extends BaseTest {

    @Test
    public void TC14() throws InterruptedException {
        test = extent.createTest("TC14", "User can book 1 ticket at a time");
        test.info("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();
        test.info("2. Login with a valid account");
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(System.getenv("USERNAME"), System.getenv("PASSWORD")).getWelcomeMessage();
        test.info("3. Click on \"Book ticket\" tab");
        BookTicketPage bookTicket = homePage.gotoBookTicket();
        test.info("4. Select a \"Depart date\" from the list");
        test.info("5. Select \"Sài Gòn\" for \"Depart from\" and \"Nha Trang\" for \"Arrive at\".");
        test.info("6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
        test.info("7. Select \"1\" for \"Ticket amount\"");
        test.info("8. Click on \"Book ticket\" button");
        String actual = bookTicket.bookTicket(Constant.DATEBOOK, Constant.DEPART_FROM,
                Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT).getSuccessBookTicket();
        String expected = "Ticket Booked Successfully!";
        try {
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
            test.log(Status.PASS, " Ticket book successfully ");
        } catch (Exception e) {
            test.log(Status.PASS, "Fail");
        }
    }

}
