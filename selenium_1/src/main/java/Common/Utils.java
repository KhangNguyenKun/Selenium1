package Common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Utils {
    public static void scrollIntoView(String xpath) {
        WebElement element = Constant.WEBDRIVER.findElement
                (By.xpath(xpath));
        ((JavascriptExecutor) Constant.WEBDRIVER).
                executeScript("arguments[0].scrollIntoView(true);",
                        element);
        element.click();
    }

    public static void threadSleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Date time() {
        Date date = new Date();
        return date;
    }

    public static Iterator readJSON() throws IOException, ParseException {
        Object obj;
        obj = new JSONParser().parse(new FileReader("D:\\Selenium1\\selenium_1\\login.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray users = (JSONArray) jsonObject.get("users");
        Iterator login = users.iterator();
        return login;
    }
}
