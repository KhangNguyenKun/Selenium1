package TestCases.Railway;

import Common.Constant;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Reports/extent.html");
    static ExtentReports extent = new ExtentReports();
    static ExtentTest test;



    @BeforeSuite
//    @Parameters("browser")

    public static void startTest() throws Exception
    {
        extent.attachReporter(htmlReporter);
        //Check if parameter passed from TestNG is 'firefox'
//        if(browser.equalsIgnoreCase("firefox")){
//            //create firefox instance
//            System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
//            Constant.WEBDRIVER = new FirefoxDriver();
//        }
//        //Check if parameter passed as 'chrome'
//        else if(browser.equalsIgnoreCase("chrome")){
//            //set path to chromedriver.exe
//            System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
//            //create chrome instance
//            Constant.WEBDRIVER = new ChromeDriver();
//        }
//        //Check if parameter passed as 'Edge'
//        else if(browser.equalsIgnoreCase("Edge")){
//            //set path to Edge.exe
//            System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
//            //create Edge instance
//            Constant.WEBDRIVER = new EdgeDriver();
//        }
//        else{
//            //If no browser passed throw exception
//            throw new Exception("Browser is not correct");
//        }
    }
    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Pre-condition");
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();

        Constant.WEBDRIVER.manage().window().maximize();
    }


    @AfterMethod
    public void afterMethod() {

//        Constant.WEBDRIVER.close();

    }
    @AfterSuite
    public static void endTest()
    {
        extent.flush();
    }

}
