package TestCases.Railway;

import Common.Constant;
import Common.ExcelUtils;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest {

    private String sTestCaseName;

    private int iTestCaseRow;
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

    @Test(dataProvider = "Authentication")
    public void TC01(String sUserName, String sPassword){
        System.out.println("TC01-user can log into Railway with invalid user name and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage= homePage.gotoLoginPage();


        String actualMsg= loginPage.login(sUserName, sPassword).getWelcomeMessage();
        String expectedMsg = "Welcome " + sUserName;
         Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not display as expected");
     }

     @AfterMethod
     public void afterMethod() {

         Constant.WEBDRIVER.close();

     }

    @DataProvider(name = "Authentication")

    public Object[][] Authentication() throws Exception{

        // Setting up the Test Data Excel file

        ExcelUtils.setExcelFile("D://selenium_folder//src//main//java//DataObjects//loginAccount.xlsx","Sheet2");

        sTestCaseName = this.toString();

        // From above method we get long test case name including package and class name etc.

        // The below method will refine your test case name, exactly the name use have used

        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());

        // Fetching the Test Case row number from the Test Data Sheet

        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet

        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);

        Object[][] testObjArray = ExcelUtils.getTableArray("D://selenium_folder//src//main//java//DataObjects//loginAccount.xlsx"
                ,"Sheet2",iTestCaseRow);

        return (testObjArray);

    }


}
