package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    protected WebDriver driver ;
    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // Function to insert data into element
    public void insertIntoElements(WebElement element ,String value){
        element.sendKeys(value);
    }

    //Function to Submit Action
    public void clickOnElement(WebElement element){
        element.click();
    }

    public String getElementText(WebElement element){
      return element.getText();
    }

    public void explicitwait(String path){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
    }
}
