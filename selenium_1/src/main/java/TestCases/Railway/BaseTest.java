package TestCases.Railway;

import Common.Constant;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.Argument;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;

public class BaseTest {
    static ExtentReports report;
    static ExtentTest test;

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browserName) {

        switch (browserName) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                Constant.WEBDRIVER = new ChromeDriver();

        }
        System.out.println("Pre-condition");
//        System.setProperty("webdriver.chrome.driver", Utilities.getPro())
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();

        Constant.WEBDRIVER.manage().window().maximize();


    }
    public static void startTest() {
        report = new ExtentReports(System.getProperty("user.dir") + "ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
    }

    @AfterMethod
    public void afterMethod() {

        Constant.WEBDRIVER.close();

    }
}
