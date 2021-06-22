package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Date;

public class Utils {
    public static void scrollIntoView(String xpath){
        WebElement element = Constant.WEBDRIVER.findElement
                (By.xpath(xpath));
        ((JavascriptExecutor) Constant.WEBDRIVER).
                executeScript("arguments[0].scrollIntoView(true);",
                element);
        element.click();
    }public static void threadSleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static Date time(){
        Date date = new Date();
        return date;
    }
}
