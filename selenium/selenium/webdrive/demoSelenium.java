package webdrive;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class demoSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Go to URL
        driver.get("http://www.google.com/");

        // Maximize Window
        driver.manage().window().maximize();

        // Get Element Email
        WebElement userName = driver.findElement(By.xpath("//div//div//div//img[@alt='Google']"));

        // Khởi tạo một đối tượng Actions mới.
        Actions ref = new Actions (driver);
        // Di chuyển chuột đến phần tử userName và clicl chuột.
        ref.moveToElement(userName).click();
        // Nhấn phím Shift và truyền vào chuỗi lucky.
//        ref.keyDown(userName, Keys.SHIFT).sendKeys(userName, "lucky");
        // Highlight chuỗi vừa nhập và click chuột tại chính phần tử userName đó.
//        ref.keyUp(userName, Keys.SHIFT).doubleClick(userName).contextClick();
        // Phương thức 'build ()' được sử dụng để biên dịch tất cả các danh sách các hành động thành
        // một bước để thực hiện. Sử dụng phương thức perform () khi thực hiện đối tượng Action
        // mà chúng ta đã thiết kế ở trên.
        ref.build().perform();
        // Closing current driver window
        driver.close();
    }
}
