package Test;
import Pages.HomePage;
import Pages.PageBase;
import Pages.SecondPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateSubscriptionSA extends TestBase{
        HomePage home ;
        SecondPage secondPage;


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

        //go to second page
        //click on Start button for Lite Package
        home.litePackage();
        secondPage = new SecondPage(driver);
        // Assert STC price is 15
        Assert.assertEquals(secondPage.vaidatePriceAndCurrency(),"15.00 ريال سعودي/الشهر");

        //Assert Visa/Master price is 20
        secondPage.visaButtonClick();
        Assert.assertEquals(secondPage.vaidatePriceAndCurrency(),"20.00 ريال سعودي/الشهر");

    }



}
