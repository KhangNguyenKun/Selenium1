package PageObject.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeTablePage extends GeneralPage{

    public void checkPrice(String departStation, String arriveAt){
        Constant.WEBDRIVER.findElement(By.xpath("//td[.='"+ departStation +"']" +
                "/following-sibling::td[.='"+ arriveAt + "']" +
                "/following-sibling::td[3]//a")).click();
         }
    public BookTicketPage bookTicket(String departStation, String arriveAt){
        WebElement element = Constant.WEBDRIVER.findElement
                (By.xpath("//td[.='"+ departStation +"']/following-sibling::td[.='"+
                        arriveAt + "']/following-sibling::td[4]//a"));
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);",
                element);
        element.click();
//        WebDriverWait wait2 = new WebDriverWait(Constant.WEBDRIVER, 10);
//        wait2.until(ExpectedConditions.elementToBeClickable(Constant.WEBDRIVER.findElement
//                (By.xpath("//td[.='"+ departStation +"']/following-sibling::td[.='"+
//                        arriveAt + "']/following-sibling::td[4]//a"))));
        return new BookTicketPage();
    }
}
