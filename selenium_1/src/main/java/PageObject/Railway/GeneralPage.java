package PageObject.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By lbWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lbErrorMessage = By.xpath("//p[@class='message error LoginForm']");
    private final By registerMessageSuccess = By.xpath("//div[@id='content']//p");
    private final By registerMessageFail = By.xpath("//p[@class='message error']");
    private final By registerInvalidPassLength = By.xpath("//label[@for='password' and @class='validation-error']");
    private final By registerInvalidIDLength = By.xpath("//label[@for='pid' and @class='validation-error']");
    private final By changePasswordSuccessMessage = By.xpath("//p[@class='message success']");
    private final By tabBookTicket = By.xpath("//li//a//span[.='Book ticket']");
    private final By tabMyTicket = By.xpath("//li//a//span[.='My ticket']");
    private final By tabRegister = By.xpath("//li//a//span[.='Register']");
    private final By tabFAQ = By.xpath("//li//a//span[.='FAQ']");
    private final By tabTimeTable = By.xpath("//li//a//span[.='Timetable']");
    private final By successBookTicket = By.xpath("//div//h1[.='Ticket Booked Successfully!']");
//    private final By ticketDepartFromBookAtTimetable = By.xpath("//div//h1[.='Ticket Booked Successfully!']");


    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTimetable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }

    protected WebElement clickToBookTicket(String departFrom, String arriveAt) {
        return Constant.WEBDRIVER.findElement(By.xpath("//td[.='" + departFrom + "']/" +
                "following-sibling::td[.='" +
                arriveAt + "']"));
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLbWelcome() {
        return Constant.WEBDRIVER.findElement(lbWelcomeMessage);
    }

    protected WebElement getRegisterMessageSuccess() {
        return Constant.WEBDRIVER.findElement(registerMessageSuccess);
    }

    protected WebElement getRegisterFail() {
        return Constant.WEBDRIVER.findElement(registerMessageFail);
    }

    protected WebElement getLbErrorMessage() {
        return Constant.WEBDRIVER.findElement(lbErrorMessage);
    }

    protected WebElement getChangePasswordSuccess() {
        return Constant.WEBDRIVER.findElement(changePasswordSuccessMessage);
    }

    protected WebElement getLbSuccessBookTicket() {
        return Constant.WEBDRIVER.findElement(successBookTicket);
    }

    public String getWelcomeMessage() {
        return this.getLbWelcome().getText();
    }

    public void gotoTabLogout() {
         this.getTabLogout().click();

    }

    public String getErrorMessage() {
        return this.getLbErrorMessage().getText();
    }

    public String getChangePasswordSuccessMess() {
        return this.getChangePasswordSuccess().getText();
    }

    public String getRegisterSuccess() {
        return this.getRegisterMessageSuccess().getText();
    }

    public String getInvalidPassLength() {
        return Constant.WEBDRIVER.findElement(registerInvalidPassLength).getText();
    }

    public String getInvalidIDLength() {
        return Constant.WEBDRIVER.findElement(registerInvalidIDLength).getText();
    }

    public String getRegisterFailure() {
        return this.getRegisterFail().getText();
    }

    public int checkAmountExistTicket(String departFrom, String arriveAt, String seatType, String departDate,
                                      String amount) {

        return Constant.WEBDRIVER.findElements(By.xpath("//td[.='Hu???']/following-sibling::td[.='Qu???ng Ng??i']/following-sibling::td[.='Soft bed']/following-sibling::td[.='6/22/2021']/following-sibling::td[.='2']")).size();
    }

    public String checkExistTicket() {
        String ticket = Constant.WEBDRIVER.findElement(By.xpath("//td[.='Hu???']/following-sibling::td[.='S??i G??n']")).getText();
        return ticket;
    }

    public RegisterPage goToTabRegister() {
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public ChangePasswordPage goToChangePasswordPage() {
        this.getTabChangePassword().click();
        return new ChangePasswordPage();
    }

    public TimeTablePage gotoTimetable() {
        this.getTimetable().click();
        return new TimeTablePage();
    }

    public String getSuccessBookTicket() {
        return this.getLbSuccessBookTicket().getText();
    }

    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public MyTicketPage gotoMyTicket() {
        Constant.WEBDRIVER.findElement(tabMyTicket).click();
        return new MyTicketPage();

    }

    public BookTicketPage gotoBookTicket() {
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }
}
