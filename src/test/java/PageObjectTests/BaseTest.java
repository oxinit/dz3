package PageObjectTests;

import PageObject.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import util.PropertiesReader;

import java.sql.DriverManager;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    private WebDriver driver1;
    String url = new PropertiesReader().getUrl();


  //  private static final String URL="https://rozetka.com.ua";
    @BeforeTest
    public void setUp(){

             chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp(){
        driver1=new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get(url);
    }

    @AfterMethod
    public void tearDown(){
        driver1.close();
    }
    @AfterClass
    public WebDriver getDriver(){
        return driver1;
    }
    public Page Page(){
        return new Page(getDriver());
    }
}
