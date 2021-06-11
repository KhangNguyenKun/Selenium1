package webdrive;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;


public  class topic_01_check_environment {
    WebDriver driver = new ChromeDriver() ;
    String className= "RNNXgb";
    String gmail= "gb_f";
    Actions actions = new Actions(driver);
    @BeforeClass
    public void  beforeClass() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "/browserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.google.com.vn/");
//        Selenium selenium= new DefaultSelenium()
    }

    @Test
    public void TC_01_ValidateCurrentUrl() {
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl, "https://www.google.com.vn/");
    }

    @Test
    public void TC_02_ValidatePageTitle() {
//        String loginPageTitle = driver.getTitle();
//        Assert.assertEquals(loginPageTitle, "Google");
        Assert.assertTrue(driver.findElement(By.name("q")).isDisplayed());
    }

    @Test
    public void TC_03_NameFormDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//div//div//div//img[@alt='Google']")).isDisplayed());
    }

    @Test
    public void TC_04_InputSearchBoxDisplayed(){
        Assert.assertTrue(driver.findElement(By.className(className)).isDisplayed());
    }
    @Test
    public void TC_04_AlertDisplayed(){
        WebElement Gmail= driver.findElement(By.xpath("//div[@class=\"gb_8d gb_h gb_mg gb_dg\"]//following::a[@class="+ gmail +"]"));
       actions.moveToElement(Gmail);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
