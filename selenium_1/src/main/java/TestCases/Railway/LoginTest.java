package TestCases.Railway;

import Common.Constant;
import Common.ExcelUtils;
import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    private String sTestCaseName;

    private int iTestCaseRow;

    private HomePage homePage = new HomePage();

    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC01(){
        System.out.println("TC01-user can log into Railway with valid user name and password");

        homePage.open();

        homePage.gotoLoginPage();


        String actualMsg= loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
         Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not display as expected");
     }


    @Test
    public void TC02(){
        System.out.println("TC02-User can't login with blank Username text box");


        homePage.open();

        homePage.gotoLoginPage();

        String actualMsg= loginPage.login("", Constant.PASSWORD).getErrorMessage();
        String expectedMsgBlankTextBox = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsgBlankTextBox, "Welcome message is not display as expected");

    }


    @Test
    public void TC03(){
        System.out.println("TC03-User can't login with invalid password");

        homePage.open();

        BookTicketPage bookTicketPage = new BookTicketPage();


        bookTicketPage.gotoBookTicket();
        homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD).getErrorMessage();
        String expectedInvalidPass = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertNotSame(actualMsg, expectedInvalidPass,"Welcome message is not display as expected");
    }

    @Test
    public void TC04(){
        System.out.println("TC04-Login page displays when un-logged User clicks on Book ticket tab");

        homePage.open();

        BookTicketPage bookTicketPage = new BookTicketPage();


        BookTicketPage actualMsg= bookTicketPage.gotoBookTicket();
        LoginPage expectedMsg= homePage.gotoLoginPage();

        Assert.assertNotSame(actualMsg, expectedMsg,   "Welcome message is not display as expected");
    }


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
//
//    @DataProvider(name = "Authentication_2")
//
//    public Object[][] Authentication_2() throws Exception{
//
//        ExcelUtils.setExcelFile("D:\\Selenium1\\selenium_1\\src\\main\\java\\DataObjects\\loginAccount.xlsx","Sheet2");
//
//        sTestCaseName = this.toString();
//
//        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
//
//
//        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
//
//        Object[][] testObjArray = ExcelUtils.getTableArray("D:\\Selenium1\\selenium_1\\src\\main\\java\\DataObjects\\loginAccount.xlsx"
//                ,"Sheet2",iTestCaseRow);
//
//        return (testObjArray);
//
//    }


}
