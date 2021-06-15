package PageObject.Railway;

import Common.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class MyTicketPage extends GeneralPage{

    private final By departStation = By.xpath("//select[@name='FilterDpStation']");
    private final By arriveStation = By.xpath("//select[@name='FilterArStation']");
    private final By departDate = By.xpath("//select[@name='FilterDpDate']");
    private final By status = By.xpath("//select[@name='FilterStatus']");
    private final By applyFilter = By.xpath("//select[@value='Apply Filter']");

    protected WebElement getDepartStation(){
        return Constant.WEBDRIVER.findElement(departStation);
    }

    protected WebElement getArrive(){
        return Constant.WEBDRIVER.findElement(arriveStation);
    }

    protected WebElement getDepartDate(){
        return Constant.WEBDRIVER.findElement(departDate);
    }

    protected WebElement getStatus(){
        return Constant.WEBDRIVER.findElement(status);
    }

    protected WebElement getApplyFilter(){
        return Constant.WEBDRIVER.findElement(applyFilter);
    }
    public HomePage cancelTicket(String departFrom, String arriveAt) throws InterruptedException {

        //        try {
            Constant.WEBDRIVER.findElement(By.xpath("//td[.='"+ departFrom +"']/" +
                    "following-sibling::td[.='" + arriveAt + "']" +
                    "/following-sibling::td[8]//child::input")).click();

            Constant.WEBDRIVER.switchTo().alert().accept();

//        } catch (UnhandledAlertException f) {
//            try {
//                WebDriverWait wait = new WebDriverWait( Constant.WEBDRIVER, 2);
//                wait.until(ExpectedConditions.alertIsPresent());
//                Alert alert =  Constant.WEBDRIVER.switchTo().alert();
//                String alertText = alert.getText();
//                System.out.println("Alert data: " + alertText);
//                alert.accept();
//            } catch (NoAlertPresentException e) {
//                e.printStackTrace();
//            }
//        }


//       Actions actions = new Actions(Constant.WEBDRIVER);
//       actions.sendKeys(Keys.ENTER);
              return new HomePage();
    }

    public String checkDisplayTicket(String departFrom, String arriveAt){
        return Constant.WEBDRIVER.findElement(By.xpath("//td[.='" + departFrom+ "']/following-sibling::td[.='"
                + arriveAt +"']")).getText();

    }
}
