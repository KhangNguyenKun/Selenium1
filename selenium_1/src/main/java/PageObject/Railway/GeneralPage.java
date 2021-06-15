package PageObject.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    private  final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private  final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private  final By lbWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabBookTicket = By.xpath("//li//a//span[.='Book ticket']");
    private final By tabMyTicket = By.xpath("//li//a//span[.='My ticket']");
    private final By tabRegister = By.xpath("//li//a//span[.='Register']");
    private final By tabFAQ = By.xpath("//li//a//span[.='FAQ']");
    private final By tabTimeTable = By.xpath("//li//a//span[.='Timetable']");
    private final By successBookTicket = By.xpath("//div//h1[.='Ticket Booked Successfully!']");
    private final By ticketBooked = By.xpath("//td[.='" +Constant.DEPART_FROM + "']/" +
            "following-sibling::td[.='" +
                             Constant.ARRIVE_AT + "']");

    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabBookTicket(){
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabRegister(){
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTimetable(){
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }

    protected WebElement BookTicket(){
        return Constant.WEBDRIVER.findElement(ticketBooked);
    }

    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLbWelcome(){
        return Constant.WEBDRIVER.findElement(lbWelcomeMessage);
    }

    protected WebElement getLbSuccessBookTicket(){
        return Constant.WEBDRIVER.findElement(successBookTicket);
    }

    public String getWelcomeMessage(){
        return this.getLbWelcome().getText();
    }

    public String checkExistTicket(){
        return this.BookTicket().getText();
    }

    public RegisterPage goToTabRegister(){
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public TimeTablePage gotoTimetable(){
        this.getTimetable().click();
        return new TimeTablePage();
    }

    public String getSuccessBookTicket(){
        return this.getLbSuccessBookTicket().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public void gotoMyTicket(){
        Constant.WEBDRIVER.findElement(tabMyTicket).click();

    }

    public BookTicketPage gotoBookTicket(){
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }
}
