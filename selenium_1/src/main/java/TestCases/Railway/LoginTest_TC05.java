package TestCases.Railway;

import Common.ExcelUtils;
import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest_TC05 extends BaseTest {

    private String sTestCaseName;

    private int iTestCaseRow;

    private HomePage homePage = new HomePage();

    private LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "Authentication")
    public void TC05(String userName, String password){
        System.out.println("TC05-System shows message when user enters wrong password several times");

        homePage.open();

        BookTicketPage bookTicketPage = new BookTicketPage();


        bookTicketPage.gotoBookTicket();
        homePage.gotoLoginPage();

        String actualMsg = loginPage.login(userName, password).getErrorMessage();
        String expectedMsgSeveralTimes = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertNotSame(actualMsg, expectedMsgSeveralTimes ,"Welcome message is not display as expected");
    }

    @DataProvider(name = "Authentication")

    public Object[][] Authentication() throws Exception{

        ExcelUtils.setExcelFile("D://selenium_folder//src//main//java//DataObjects//loginAccount.xlsx","Sheet2");

        sTestCaseName = this.toString();

        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());


        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);

        Object[][] testObjArray = ExcelUtils.getTableArray("D://selenium_folder//src//main//java//DataObjects//loginAccount.xlsx"
                ,"Sheet2",iTestCaseRow);

        return (testObjArray);

    }

}
