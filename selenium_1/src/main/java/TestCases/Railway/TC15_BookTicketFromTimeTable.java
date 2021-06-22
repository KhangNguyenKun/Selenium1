package TestCases.Railway;

import Common.Constant;
import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import PageObject.Railway.TimeTablePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15_BookTicketFromTimeTable extends BaseTest {


    @Test
    public void TC15() throws InterruptedException {
//        1. Navigate to QA Railway Website
//        2. Login with a valid account
//        3. Click on "Timetable" tab
//        4. Click on "book ticket" link of the route from "Huế" to "Sài Gòn"

        test = extent.createTest("TC15", "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        HomePage homePage = new HomePage();
        test.info(" 1. Navigate to QA Railway Website");
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        test.info("2. Login with a valid account");
        loginPage.login(System.getenv("USERNAME"),System.getenv("PASSWORD"));

        test.info("3. Click on \"Timetable\" tab");
        TimeTablePage timeTablePage = loginPage.gotoTimetable();

        test.info("4. Click on \"book ticket\" link of the route from \"Huế\" to \"Sài Gòn\"");
        timeTablePage.bookTicket(Constant.DEPART_FROM,Constant.ARRIVE_AT);

        Thread.sleep(5000);

        Select select = new Select(Constant.WEBDRIVER.findElement(By.xpath("//select[@name='DepartStation']")));
        WebElement option = select.getFirstSelectedOption();
        String actualDepartFrom = option.getText();

        Select selectArrive = new Select(Constant.WEBDRIVER.findElement(By.xpath("//select[@name='ArriveStation']")));
        WebElement option_2 = selectArrive.getFirstSelectedOption();
        String actualArriveAt = option_2.getText();

        Assert.assertEquals(actualDepartFrom, "Huế");
        Assert.assertEquals(actualArriveAt, "Quảng Ngãi");

    }
}
