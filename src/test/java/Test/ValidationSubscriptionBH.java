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

public class ValidationSubscriptionBH extends TestBase{
    HomePage home ;
    SecondPage secondPage;

    @FindBy(xpath = "//*[@id=\"currency-لايت\"]/i")
    WebElement currency ;
    @FindBy(xpath = "//*[@id=\"country-btn\"]")
    WebElement switchCountryButton ;

    @FindBy(xpath = "//*[@id=\"bh\"]")
    WebElement BH ;

    @Test(priority = 1)
    public void TestValidateSubscriptionKw()
    {
        home = new HomePage(driver);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.waited("//*[@id=\"country-btn\"]");
        home.clickOnElement(switchCountryButton);
        home.waited("//*[@id=\"bh\"]");
        home.clickOnElement(BH);
        //assert currency is BH and per month
        Assert.assertEquals(home.validateCurrency() ,"دينار بحريني/شهر");

        //Asser price is 2 for lite Package
        Assert.assertEquals(home.validatePrice(),"2");

        //go to second page
        //click on Start button for Lite Package
        home.litePackage();
        secondPage = new SecondPage(driver);
        // Assert STC price is 2
        Assert.assertEquals(secondPage.vaidatePriceAndCurrency(),"دينار بحريني/شهر");

        //Assert Visa/Master price is 4.8 dollar
        secondPage.visaButtonClick();
        Assert.assertEquals(secondPage.vaidatePriceAndCurrency(),"4.80 دولار أمريكي/الشهر");

    }
}
