package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Define Element Start for start lite package
    @FindBy(id = "لايت-selection")
    WebElement Start ;


    //Define Element currency after wait to load the page elements
    public void waited(String path){
        explicitwait(path);
    }

    @FindBy(xpath = "//*[@id=\"currency-لايت\"]/i")
    WebElement currency ;

    //Define price of lite package as price
    @FindBy(xpath = "//*[@id=\"currency-لايت\"]/b")
    WebElement price ;


    // Function to get the Page title
    public void litePackage(){
    clickOnElement(Start);
    }
    public String validateCurrency(){
       return getElementText(currency);
    }

    public String validatePrice(){
        return  getElementText(price);
    }


}
