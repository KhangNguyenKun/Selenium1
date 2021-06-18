package TestCases.Railway;

import Common.Constant;
import Common.ExcelUtils;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import PageObject.Railway.MyTicketPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteTicketTest extends BaseTest {

    private String sTestCaseName;

    private int iTestCaseRow;

    @Test(dataProvider = "Authentication")
    public void TC16(String departFrom, String arriveAt) throws InterruptedException {

        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.gotoMyTicket();
        int size = homePage.checkExistTicket();
        MyTicketPage myTicket = new MyTicketPage();
       myTicket.cancelTicket(departFrom, arriveAt);

       int sizeAfter = homePage.checkExistTicket();
        String expectedDel = myTicket.checkDisplayTicket(departFrom, arriveAt);

        Assert.assertNotSame(actualDel, expectedDel, "Ticket is not deleted");
    }

    @DataProvider(name = "Authentication")

    public Object[][] Authentication() throws Exception {


        ExcelUtils.setExcelFile("D:\\Selenium1\\selenium_1\\src\\main\\java\\DataObjects\\loginAccount.xlsx", "Sheet2");

        sTestCaseName = this.toString();

        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());


        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);

        Object[][] testObjArray = ExcelUtils.getTableArray("D:\\Selenium1\\selenium_1\\src\\main\\java\\DataObjects\\loginAccount.xlsx"
                , "Sheet2", iTestCaseRow);

        return (testObjArray);

    }
}
