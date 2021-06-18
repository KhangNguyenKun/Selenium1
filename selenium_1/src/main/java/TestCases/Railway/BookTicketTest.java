package TestCases.Railway;

import Common.Constant;

import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;

import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest {
    private String sTestCaseName;

    private int iTestCaseRow;

    @Test
    public void Tc03() throws InterruptedException {

        System.out.println("Login page displays when un-logged User clicks on Book ticket tab");
//        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("TC01-user can log into Railway with valid user name and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage= homePage.gotoLoginPage();
       loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

//        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BookTicketPage bookTicket = homePage.gotoBookTicket();

//        String actual= bookTicket.gotoBookTicket(date, departFrom,
//                arrive, seatType, amount).getSuccessBookTicket();
        String actual= bookTicket.bookTicket(Constant.DATEBOOK, Constant.DEPART_FROM,
                Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT).getSuccessBookTicket();

        String expected = "Ticket Booked Successfully!";
        Assert.assertEquals(actual, expected, "Message is not display as expected");
        String actualDate = Constant.WEBDRIVER.findElement(By.xpath("//td[.='" + Constant.DATEBOOK + "']")).getText();
        Assert.assertEquals(actualDate, Constant.DATEBOOK);
        String actualDepart = Constant.WEBDRIVER.findElement(By.xpath("//td[.='" + Constant.DEPART_FROM + "']")).getText();
        Assert.assertEquals(actualDepart, Constant.DEPART_FROM);
        String actualArrive = Constant.WEBDRIVER.findElement(By.xpath("//td[.='" + Constant.ARRIVE_AT + "']")).getText();
        Assert.assertEquals(actualArrive, Constant.ARRIVE_AT);
        String actualSeatType = Constant.WEBDRIVER.findElement(By.xpath("//td[.='" + Constant.SEAT_TYPE + "']")).getText();
        Assert.assertEquals(actualSeatType, Constant.SEAT_TYPE);
        String actualAmount = Constant.WEBDRIVER.findElement(By.xpath("//td[.='" + Constant.TICKET_AMOUNT + "']")).getText();
        Assert.assertEquals(actualAmount, Constant.TICKET_AMOUNT);

    }

//    @DataProvider(name = "Authentication")

//    public Object[][] Authentication() throws Exception {
//
//        // Setting up the Test Data Excel file
//
//        Utilities.setExcelFile("D:\\Selenium1\\selenium_1\\src\\main\\java\\DataObjects\\loginAccount.xlsx", "Sheet3");
//
//        sTestCaseName = this.toString();
//
//        // From above method we get long test case name including package and class name etc.
//
//        // The below method will refine your test case name, exactly the name use have used
//
//        sTestCaseName = Utilities.getTestCaseName(this.toString());
//
//        // Fetching the Test Case row number from the Test Data Sheet
//
//        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
//
//        iTestCaseRow = Utilities.getRowContains(sTestCaseName, 0);
//
//        Object[][] testObjArray = Utilities.getTableArray("D:\\Selenium1\\selenium_1\\src\\main\\java\\DataObjects\\loginAccount.xlsx"
//                , "Sheet3", iTestCaseRow);
//
//        return (testObjArray);
//
//    }
}
