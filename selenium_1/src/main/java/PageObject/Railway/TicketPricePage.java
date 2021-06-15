package PageObject.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage{
//    private static By ticketFromTo = By.xpath("//tr[@class='TableSmallHeader']" +
//            "//th[.='Ticket price from Sài Gòn to Phan Thiết']");
    private static By hardSeatBookTicket = By.xpath("//td[.='Hard seat']/following-sibling::td//a");
    private static By softSeatBookTicket = By.xpath("//td[.='Soft seat']/following-sibling::td//a");
    private static By softSeatWithAirConditionerBookTicket = By.xpath("//td[.='Soft seat with air conditioner']/following-sibling::td//a");
    private static By hardBedBookTicket = By.xpath("//td[.='Hard bed']/following-sibling::td//a");
    private static By softBedBookTicket = By.xpath("//td[.='Soft bed']/following-sibling::td//a");
    private static By softBedWithAirConditionerBookTicket = By.xpath("//td[.='Soft bed with air conditioner']/following-sibling::td//a");

    protected WebElement getHardSeatBookTicket(){
        return Constant.WEBDRIVER.findElement(hardSeatBookTicket);
    }

    protected WebElement getSoftSeatBookTicket(){
        return Constant.WEBDRIVER.findElement(softSeatBookTicket);
    }


    public boolean checkDisplayDepartAndArrive(String departFrom, String arriveAt){
        return Constant.WEBDRIVER.findElement(By.xpath("//tr[@class='TableSmallHeader']" +
                "//th[.='Ticket price from " + departFrom + " to " + arriveAt +"']")).isDisplayed();
    }
}
