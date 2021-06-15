package TestCases.Railway;

import Common.Constant;
import Common.ExcelUtils;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import PageObject.Railway.MyTicketPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteTicketTest {

    private String sTestCaseName;

    private int iTestCaseRow;


    @BeforeMethod
    public void beforeMethod() {
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

    @Test(dataProvider = "Authentication")
    public void TC03(String departFrom, String arriveAt) throws InterruptedException {

        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

//        BookTicket bookTicket = homePage.gotoBookTicket();
//
//      bookTicket.gotoBookTicket(Constant.DATEBOOK, Constant.DEPART_FROM,
//                Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT);

        homePage.gotoMyTicket();
        MyTicketPage myTicket = new MyTicketPage();
        String actualDel = myTicket.cancelTicket(departFrom, arriveAt).checkExistTicket();
        String expectedDel = myTicket.checkDisplayTicket(departFrom, arriveAt);

        Assert.assertNotSame(actualDel, expectedDel, "Ticket is not deleted");
    }

    @AfterMethod
    public void afterMethod() {

        Constant.WEBDRIVER.close();

    }


    @DataProvider(name = "Authentication")

    public Object[][] Authentication() throws Exception {

        // Setting up the Test Data Excel file

        ExcelUtils.setExcelFile("D://selenium_folder//src//main//java//DataObjects//loginAccount.xlsx", "Sheet2");

        sTestCaseName = this.toString();

        // From above method we get long test case name including package and class name etc.

        // The below method will refine your test case name, exactly the name use have used

        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());

        // Fetching the Test Case row number from the Test Data Sheet

        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet

        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);

        Object[][] testObjArray = ExcelUtils.getTableArray("D://selenium_folder//src//main//java//DataObjects//loginAccount.xlsx"
                , "Sheet2", iTestCaseRow);

        return (testObjArray);

    }
}
