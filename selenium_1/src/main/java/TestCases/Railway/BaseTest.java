package TestCases.Railway;

import Common.Constant;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.NetworkMode;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class BaseTest {
//    static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Reports/extent.html");
    static ExtentReports extent = new ExtentReports();
    static ExtentTest test;

    @BeforeSuite
    public void extentReport(){
        Date date = new Date();
        String filePath = "./Reports/extent.html";
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
//        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    @Parameters("browser")
    public static void startTest(String browser) throws Exception {
//        Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            WebDriverManager.firefoxdriver().setup();
            Constant.WEBDRIVER = new FirefoxDriver();
            Constant.WEBDRIVER.manage().window().maximize();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            WebDriverManager.chromedriver().setup();
            //create chrome instance
            Constant.WEBDRIVER = new ChromeDriver();
            Constant.WEBDRIVER.manage().window().maximize();
        }
        //Check if parameter passed as 'Edge'
        else if (browser.equalsIgnoreCase("Edge")) {
            //set path to Edge.exe
            WebDriverManager.edgedriver().setup();
            //create Edge instance
            Constant.WEBDRIVER = new EdgeDriver();
            Constant.WEBDRIVER.manage().window().maximize();
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }

//        String filePath = "D:\\Selenium1\\selenium_1\\Reports\\" + Utils.time() + "extent.html";
//        File extentReportFile = new File(filePath);
//        extent = new ExtentReports(filePath, true, DisplayOrder.OLDEST_FIRST, NetworkMode.ONLINE);
//        extent.loadConfig(new File("D:\\logi\\selen_project_git\\logi_selenium\\selen_gr_railway2\\src\\main\\" +
//                "resources\\ExtentReport\\extent-config.xml"));
    }


    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case " + result.getName() + ": pass");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case " + result.getName() + ": fail");
            test.log(Status.FAIL, "Test Case Failed: " + result.getThrowable());
            String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) Constant.WEBDRIVER).getScreenshotAs(OutputType.BASE64);
            test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(base64Screenshot));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case " + result.getName() + " : skip");
            test.log(Status.SKIP, "Test Case Skipped: " + result.getThrowable());
        }

        extent.flush();
        Constant.WEBDRIVER.close();

    }

    @AfterSuite
    public static void endTest() {
        extent.flush();
    }

}
