package TestCases.Railway;

import Common.Utils;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TC01_LoginTest extends BaseTest{
    @Test
    public void TC01() throws IOException, ParseException {
        test = extent.createTest("TC01", "User can log into Railway with valid username and password");
        Iterator login = Utils.readJSON();
        ArrayList<String> list = new ArrayList<>();
        while (login.hasNext()) {
            Iterator<Map.Entry> login1 = ((Map) login.next()).entrySet().iterator();
            String str;
            while ( login1.hasNext()) {
                Map.Entry pair = login1.next();
                str = (String) pair.getValue();
                list.add(str);
            }

        }
        for (int i =0 ; i<list.size(); i++){
            HomePage homePage = new HomePage();

            LoginPage loginPage = new LoginPage();

            System.out.println("TC01-user can log into Railway with valid user name and password");

            test.info("1. Navigate to Railway website");
            homePage.open();

            test.info("2. Click to Login tab");
            homePage.gotoLoginPage();

            test.info("3. Enter valid email and password");
            test.info("4. Click on \"Login\" button");
            String actualMsg =loginPage.login(list.get(i+1), list.get(i)).getWelcomeMessage();
            String expectedMsg = "Welcome " + list.get(i+1);
            System.out.println("username : " + list.get(i+1));
            System.out.println("password : " + list.get(i));
            Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not display as expected");
            homePage.gotoTabLogout();
            i = i + 1;
        }
    }
}