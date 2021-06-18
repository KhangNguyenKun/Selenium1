package PageObject.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage{
    private static By currentPassword = By.xpath("//input[@id='currentPassword']");
    private static By newPassword = By.xpath("//input[@id='newPassword']");
    private static By confirmPassword = By.xpath("//input[@id='confirmPassword']");
    private static By buttonChange = By.xpath("//input[@value='Change Password']");

    public HomePage changePassword(String currentPass, String newPass, String confirmPass){
        Constant.WEBDRIVER.findElement(currentPassword).sendKeys(currentPass);
        Constant.WEBDRIVER.findElement(newPassword).sendKeys(newPass);
        Constant.WEBDRIVER.findElement(confirmPassword).sendKeys(confirmPass);
        WebElement element = Constant.WEBDRIVER.findElement(buttonChange);
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);",
                element);
        Constant.WEBDRIVER.findElement(buttonChange).click();

        return new HomePage();
    }
}
