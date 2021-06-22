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
        return new BookTicketPage();
    }
    public String checkTicketFromTimetable(){
        WebElement element = Constant.WEBDRIVER.findElement
                (By.xpath("//td[.='Huế']/following-sibling::td[.='Sài Gòn']/following-sibling::td[4]//a"));
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);",
                element);
        return element.getText();
    }
}
