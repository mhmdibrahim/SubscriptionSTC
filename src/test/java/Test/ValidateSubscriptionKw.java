package Test;

import Pages.HomePage;
import Pages.PageBase;
import Pages.SecondPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ValidateSubscriptionKw  extends TestBase{
    HomePage home1 ;
    SecondPage secondPage;

    @FindBy(xpath = "//*[@id=\"currency-لايت\"]/i")
    WebElement currency ;
    @FindBy(xpath = "//*[@id=\"country-name\"]")
    WebElement switchCountryButton ;

    @FindBy(xpath = "//*[@id=\"kw\"]")
    WebElement kw ;

    @Test(priority = 1)
    public void TestValidateSubscriptionKw()
    {
        home1 = new HomePage(driver);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home1.waited("//*[@id=\"country-name\"]");
        home1.clickOnElement(switchCountryButton);
//        home.waited("//*[@id=\"kw\"]");
//        home.clickOnElement(kw);
        //assert currency is kw and per month
        Assert.assertEquals(home1.validateCurrency() ,"دينار كويتي/شهر");

        //Asser price is 1.2 for lite Package
        Assert.assertEquals(home1.validatePrice(),"1.2");

        //go to second page
        //click on Start button for Lite Package
        home1.litePackage();
        secondPage = new SecondPage(driver);
        // Assert STC price is 1.2
        Assert.assertEquals(secondPage.vaidatePriceAndCurrency(),"دينار كويتي/شهر");

        //Assert Visa/Master price is 4.8 dollar
        secondPage.visaButtonClick();
        Assert.assertEquals(secondPage.vaidatePriceAndCurrency(),"4.80 دولار أمريكي/الشهر");

    }
}
