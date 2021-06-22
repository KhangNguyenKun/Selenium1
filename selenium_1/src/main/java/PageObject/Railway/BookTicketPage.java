package PageObject.Railway;

import Common.Constant;
import Common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage  {

    private final By departDate = By.xpath("//form//select[@name='Date']");
    private final By departFrom1 = By.xpath("//form//select[@name='DepartStation']");
    private final By arriveAt1 = By.xpath("//form//select[@name='ArriveStation']");
    private final By seatType1 = By.xpath("//form//select[@name='SeatType']");
    private final By ticketAmount = By.xpath("//form//select[@name='TicketAmount']");
    private final By submit = By.xpath("//input[@value='Book ticket']");

    public WebElement getBtn(){
        return Constant.WEBDRIVER.findElement(submit);
    }
    public HomePage bookTicket(String date, String departFrom, String arriveAt, String seatType,
                               String amount) {

        Select select = new Select(Constant.WEBDRIVER.findElement(departDate));
        select.selectByVisibleText(date);

        Select selectDepart = new Select(Constant.WEBDRIVER.findElement(departFrom1));
        selectDepart.selectByVisibleText(departFrom);
        Utils.threadSleep();

        Select selectArrive = new Select(Constant.WEBDRIVER.findElement(arriveAt1));
        selectArrive.selectByVisibleText(arriveAt);


        Select selectSeat = new Select(Constant.WEBDRIVER.findElement(seatType1));
        selectSeat.selectByVisibleText(seatType);

        Select selectAmount = new Select(Constant.WEBDRIVER.findElement(ticketAmount));
        selectAmount.selectByVisibleText(amount);

        this.getBtn().click();

        return new HomePage();
    }
}
