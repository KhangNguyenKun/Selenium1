package PageObject.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
    //Locators
    private final By userName = By.xpath("//input[@id='username']");
    private final By password = By.xpath("//input[@id='password']");
    private final By login = By.xpath("//input[@value='Login']");
    private final By forgotPassword = By.xpath("//a[@href=/Account/ForgotPassword.cshtml]");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    //Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(userName);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(password);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(login);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    public HomePage login(String username, String password) {
//Submit login credentials
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();

//Land on Hone page
        return new HomePage();
    }
}
