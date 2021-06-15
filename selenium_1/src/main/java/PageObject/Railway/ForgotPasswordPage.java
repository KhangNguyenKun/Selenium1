package PageObject.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage{
    private static By emailTextBox = By.id("email");
    private static By sendInstruction = By.xpath("//input[@value='Send Instructions']");

    protected WebElement getEmail(){
        return Constant.WEBDRIVER.findElement(emailTextBox);
    }

    protected WebElement sendInstructionButton(){
        return Constant.WEBDRIVER.findElement(sendInstruction);
    }

}
