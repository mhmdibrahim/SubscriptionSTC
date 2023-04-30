package Test;
import Pages.HomePage;
import Pages.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateSubscriptionSA extends TestBase{
        HomePage home ;
    @FindBy(xpath = "//*[@id=\"currency-لايت\"]/i")
    WebElement currency ;

    @Test(priority = 1)
    public void TestValidateSubscriptionSA()
    {
        home = new HomePage(driver);
        //assert currency is SA and per month
        Assert.assertEquals(home.validateCurrency() ,"ريال سعودي/شهر");

        //Asser price is 15 for lite Package
        Assert.assertEquals(home.validatePrice(),"15");

        //click on Start button for Lite Package
        home.litePackage();

    }



}
