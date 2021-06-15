package PageObject.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TrainPriceListPage extends GeneralPage{

    public TicketPricePage goToTicket(String departFrom, String arriveAt){
        WebElement element = Constant.WEBDRIVER.findElement
                (By.xpath("//tr[@class='TableSmallHeader']" +
                        "//th[.='Ticket price from " + departFrom + " to " + arriveAt +"']"));
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);",
                element);
        element.click();
         return  new TicketPricePage();
    }

}
