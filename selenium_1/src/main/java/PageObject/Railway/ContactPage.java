package PageObject.Railway;

import org.openqa.selenium.By;

public class ContactPage extends GeneralPage{
    private  static By contactInformation = By.xpath("//h1[.='Contact Information']");
    private static By seatCode = By.xpath("//b[.='Seatcode: ']");
    private static By phone = By.xpath("//b[.='Phone: ']");
    private static By skype = By.xpath("//b[.='Skype: ']");
    private static By email = By.xpath("//b[.='Email: ']");

}
