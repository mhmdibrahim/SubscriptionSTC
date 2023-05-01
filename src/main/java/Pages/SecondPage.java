package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondPage extends  PageBase{
    public SecondPage(WebDriver driver) {
        super(driver);
    }
    //wait to load element


    @Override
    public void explicitwait(String path) {
        super.explicitwait("//*[@id=\"order-tier-price\"]/b");
        super.explicitwait("//*[@id=\"cc_ksa-checkbox\"]");
    }

    //Define currency
    @FindBy(id = "order-tier-price")
    WebElement currency ;

    //Define visa_button

    @FindBy(id = "cc_ksa-container")
    WebElement visa_button ;

    public String vaidatePriceAndCurrency(){
        return getElementText(currency);
    }
    public void visaButtonClick(){
        clickOnElement(visa_button);
    }

}
