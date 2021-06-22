package PageObject.Railway;

import Common.Constant;
import Common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{
    private static By emailP = By.xpath("//input[@id='email']");
    private static By passwordP = By.xpath("//input[@id='password']");
    private static By confirmPasswordP = By.xpath("//input[@id='confirmPassword']");
    private static By pidP = By.xpath("//input[@id='pid']");
    private static By register = By.xpath("//input[@value='Register']");

    public HomePage register(String email, String password, String confirmPassword, String pid){
        Constant.WEBDRIVER.findElement(emailP).sendKeys(email);
        Constant.WEBDRIVER.findElement(passwordP).sendKeys(password);
        Constant.WEBDRIVER.findElement(confirmPasswordP).sendKeys(confirmPassword);
        Constant.WEBDRIVER.findElement(pidP).sendKeys(pid);
        WebElement element = Constant.WEBDRIVER.findElement
                (By.xpath("//input[@value='Register']"));
        ((JavascriptExecutor) Constant.WEBDRIVER).
                executeScript("arguments[0].scrollIntoView(true);",
                        element);
        element.click();
        return new HomePage();
    }
}
