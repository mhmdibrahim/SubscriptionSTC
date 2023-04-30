package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    @BeforeTest
    public void start_driver()
    {
        //Setup a driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //Visit Subscription Website
        String url = "https://subscribe.stctv.com/sa-ar?";
        driver.get(url);
        //Waiting for loading the Page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
    }



}


