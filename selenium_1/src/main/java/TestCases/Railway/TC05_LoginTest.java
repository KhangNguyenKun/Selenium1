package TestCases.Railway;

import Common.ExcelUtils;
import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC05_LoginTest extends BaseTest {

    private String sTestCaseName;

    private int iTestCaseRow;

    private HomePage homePage = new HomePage();

    private LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "Authentication")
    public void TC05(String userName, String password) {
//        1. Navigate to QA Railway Website
//        2. Click on "Login" tab
//        3. Enter valid information into "Username" textbox except "Password" textbox.
//        4. Click on "Login" button
//        5. Repeat step 3 three more times.

        test = extent.createTest("TC05", "System shows message when user enters wrong password several times");

        test.info("1. Navigate to QA Railway Website");
        homePage.open();
        test.info("2. Click on Login tab");
        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.gotoBookTicket();
        homePage.gotoLoginPage();
        test.info("3. Enter valid information into \"Username\" textbox except \"Password\" textbox.");
        test.info("4. Click on \"Login\" button");
        test.info("5. Repeat step 3 three more times.");
        String actualMsg = loginPage.login(userName, password).getErrorMessage();
        String expectedMsgSeveralTimes = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertNotSame(actualMsg, expectedMsgSeveralTimes, "Welcome message is not display as expected");
    }

    @DataProvider(name = "Authentication")

    public Object[][] Authentication() throws Exception {

        ExcelUtils.setExcelFile("D:\\Selenium1\\selenium_1\\src\\main\\resources\\Data\\loginAccount.xlsx", "Sheet2");

        sTestCaseName = this.toString();

        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());


        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);

        Object[][] testObjArray = ExcelUtils.getTableArray("D:\\Selenium1\\selenium_1\\src\\main\\resources\\Data\\loginAccount.xlsx"
                , "Sheet2", iTestCaseRow);

        return (testObjArray);

    }

}
